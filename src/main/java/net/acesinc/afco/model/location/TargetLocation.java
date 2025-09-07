/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import net.acesinc.afco.model.asip.time.StdTime;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author andrewserff
 */
@Document(collection = "target_location")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TargetLocation extends Location {

    //    @JsonView(Views.DefaultView.class)
    private Double semiMajor;
    //    @JsonView(Views.DefaultView.class)
    private Double semiMinor;
    //    @JsonView(Views.DefaultView.class)
    private Double orientation;
    //    @JsonView(Views.DashboardView.class)
    private String missionName;
    //    @JsonView(Views.DashboardView.class)
    private String idNo;
    //    @JsonView(Views.DefaultView.class)
    /**
     * This is the identifier attribute that is REQUIRED on a TargetLocation element.  The identifier is an xsd:string.
     * HOWEVER, in real life in real-world conditions, this is expected to be an Integer. As a result, the resulting
     * logic in the XSL guarantees this to be either an Integer or for this field to not exist on the ingest.
     * This value is in relation to the ellipse and the related LOBs that came before the ellipse.
     */
    private Integer targetLocIdentifier;

    private StdTime rawTimestamp;
    private Date originGeoTime;
    private StdTime rawOriginGeoTime;
    private Integer numCalcLops;
    private Date timeFirstLop;
    private StdTime rawTimeFirstLop;
    private Date timeLastLop;
    private StdTime rawTimeLastLop;
    private double frequency;
    private double bandwidth;
    private boolean valid;
    private String[] diagnosticText;
    private double elevation;
    private double confidence;
    private Velocity velocityFix;

    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Velocity {
        private boolean valid;
        private String[] diagnosticText;
        private double speed;
        private double speedUncertainty;
        private double heading;
        private double headingUncertainty;
        private String emitterMotion;
        private Ellipse ellipse;
    }

    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Ellipse {
        private Center center;
        private double semiMajor;
        private double semiMinor;
        private double orientation;
        private double confidence;
    }

    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Center {
        private double lat;
        private double lon;
        private double elevation;
    }

    public TargetLocation() {
        setType(LocationType.TARGET);
    }

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "target-location";

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        List<QueryField> specialCaseQueryableFields = new ArrayList<>(Arrays.asList(
                new QueryField("assignmentId", "Assignment ID", FieldType.STRING, "assignmentId", null, false, null),
                new QueryField("mappingId", "Assignment ID", FieldType.STRING, "mappingId", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("idNo", "IDNO", FieldType.STRING, "idNo", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("missionName", "Mission Name", FieldType.STRING, "missionName", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("sensor", "Sensor", FieldType.ENUM, "sensor", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("sensorType", "Sensor Type", FieldType.ENUM, "sensorType", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("source", "Source", FieldType.ENUM, "source", AUTOCOMPLETE_DATA_TYPE)));
        specialCaseQueryableFields.addAll(SPECIAL_CASE_QUERYABLE_FIELDS);

        return specialCaseQueryableFields;
    }
}
