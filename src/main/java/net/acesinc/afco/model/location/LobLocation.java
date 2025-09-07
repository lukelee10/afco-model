/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.*;
import lombok.experimental.SuperBuilder;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * LobLocation most closely represents PlatformLocation due to the collectorId
 * existence than the pure Location class. The other fields within platform
 * location do not related to what is in a LobLocation record.
 *
 * @author jeremytaylor
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@Document(collection = "lob_location")
public class LobLocation extends PlatformLocation {

    //    @JsonView(Views.DefaultView.class)
    private LobType lobType;
    //    @JsonView(Views.DefaultView.class)
    private Double lineOfBearing;
    //    @JsonView(Views.DefaultView.class)
    private String parentId;
    /**
     * This is the identifier attribute that is REQUIRED on the PARENT TargetLocation element of the LOB.
     * The TargetLocation's identifier is an xsd:string. HOWEVER, in real life in real-world conditions, this is
     * expected to be an Integer. As a result, the resulting logic in the XSL guarantees this to be either
     * an Integer or for this field to not exist on the ingest.
     */
    private Long targetLocIdentifier;

    private String assignmentId;
    protected Double bw;
    private String caseNotation;
    private Double frequency;
    private String keyword;
    private String opSid;
    private Integer quality;
    private String sigId;
    private Double snr;

    public LobLocation() {
        setType(LocationType.LOB_LOCATION);
    }

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "lob";

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        List<QueryField> specialCaseQueryableFields = new ArrayList<>(Arrays.asList(
                new QueryField("assignmentId", "Assignment ID", FieldType.STRING, "assignmentId", null, false, null),
                new QueryField("mappingId", "Assignment ID", FieldType.STRING, "mappingId", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("lobType", "Lob Type", FieldType.LOB_TYPE),
                new QueryField("missionId", "Mission ID", FieldType.STRING, "missionId", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("parentId", "Parent ID", FieldType.STRING, "parentId", null, false, null),
                new QueryField("sensor", "Sensor", FieldType.ENUM, "sensor", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("sensorType", "Sensor Type", FieldType.ENUM, "sensorType", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("source", "Source", FieldType.ENUM, "source", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("timestamp", "Timestamp", FieldType.DATE)));
        specialCaseQueryableFields.addAll(SPECIAL_CASE_QUERYABLE_FIELDS);

        return specialCaseQueryableFields;
    }
}
