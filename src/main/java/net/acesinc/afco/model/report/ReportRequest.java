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
import net.acesinc.afco.model.AADF;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.query.QueryField;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author andrewserff
 */
@Document(collection = "reportRequest")
public class ReportRequest extends AADF implements Queryable {

    private String aadfId;
    private String user;
    private Date requestedDate;
    private String reportComment;
    private ReportRequestState state;
    private String reportServiceResponse;
    private ReportType reportType;

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        return Arrays.asList();
    }

    @Override
    @JsonIgnore
    public List<String> getNonQueryableFields() {
        return Arrays.asList("classification");
    }

    @Override
    @JsonIgnore
    public List<Class<? extends Queryable>> getQueryableSubclasses() {
        return Collections.emptyList();
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the reportComment
     */
    public String getReportComment() {
        return reportComment;
    }

    /**
     * @param reportComment the reportComment to set
     */
    public void setReportComment(String reportComment) {
        this.reportComment = reportComment;
    }

    /**
     * @return the requestedDate
     */
    public Date getRequestedDate() {
        return requestedDate;
    }

    /**
     * @param requestedDate the requestedDate to set
     */
    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    /**
     * @return the state
     */
    public ReportRequestState getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(ReportRequestState state) {
        this.state = state;
    }

    /**
     * @return the reportServiceResponse
     */
    public String getReportServiceResponse() {
        return reportServiceResponse;
    }

    /**
     * @param reportServiceResponse the reportServiceResponse to set
     */
    public void setReportServiceResponse(String reportServiceResponse) {
        this.reportServiceResponse = reportServiceResponse;
    }

    /**
     * @return the aadfId
     */
    public String getAadfId() {
        return aadfId;
    }

    /**
     * @param aadfId the aadfId to set
     */
    public void setAadfId(String aadfId) {
        this.aadfId = aadfId;
    }

    /**
     * @return the reportType
     */
    public ReportType getReportType() {
        return reportType;
    }

    /**
     * @param reportType the reportType to set
     */
    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }
}
