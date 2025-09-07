/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.classification.Classification;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author andrewserff
 */
@Document(collection = "aadf")
public class AADF {
    @Id
    private String id;
    /**
     * SUL is a combo of msnNo and idNo
     */
    @Field("SUL")
    private String sul;

    private String msnNo;
    private String idNo;
    private Double freq;

    @Field("modtype")
    private Integer modulationType;

    @Field("bw")
    private Integer bandwidth;
    /**
     * assignUpTime is an entry or SUL, and so this can really just be a current timestamp for now
     * also, the first assignUpTime could be the firstUpTime
     */
    @Field("assign-up-time")
    private Date assignUpTime;
    /**
     * assignDownTime is an entry or sUL, and so this can also really just be a current timestamp for now
     * also, the last assignDownTime could be the lastDownTime
     */
    @Field("assign-down-time")
    private Date assignDownTime;
    /**
     * time from a location point needs to fall at or past this firstUpTime
     * also, the first assignUpTime could be the firstUpTime
     */
    @Field("first-up-time")
    private Date firstUpTime;
    /**
     * time from a location point needs to fall at or before this lastDownTime
     * also, the last assignDownTime could be the lastDownTime
     */
    @Field("last-down-time")
    private Date lastDownTime;
    /**
     * this lastOpSignTime should for now fall at or below the lastDownTime
     */
    @Field("last-opsign-time")
    private Date lastOpSignTime;

    @Field("casenot")
    private String caseNot;
    // unable to determine from data model what this stands for
    private String rasin;
    private Classification classification;

    @Field("core-site")
    private String coreSite;

    @Field("dms-sites")
    private String dmsSites;

    private String position;
    private String grapevineReportId;
    /** the gv comment field was in the data model, but is not*/
    private String grapevineComment;

    private String klReportId;

    @Field("datamsg")
    private String dataMsg;

    private AADFType type;
    private String lineText;
    private List<ProcessorResult> languageProcessorResults = new ArrayList<>();

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
     * @return the sul
     */
    public String getSul() {
        return sul;
    }

    /**
     * @param sul the sul to set
     */
    public void setSul(String sul) {
        this.sul = sul;
    }

    /**
     * @return the msnNo
     */
    public String getMsnNo() {
        return msnNo;
    }

    /**
     * @param msnNo the msnNo to set
     */
    public void setMsnNo(String msnNo) {
        this.msnNo = msnNo;
    }

    /**
     * @return the idNo
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * @param idNo the idNo to set
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    /**
     * @return the freq
     */
    public Double getFreq() {
        return freq;
    }

    /**
     * @param freq the freq to set
     */
    public void setFreq(Double freq) {
        this.freq = freq;
    }

    /**
     * @return the modulationType
     */
    public Integer getModulationType() {
        return modulationType;
    }

    /**
     * @param modulationType the modulationType to set
     */
    public void setModulationType(Integer modulationType) {
        this.modulationType = modulationType;
    }

    /**
     * @return the bandwidth
     */
    public Integer getBandwidth() {
        return bandwidth;
    }

    /**
     * @param bandwidth the bandwidth to set
     */
    public void setBandwidth(Integer bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     * @return the assignUpTime
     */
    public Date getAssignUpTime() {
        return assignUpTime;
    }

    /**
     * @param assignUpTime the assignUpTime to set
     */
    public void setAssignUpTime(Date assignUpTime) {
        this.assignUpTime = assignUpTime;
    }

    /**
     * @return the assignDownTime
     */
    public Date getAssignDownTime() {
        return assignDownTime;
    }

    /**
     * @param assignDownTime the assignDownTime to set
     */
    public void setAssignDownTime(Date assignDownTime) {
        this.assignDownTime = assignDownTime;
    }

    /**
     * @return the firstUpTime
     */
    public Date getFirstUpTime() {
        return firstUpTime;
    }

    /**
     * @param firstUpTime the firstUpTime to set
     */
    public void setFirstUpTime(Date firstUpTime) {
        this.firstUpTime = firstUpTime;
    }

    /**
     * @return the lastDownTime
     */
    public Date getLastDownTime() {
        return lastDownTime;
    }

    /**
     * @param lastDownTime the lastDownTime to set
     */
    public void setLastDownTime(Date lastDownTime) {
        this.lastDownTime = lastDownTime;
    }

    /**
     * @return the lastOpSignTime
     */
    public Date getLastOpSignTime() {
        return lastOpSignTime;
    }

    /**
     * @param lastOpSignTime the lastOpSignTime to set
     */
    public void setLastOpSignTime(Date lastOpSignTime) {
        this.lastOpSignTime = lastOpSignTime;
    }

    /**
     * @return the caseNot
     */
    public String getCaseNot() {
        return caseNot;
    }

    /**
     * @param caseNot the caseNot to set
     */
    public void setCaseNot(String caseNot) {
        this.caseNot = caseNot;
    }

    /**
     * @return the rasin
     */
    public String getRasin() {
        return rasin;
    }

    /**
     * @param rasin the rasin to set
     */
    public void setRasin(String rasin) {
        this.rasin = rasin;
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
     * @return the coreSite
     */
    public String getCoreSite() {
        return coreSite;
    }

    /**
     * @param coreSite the coreSite to set
     */
    public void setCoreSite(String coreSite) {
        this.coreSite = coreSite;
    }

    /**
     * @return the dmsSites
     */
    public String getDmsSites() {
        return dmsSites;
    }

    /**
     * @param dmsSites the dmsSites to set
     */
    public void setDmsSites(String dmsSites) {
        this.dmsSites = dmsSites;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the grapevineReportId
     */
    public String getGrapevineReportId() {
        return grapevineReportId;
    }

    /**
     * @param grapevineReportId the grapevineReportId to set
     */
    public void setGrapevineReportId(String grapevineReportId) {
        this.grapevineReportId = grapevineReportId;
    }

    /**
     * @return the grapevineComment
     */
    public String getGrapevineComment() {
        return grapevineComment;
    }

    /**
     * @param grapevineComment the grapevineComment to set
     */
    public void setGrapevineComment(String grapevineComment) {
        this.grapevineComment = grapevineComment;
    }

    /**
     * @return the dataMsg
     */
    public String getDataMsg() {
        return dataMsg;
    }

    /**
     * @param dataMsg the dataMsg to set
     */
    public void setDataMsg(String dataMsg) {
        this.dataMsg = dataMsg;
    }

    /**
     * @return the type
     */
    public AADFType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(AADFType type) {
        this.type = type;
    }

    /**
     * @return the lineText
     */
    public String getLineText() {
        return lineText;
    }

    /**
     * @param lineText the lineText to set
     */
    public void setLineText(String lineText) {
        this.lineText = lineText;
    }

    /**
     * @return the klReportId
     */
    public String getKlReportId() {
        return klReportId;
    }

    /**
     * @param klReportId the klReportId to set
     */
    public void setKlReportId(String klReportId) {
        this.klReportId = klReportId;
    }

    /**
     * @return the languageProcessorResults
     */
    public List<ProcessorResult> getLanguageProcessorResults() {
        return languageProcessorResults;
    }

    /**
     * @param languageProcessorResults the languageProcessorResults to set
     */
    public void setLanguageProcessorResults(List<ProcessorResult> languageProcessorResults) {
        this.languageProcessorResults = languageProcessorResults;
    }
}
