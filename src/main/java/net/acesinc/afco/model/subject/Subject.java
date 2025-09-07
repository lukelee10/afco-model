/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.subject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.classification.Classification;
import net.acesinc.afco.model.query.QueryField;
import net.acesinc.afco.model.view.Views;

/**
 *
 * @author andrewserff
 */
public abstract class Subject implements Queryable {

    @JsonIgnore
    protected static List<String> NON_QUERYABLE_FIELDS = Arrays.asList(
            "AUTOCOMPLETE_DATA_TYPE",
            "NON_QUERYABLE_FIELDS",
            "SPECIAL_CASE_QUERYABLE_FIELDS",
            "classification",
            "type",
            "log",
            "changeLog");

    @JsonIgnore
    protected static List<QueryField> SPECIAL_CASE_QUERYABLE_FIELDS = Collections.emptyList();

    @JsonView(Views.DefaultView.class)
    private String id;

    @JsonView(Views.DefaultView.class)
    private String mappingId;

    @JsonView(Views.DefaultView.class)
    private SubjectType type;

    @JsonView(Views.DefaultView.class)
    private Date lastUpdated;

    @JsonView(Views.FullView.class)
    private Classification classification;

    @JsonView(Views.FullView.class)
    private String ingestSite;

    @JsonView(Views.MapView.class)
    private List<String> collectorIds;

    @JsonView(Views.DefaultView.class)
    private String source;

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
     * @return the type
     */
    public SubjectType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(SubjectType type) {
        this.type = type;
    }

    /**
     * @return the lastUpdated
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }

    /**
     * @param lastUpdated the lastUpdated to set
     */
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
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
     * @return the collectorIds
     */
    public List<String> getCollectorIds() {
        return collectorIds;
    }

    /**
     * @param collectorIds the collectorIds to set
     */
    public void setCollectorIds(List<String> collectorIds) {
        this.collectorIds = collectorIds;
    }

    /**
     * @return String the ELINT data originator source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source String the ELINT data originator source
     */
    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return mappingId + "," + type + "," + lastUpdated + "," + ingestSite + ","
                + (Arrays.toString(new List[] {collectorIds})) + "," + lastUpdated;
    }
}
