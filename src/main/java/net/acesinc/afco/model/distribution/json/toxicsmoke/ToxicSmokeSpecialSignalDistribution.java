package net.acesinc.afco.model.distribution.json.toxicsmoke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.event.Comment;

/**
 * This is a Toxicsmoke specific solution to marshall and demarshall JSON.
 * A service call from NiFi imposes the demarshalling need of this class to exist in afco-model along w/ its
 * related class dependency instead of being relocated to the integration service area where the Toxic Smoke service
 * would mainly only be able to take advantage of it.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToxicSmokeSpecialSignalDistribution {

    private String classification;
    private String missionId;
    private String idNo;
    /**
     * See {@link net.acesinc.afco.model.special.signal.SpecialSignal#startTime startTime} for details
     */
    private Date startTime;
    /**
     * See {@link net.acesinc.afco.model.special.signal.SpecialSignal#stopTime stopTime} for details
     */
    private Date stopTime;

    private Date lastUpdated;
    private String ingestSite;
    private List<String> casenotation = new ArrayList<>();
    private List<String> category = new ArrayList<>();
    private String sigad;
    private Double frequency;
    private Double bw;
    private Integer priority;
    /**
     * See {@link net.acesinc.afco.model.special.signal.SpecialSignal#modType modType} for details
     */
    private String modType;
    /**
     * opNoteJournal is likely something that toxic smoke doesn't give or doesn't want.
     */
    @JsonIgnore
    private List<Comment> opNoteJournal = new ArrayList<>();

    private String opNote;
    private String keyword;
    private String pddg;
    private Boolean highPriority;
    private String status;
    private String taskId;
    private String dataFormat;
    private String sigId;
    private String operatorId;
    /**
     * See {@link net.acesinc.afco.model.special.signal.SpecialSignal#modulation modulation} for details
     */
    private String modulation;

    private Double keyspeed;
    private String opSid;
    private ToxicSmokeLocationDistribution location;
    /**
     * See {@link net.acesinc.afco.model.special.signal.SpecialSignal#streamSampleRate streamSampleRate} for details
     */
    private Double streamSampleRate;

    private String referenceUrl;

    private List<String> associatedFiles = new ArrayList<>();

    /**
     * No args constructor
     */
    public ToxicSmokeSpecialSignalDistribution() {
        super();
    }

    /**
     * @return the classification
     */
    public String getClassification() {
        return classification;
    }

    /**
     * @param classification the classification to set
     */
    public void setClassification(String classification) {
        this.classification = classification;
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
     * @return the casenotation
     */
    public List<String> getCasenotation() {
        return casenotation;
    }

    /**
     * @param casenotation the casenotation to set
     */
    public void setCasenotation(List<String> casenotation) {
        this.casenotation = casenotation;
    }

    /**
     * @return the category
     */
    public List<String> getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(List<String> category) {
        this.category = category;
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
     * @return the frequency
     */
    public Double getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    /**
     * @return the bw
     */
    public Double getBw() {
        return bw;
    }

    /**
     * @param bw the bw to set
     */
    public void setBw(Double bw) {
        this.bw = bw;
    }

    /**
     * @return the priority
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * @return the modType
     */
    public String getModType() {
        return modType;
    }

    /**
     * @param modType the modType to set
     */
    public void setModType(String modType) {
        this.modType = modType;
    }

    public void setOpNote(String opNote) {
        this.opNote = opNote;
    }

    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
     * @return the highPriority
     */
    public Boolean getHighPriority() {
        return highPriority;
    }

    /**
     * @param highPriority the highPriority to set
     */
    public void setHighPriority(Boolean highPriority) {
        this.highPriority = highPriority;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the taskId
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * @param taskId the taskId to set
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * @return the dataFormat
     */
    public String getDataFormat() {
        return dataFormat;
    }

    /**
     * @param dataFormat the dataFormat to set
     */
    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }

    /**
     * @return the sigId
     */
    public String getSigId() {
        return sigId;
    }

    /**
     * @param sigId the sigId to set
     */
    public void setSigId(String sigId) {
        this.sigId = sigId;
    }

    /**
     * @return the modulation
     */
    public String getModulation() {
        return modulation;
    }

    /**
     * @param modulation the modulation to set
     */
    public void setModulation(String modulation) {
        this.modulation = modulation;
    }

    /**
     * @return the keyspeed
     */
    public Double getKeyspeed() {
        return keyspeed;
    }

    /**
     * @param keyspeed the keyspeed to set
     */
    public void setKeyspeed(Double keyspeed) {
        this.keyspeed = keyspeed;
    }

    /**
     * @deprecated
     * @return the opSid
     */
    public String getOpSid() {
        return opSid;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * @deprecated
     * @param opSid the opSid to set
     */
    public void setOpSid(String opSid) {
        this.opSid = opSid;
    }

    /**
     * @return the location
     */
    public ToxicSmokeLocationDistribution getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(ToxicSmokeLocationDistribution location) {
        this.location = location;
    }

    /**
     * @return the streamSampleRate
     */
    public Double getStreamSampleRate() {
        return streamSampleRate;
    }

    /**
     * @param streamSampleRate the streamSampleRate to set
     */
    public void setStreamSampleRate(Double streamSampleRate) {
        this.streamSampleRate = streamSampleRate;
    }

    /**
     * @return the referenceUrl
     */
    public String getReferenceUrl() {
        return referenceUrl;
    }

    /**
     * @param referenceUrl the referenceUrl to set
     */
    public void setReferenceUrl(String referenceUrl) {
        this.referenceUrl = referenceUrl;
    }

    /**
     * @return the associatedFiles
     */
    public List<String> getAssociatedFiles() {
        return associatedFiles;
    }

    /**
     * @param associatedFiles the associatedFiles to set
     */
    public void setAssociatedFiles(List<String> associatedFiles) {
        this.associatedFiles = associatedFiles;
    }

    /**
     * Add an associated file to the list
     *
     * @param associatedFile The associated file to add
     */
    public void addAssociatedFile(String associatedFile) {
        this.associatedFiles.add(associatedFile);
    }

    public List<Comment> getOpNoteJournal() {
        return opNoteJournal;
    }
}
