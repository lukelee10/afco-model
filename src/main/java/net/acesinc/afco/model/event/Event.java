/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.classification.Classification;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import net.acesinc.afco.model.view.Views;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author andrewserff
 */
@Document(collection = "event")
public abstract class Event implements Queryable {
    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "event";

    @JsonIgnore
    protected static List<QueryField> SPECIAL_CASE_QUERYABLE_FIELDS = Arrays.asList(
            new QueryField("mappingId", "Mapping Id", FieldType.STRING, "mappingId", null, false, null),
            new QueryField("ingestSite", "Ingest Site", FieldType.ENUM, "ingestSite", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("type", "Type", FieldType.ENUM, "type", AUTOCOMPLETE_DATA_TYPE));

    @JsonIgnore
    protected List<String> NON_QUERYABLE_FIELDS = Arrays.asList(
            "AUTOCOMPLETE_DATA_TYPE",
            "NON_QUERYABLE_FIELDS",
            "SPECIAL_CASE_QUERYABLE_FIELDS",
            "classification",
            "source");

    @JsonView(Views.DefaultView.class)
    private String id;

    @JsonView(Views.FullView.class)
    private String source;

    @JsonView(Views.FullView.class)
    private String ingestSite;

    @JsonView(Views.DefaultView.class)
    private Classification classification;

    @JsonView(Views.DefaultView.class)
    private EventType type;

    @JsonView(Views.DefaultView.class)
    private Date timestamp;
    /**
     * The ingestTime field is being used by non-updating Events to help us know
     * when something entered the system. This was originally only used by
     * DataForwardEvents as it had no time field.
     */
    @JsonView(Views.DefaultView.class)
    private Date ingestTime;
    /**
     * The mappingId is either: 1) msnNo+_+idNo 2) missionName+_+idNo 3)
     * missionId+_+signalId 4) for dataForward --> missionName+_+epochLong
     */
    @JsonView(Views.DefaultView.class)
    private String mappingId;

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
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the classification
     */
    public Classification getClassification() {
        return classification;
    }

    /**
     * @param classification the classification to set
     */
    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    /**
     * @return the type
     */
    public EventType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(EventType type) {
        this.type = type;
    }

    /**
     * @return the mappingId
     */
    public String getMappingId() {
        return mappingId;
    }

    /**
     * @param mappingId the mappingId to set
     */
    public void setMappingId(String mappingId) {
        this.mappingId = mappingId;
    }

    /**
     * @return the ingestSite
     */
    public String getIngestSite() {
        return ingestSite;
    }

    /**
     * @param ingestSite the ingestSite to set
     */
    public void setIngestSite(String ingestSite) {
        this.ingestSite = ingestSite;
    }

    /**
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the ingestTime
     */
    public Date getIngestTime() {
        return ingestTime;
    }

    /**
     * @param ingestTime the ingestTime to set
     */
    public void setIngestTime(Date ingestTime) {
        this.ingestTime = ingestTime;
    }
}
