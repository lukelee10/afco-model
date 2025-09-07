package net.acesinc.afco.model.distribution;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.classification.Classification;
import net.acesinc.afco.model.mission.MissionData;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Getter
@Setter
@Document(collection = "distributionLog")
public class DistributionLog implements Queryable {

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "distribution-log";

    @JsonIgnore
    protected static List<String> NON_QUERYABLE_FIELDS = Arrays.asList(
            "AUTOCOMPLETE_DATA_TYPE",
            "NON_QUERYABLE_FIELDS",
            "SPECIAL_CASE_QUERYABLE_FIELDS",
            "SELF",
            "classification",
            "log");

    @JsonIgnore
    protected static List<QueryField> SPECIAL_CASE_QUERYABLE_FIELDS = Arrays.asList(
            new QueryField(
                    "absoluteFilePath", "Absolute File Path", FieldType.STRING, "absoluteFilePath", null, false, null),
            new QueryField("collectionId", "Collection ID", FieldType.STRING, "collectionId", null, false, null),
            new QueryField("collectionName", "Collection Name", FieldType.STRING, "collectionName", null, false, null),
            new QueryField("dataFileId", "Data File ID", FieldType.STRING, "dataFileId", null, false, null),
            new QueryField(
                    "destinationResponse",
                    "Destination Response",
                    FieldType.STRING,
                    "destinationResponse",
                    null,
                    false,
                    null),
            new QueryField("parentId", "Parent ID", FieldType.STRING, "parentId", null, false, null),
            new QueryField(
                    "parentMappingId", "Parent Mapping ID", FieldType.STRING, "parentMappingId", null, false, null),
            new QueryField("failedAttempts", "Failed Attempts", FieldType.INTEGER, "failedAttempts", null, true, null),
            new QueryField(
                    "type", "Type", FieldType.DISTRIBUTION_DATA_TYPE, "type", AUTOCOMPLETE_DATA_TYPE, true, null),
            new QueryField(
                    "destination",
                    "Destination",
                    FieldType.DESTINATION,
                    "destination",
                    AUTOCOMPLETE_DATA_TYPE,
                    true,
                    null),
            new QueryField(
                    "status",
                    "Status of Distribution",
                    FieldType.DISTRIBUTION_STATUS,
                    "status",
                    AUTOCOMPLETE_DATA_TYPE,
                    true,
                    null),
            new QueryField("user", "User", FieldType.STRING, "user", AUTOCOMPLETE_DATA_TYPE, true, null),
            new QueryField(
                    "statusMessage",
                    "Status Message",
                    FieldType.STRING,
                    "statusMessage",
                    AUTOCOMPLETE_DATA_TYPE,
                    true,
                    null),
            new QueryField("userDn", "User DN", FieldType.STRING, "collectionId", null, false, null),
            new QueryField("opNote", "Operator Note", FieldType.STRING, "opNote", null, true, null));

    private String absoluteFilePath;
    private Classification classification;
    private String collectionId;
    private String collectionName;
    private Destination destination;
    private int failedAttempts;
    private String id;
    /**
     * Parent ID is used to indicate that this DistributionLog record was created by a user parent record automatically,
     * either when the initial record fails and a retry record is created or when the parent has a child record of type FILE.
     */
    private String parentId;
    /**
     * Parent Data File ID is used if this distribution log entry is for distributing a file. Note that it will be populated for both
     * the parent entry and child FILE entry.
     */
    private String parentDataFileId;

    private String parentMappingId;
    private DistributionStatus status;
    private String statusMessage;
    private Date startTime;
    private Date stopTime;
    private Date timestamp;
    private DistributionDataType type;
    private String user;
    private String userDn;
    private boolean autoDistributed;
    private String destinationResponse;
    private String modulation = "";
    private List<String> casenots = new ArrayList<String>();
    private JspMetadata jspMetadata;

    private String source;

