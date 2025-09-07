/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import lombok.*;
import lombok.experimental.SuperBuilder;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.classification.Classification;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author andrewserff
 */
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@SuperBuilder
@ToString
@Document(collection = "location")
public class Location implements Queryable {
    @JsonIgnore
    protected static List<QueryField> SPECIAL_CASE_QUERYABLE_FIELDS =
            Arrays.asList(new QueryField("type", "Location Type", FieldType.LOCATION_TYPE, "type", null, false, null));

    @JsonIgnore
    protected static List<String> NON_QUERYABLE_FIELDS = Arrays.asList(
            "AUTOCOMPLETE_DATA_TYPE", "NON_QUERYABLE_FIELDS", "SPECIAL_CASE_QUERYABLE_FIELDS", "classification");

    //    @JsonView(Views.DefaultView.class)
    private String id;
    //    @JsonView(Views.DefaultView.class)
    private Date timestamp;

    /**
     * When something enters the system. The XSL will obtain this time.
     */
    //    @JsonView(Views.DefaultView.class)
    private Date ingestTime;
    //    @JsonView(Views.DefaultView.class)
    private Point point;
    //    @JsonView(Views.DefaultView.class)
    private LocationType type;
    //    @JsonView(Views.DefaultView.class)
    private Classification classification;

    /**
     * The mappingId is either: 1) msnNo+_+idNo 2) missionName+_+idNo 3)
     * missionId+_+signalId
     */
    //    @JsonView(Views.DefaultView.class)
    private String mappingId;
    //    @JsonView(Views.FullView.class)
    private String ingestSite;
    private String sensor;
    private String sensorType;
    private String source;

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
}
