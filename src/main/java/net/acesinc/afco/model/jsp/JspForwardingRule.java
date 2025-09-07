package net.acesinc.afco.model.jsp;

import com.fasterxml.jackson.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import net.acesinc.afco.model.distribution.DistributionLog;
import org.apache.commons.beanutils.PropertyUtils;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "jspForwardingRule")
@JsonPropertyOrder({
    "id",
    "name",
    "site",
    "machine",
    "host",
    "conditions",
    "owner",
    "active",
    "recurringStartTime",
    "recurringEndTime",
    "createdDate",
    "expirationDate"
})
@Slf4j
public class JspForwardingRule {
    public static final String DUPLICATE_FIELDS =
            "Two conditions added for same field in a JspForwarding rule (%s), ref: %s";

    @Id
    private String id;

    private String name;

    private String owner;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date createdDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
    private Date expirationDate;

    private String site;

    private String machine;

    private String host;

    private boolean active;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date recurringStartTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date recurringEndTime;

    @JsonIgnore
    private List<Condition> conditions;

    @BsonIgnore // This annotation excludes this field from Mongo, but not from serialization during service calls
    private List<DistributionLog> distros;

    @JsonGetter
    public List<Condition> getConditions() {
        return Collections.unmodifiableList(conditions);
    }

    @JsonSetter
    public void setConditions(List<Condition> conditions) {
        if (conditions != null) {
            conditions.forEach(this::addCondition);
        }
    }

    @JsonIgnore
    public Condition getCondition(Condition.Field field) {
        return conditions.stream()
                .filter(condition -> field.equals(condition.getField()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    if (list.size() > 1) {
                        throw new IllegalStateException();
                    }
                    return list.isEmpty() ? null : list.get(0);
                }));
    }

    public JspForwardingRule() {
        this.conditions = new ArrayList<>();
        this.active = true;
    }

    public JspForwardingRule(String name, String owner, String site, String machine, String host) {
        this();
        this.name = name;
        this.owner = owner;
        this.site = site;
        this.machine = machine;
        this.host = host;
    }

    @NoArgsConstructor
    public static class Condition {
        public enum Field {
            CASENOTS("casenots", List.class),
            CONTENT_TYPE("contentType", List.class),
            FREQUENCY("frequency", Double.class),
            MISSION_ID("missionId", String.class),
            OPERATOR_ID("operatorId", String.class),
            SIGAD("sigad", String.class),
            SIG_ID("sigId", String.class);

            private String fieldName;
            private Class type;

            Field(String fieldName, Class<?> type) {
                this.fieldName = fieldName;
                this.type = type;
            }
        }

        private Condition(Field field) {
            this.field = field;
        }

        public Condition(Field field, String[] strings) {
            this(field);
            this.values = strings;
        }

        public Condition(Field field, String string) {
            this(field);
            this.value = string;
        }

        public Condition(Field field, Double[] doubles) {
            this(field);
            this.values = doubles;
        }

        public Condition(Field field, Double dubble) {
            this(field);
            this.value = dubble;
        }

        @Getter
        Field field;

        @Getter
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Object[] values;

        @Getter
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Object value;

        @JsonIgnore
        public String getFieldName() {
            return field.fieldName;
        }

        @JsonIgnore
        public Class<?> getFieldType() {
            return field.type;
        }

        public boolean matches(Object objToCompare) {
            boolean matches = false;

            try {
                Object objToCompareFieldVal = PropertyUtils.getProperty(objToCompare, getFieldName());
                matches = objToCompareFieldVal != null
                        && ((objToCompareFieldVal.equals(this.value))
                                || (this.values != null
                                        && Arrays.asList(this.values).contains(objToCompareFieldVal)));
                // we shouldn't have model classes with inaccessible properties
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                matches = false;
            }

            return matches;
        }

        @Override
        public String toString() {
            return "Condition{" + "field=" + field + ", values=" + Arrays.toString(values) + ", value=" + value + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Condition condition = (Condition) o;
            return field == condition.field
                    && Objects.deepEquals(values, condition.values)
                    && Objects.equals(value, condition.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(field, Arrays.hashCode(values), value);
        }
    }

    public void addCondition(Condition toAdd) {
        if (conditions.stream().anyMatch(condition -> toAdd.getField().equals(condition.getField()))) {
            String errorMessage = String.format(DUPLICATE_FIELDS, name, toAdd.getFieldName());
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        conditions.add(toAdd);
    }
}
