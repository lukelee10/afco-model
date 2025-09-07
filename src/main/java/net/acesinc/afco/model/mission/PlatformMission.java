/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.mission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.classification.Classification;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;

/**
 *
 * @author jeremytaylor
 */
public class PlatformMission implements Queryable {

    private String id;
    private String missionName;
    /**
     * missionId is guaranteed to be unique
     */
    private String missionId;

    private Date startTime;
    private Date stopTime;
    private String missionTheater;
    private String missionRoute;
    private String sigad;
    private String pddg;
    private Date lastUpdated;
    private Classification classification;
    private String ingestSite;

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "platform-mission";

    @JsonIgnore
    protected static List<String> NON_QUERYABLE_FIELDS = Arrays.asList(
            "AUTOCOMPLETE_DATA_TYPE",
            "NON_QUERYABLE_FIELDS",
            "SPECIAL_CASE_QUERYABLE_FIELDS",
            "SELF",
            "classification");

    @JsonIgnore
    protected static List<QueryField> SPECIAL_CASE_QUERYABLE_FIELDS = Arrays.asList(
            new QueryField("ingestSite", "Ingest Site", FieldType.ENUM, "ingestSite", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("missionId", "Mission ID", FieldType.STRING, "missionId", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("missionName", "Mission Name", FieldType.STRING, "missionName", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("missionRoute", "Mission Route", FieldType.STRING, "missionRoute", AUTOCOMPLETE_DATA_TYPE),
            new QueryField(
                    "missionTheater", "Mission Theater", FieldType.ENUM, "missionTheater", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("pddg", "PDDG", FieldType.ENUM, "pddg", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("sigad", "Sigad", FieldType.ENUM, "sigad", AUTOCOMPLETE_DATA_TYPE));

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
     * @return the missionName
     */
    public String getMissionName() {
        return missionName;
    }

    /**
     * @param missionName the missionName to set
     */
    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    /**
     * @return the missionId
     */
    public String getMissionId() {
        return missionId;
    }

    /**
     * @param missionId the missionId to set
     */
    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    /**
     * @return the startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the stopTime
     */
    public Date getStopTime() {
        return stopTime;
    }

    /**
     * @param stopTime the stopTime to set
     */
    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    /**
     * @return the missionTheater
     */
    public String getMissionTheater() {
        return missionTheater;
    }

    /**
     * @param missionTheater the missionTheater to set
     */
    public void setMissionTheater(String missionTheater) {
        this.missionTheater = missionTheater;
    }

    /**
     * @return the missionRoute
     */
    public String getMissionRoute() {
        return missionRoute;
    }

    /**
     * @param missionRoute the missionRoute to set
     */
    public void setMissionRoute(String missionRoute) {
        this.missionRoute = missionRoute;
    }

    /**
     * @return the sigad
     */
    public String getSigad() {
        return sigad;
    }

    /**
     * @param sigad the sigad to set
     */
    public void setSigad(String sigad) {
        this.sigad = sigad;
    }

    /**
     * @return the pddg
     */
    public String getPddg() {
        return pddg;
    }

    /**
     * @param pddg the pddg to set
     */
    public void setPddg(String pddg) {
        this.pddg = pddg;
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
}
