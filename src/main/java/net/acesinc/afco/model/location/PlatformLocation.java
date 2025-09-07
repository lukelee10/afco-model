/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author andrewserff
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@AllArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
@Document(collection = "platform_location")
public class PlatformLocation extends Location {

    /**
     * DEPRECATED NOTES from long ago on collectorId -- PRE-ASIP: 1) collectorId = missionName for COMINT -- See #3
     * and #4. 2) collectorId seems to be at least 2 digits for ELINT, but they
     * could be longer and only have digits. 3) missionNames (COMINT) can be no
     * greater than 14 character lengths long based on the spec. 4) missionNames
     * (COMINT) have to be at least 5 character lengths long due to assumption,
     * but based on observations and to deviate them from ELINT collectorIds.
     */
    //    @JsonView(Views.DefaultView.class)
    protected String collectorId;

    @JsonProperty(required = false)
    protected String missionId;

    protected String opExTestFlag;
    protected String sortieUuid;

    protected String aor;

    /**
     * sensorId for now only occurs in CollectorNavigation XML on NMPG systems
     * and NOT AE. Thus, this must be optional.
     */
    @JsonProperty(required = false)
    protected String sensorId;
    //    @JsonView(Views.DefaultView.class)
    private Double elevation;
    //    @JsonView(Views.DefaultView.class)
    private Double heading;
    //    @JsonView(Views.DefaultView.class)
    private Double pitch;
    //    @JsonView(Views.DefaultView.class)
    private Double roll;
    //    @JsonView(Views.DashboardView.class)
    protected String pddg;
    //    @JsonView(Views.DashboardView.class)
    protected String sigad;

    private Date sampleTime;
    private Double speed;
    private Map<String, String> sensorSpecificMetadata = new HashMap<>();

    public PlatformLocation() {
        setType(LocationType.PLATFORM);
    }

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "platform-location";

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        List<QueryField> specialCaseQueryableFields = new ArrayList<QueryField>(Arrays.asList(
                new QueryField("collectorId", "Collector ID", FieldType.STRING, "collectorId", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("ingestSite", "Ingest Site", FieldType.ENUM, "ingestSite", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("mappingId", "Assignment ID", FieldType.STRING, "mappingId", null, false, null),
                new QueryField("missionId", "Mission ID", FieldType.STRING, "missionId", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("pddg", "PDDG", FieldType.ENUM, "pddg", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("sigad", "Sigad", FieldType.ENUM, "sigad", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("sensorId", "Sensor ID", FieldType.STRING, "sensorId", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("sensor", "Sensor", FieldType.ENUM, "sensor", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("sensorType", "Sensor Type", FieldType.ENUM, "sensorType", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("source", "Source", FieldType.ENUM, "source", AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "opExTestFlag",
                        "Operation Exercise Test Flag",
                        FieldType.ENUM,
                        "opExTestFlag",
                        AUTOCOMPLETE_DATA_TYPE)));
        specialCaseQueryableFields.addAll(SPECIAL_CASE_QUERYABLE_FIELDS);

        return specialCaseQueryableFields;
    }
}