    /**
     * missionData w/ missionIds:  Due to Unwrapped annotation, please only pass in as "missionIds":["item1","item2"]
     * AND NOT "missionData" : {"missionIds":["item1","item2"] }
     * Why? Was unable to get to deserialize properly otherwise on this ArrayList beneath it w/o this.
     */
    @JsonProperty(required = false)
    @JsonUnwrapped
    private MissionData missionData;

    /**
     * The operator note for this specific distribution log entry
     */
    private String opNote;

    public DistributionLog(String user) {
        super();
        this.user = user;
        this.timestamp = new Date();
    }

    /**
     * Copy constructor that includes only the fields that should be copied for a new DistributionLog entry. The following
     * fields are not copied since they apply only to parent entry and not the new one:
     * - absoluteFilePath
     * - id
     * - status
     * - statusMessage
     * - startTime
     * - stopTime
     * - timestamp
     *
     * @param distributionLog distribution log bean
     */
    public DistributionLog(DistributionLog distributionLog) {
        super();
        this.casenots = distributionLog.getCasenots();
        this.classification = distributionLog.getClassification();
        this.collectionId = distributionLog.getCollectionId();
        this.collectionName = distributionLog.getCollectionName();
        this.parentDataFileId = distributionLog.getParentDataFileId();
        this.destination = distributionLog.getDestination();
        this.failedAttempts = distributionLog.getFailedAttempts();
        this.modulation = distributionLog.getModulation();
        this.parentId = distributionLog.getParentId();
        this.parentMappingId = distributionLog.getParentMappingId();
        this.timestamp = new Date();
        this.type = distributionLog.getType();
        this.user = distributionLog.getUser();
        this.userDn = distributionLog.getUserDn();
        this.autoDistributed = distributionLog.isAutoDistributed();
        this.missionData = distributionLog.getMissionData();
        this.opNote = distributionLog.getOpNote();
        this.jspMetadata = distributionLog.getJspMetadata();
        this.source = distributionLog.getSource();
    }

    public DistributionLog() {
        super();
    }

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        return SPECIAL_CASE_QUERYABLE_FIELDS;
    }

    @Override
    @JsonIgnore
    public List<String> getNonQueryableFields() {
        return NON_QUERYABLE_FIELDS;
    }

    @Override
    @JsonIgnore
    public List<Class<? extends Queryable>> getQueryableSubclasses() {
        return Collections.emptyList();
    }

    /**
     * @return the modulation if set, otherwise empty string
     */
    @NonNull
    public String getModulation() {
        return modulation;
    }

    /**
     * @return the casenots list if set, otherwise empty list
     */
    @NonNull
    public List<String> getCasenots() {
        return casenots;
    }

    @Override
    public String toString() {
        return "DistributionLog{" + "absoluteFilePath='"
                + absoluteFilePath + '\'' + ", casenots="
                + casenots + ", classification="
                + classification + ", collectionId='"
                + collectionId + '\'' + ", collectionName='"
                + collectionName + '\'' + ", parentDataFileId='"
                + parentDataFileId + '\'' + ", destination="
                + destination + ", failedAttempts="
                + failedAttempts + ", id='"
                + id + '\'' + ", modulation="
                + modulation + ", parentId='"
                + parentId + '\'' + ", parentMappingId='"
                + parentMappingId + '\'' + ", status="
                + status + ", statusMessage='"
                + statusMessage + '\'' + ", startTime="
                + startTime + ", stopTime="
                + stopTime + ", timestamp="
                + timestamp + ", type="
                + type + ", user='"
                + user + '\'' + ", userDn='"
                + userDn + '\'' + ", autoDistributed="
                + autoDistributed + ", destinationResponse='"
                + destinationResponse + '\'' + ", opNote='"
                + opNote + '\'' + ", missionData="
                + missionData + '\'' + ", jspMetadata="
                + jspMetadata + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistributionLog that = (DistributionLog) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
