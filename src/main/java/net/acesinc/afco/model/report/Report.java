/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.report;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.query.QueryField;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author andrewserff
 */
@Document
public class Report implements Queryable {

    @Id
    private String id;

    private String mappingId;
    private Date creationDate;
    private String remoteId;
    private Map<String, Object> remoteReport;
    private Date lastUpdated;
    private String submittedByUser;
    private String mission;

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        return Arrays.asList();
    }

    @Override
    @JsonIgnore
    public List<String> getNonQueryableFields() {
        return Arrays.asList("remoteReport");
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
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the remoteId
     */
    public String getRemoteId() {
        return remoteId;
    }

    /**
     * @param remoteId the remoteId to set
     */
    public void setRemoteId(String remoteId) {
        this.remoteId = remoteId;
    }

    /**
     * @return the remoteReport
     */
    public Map<String, Object> getRemoteReport() {
        return remoteReport;
    }

    /**
     * @param remoteReport the remoteReport to set
     */
    public void setRemoteReport(Map<String, Object> remoteReport) {
        this.remoteReport = remoteReport;
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
     * @return the submittedByUser
     */
    public String getSubmittedByUser() {
        return submittedByUser;
    }

    /**
     * @param submittedByUser the submittedByUser to set
     */
    public void setSubmittedByUser(String submittedByUser) {
        this.submittedByUser = submittedByUser;
    }

    /**
     * @return the mission
     */
    public String getMission() {
        return mission;
    }

    /**
     * @param mission the mission to set
     */
    public void setMission(String mission) {
        this.mission = mission;
    }
}
