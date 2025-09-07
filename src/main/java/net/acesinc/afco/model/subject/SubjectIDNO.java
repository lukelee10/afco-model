/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.subject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.file.pyspeech.PyspeechResult;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import net.acesinc.afco.model.query.UnitType;
import net.acesinc.afco.model.view.Views;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author andrewserff
 */
@Document(collection = "subject")
public class SubjectIDNO extends Subject {

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "subject";

    @JsonView(Views.MapView.class)
    private String msnNo;

    @JsonView(Views.MapView.class)
    private String idNo;

    @JsonView(Views.MapView.class)
    private Double freq;

    @JsonView(Views.DashboardView.class)
    private Double bw;

    @JsonView(Views.DashboardView.class)
    private List<String> casenots;

    @JsonView(Views.FullView.class)
    private List<String> rasins;
    /**
     * demodulatorMode: will be the same as the discussed terms on different
     * XSDs such as modulationType or modType
     */
    @JsonView(Views.FullView.class)
    private String demodulatorMode;

    @JsonView(Views.DashboardView.class)
    private String pddg;

    @JsonView(Views.DashboardView.class)
    private String sigad;

    @JsonView(Views.MapView.class)
    private Integer lobCount;

    @JsonView(Views.DashboardView.class)
    private Integer activityAlertCount;

    @JsonView(Views.DashboardView.class)
    private Integer audioCount;

    @JsonView(Views.MapView.class)
    private Integer locationDataCount;

    @JsonView(Views.DashboardView.class)
    private Integer reportCount;

    @JsonView(Views.MapView.class)
    private boolean active;

    @JsonView(Views.DefaultView.class)
    private Date upDate;

    @JsonView(Views.DefaultView.class)
    private Date downDate;

    @JsonView(Views.FullView.class)
    private List<Double> speechSeconds;

    @JsonView(Views.FullView.class)
    private List<String> callsigns;
    // TODO: Review desire for continued existence of freqList in 6 months from 5/21/2019 due to pending audio system
    // upgrades at site.
    // "freq" also exists, but there is a ticket to debate the need for keeping track of multiple or not. A bug ticket
    // was resolved,
    // so the desire to keep track of multiple may go completely away in 6 months.
    @JsonView(Views.FullView.class)
    private List<Double> freqList;

    @JsonView(Views.DashboardView.class)
    private List<PyspeechResult> genders;

    @JsonView(Views.DashboardView.class)
    private List<PyspeechResult> languages;

    @JsonView(Views.DashboardView.class)
    private List<PyspeechResult> speakers;

    @JsonView(Views.FullView.class)
    private List<Object> preDemodulatedInfoEntries;

    @JsonView(Views.DashboardView.class)
    private boolean hasPbit;

    @JsonView(Views.DashboardView.class)
    private boolean hasPred;

    @JsonView(Views.DashboardView.class)
    private String audioFormatDescription;

    // revised for PI6 suggestions: See demodulatorMode above if looking for modType.
    @JsonView(Views.DashboardView.class)
    private boolean hasSpecialSignals;
    /**
     * unique identifier for assignment
     */
    private String assignmentId;

    private String rfid;
    private FormattedDataType formattedType;
    private AudioEncoding audioEncoding;
    /**
     * This is the sampleRate coming from assignment messaging only.
     * Clarification: sampleRate in dataFile related info will ONLY come from
     * metadata of the RTP streams. In this case, sampleRate will be derived
     * from payloadType of RTP header.
     */
    private Double streamSampleRate;

    private StreamSignalType streamSignalType;
    private String streamDetailedStatus;
    /**
     * streamStartTime: Time the cut was started -- coming from assignment
     * messages only. This may or not be used in the end via UI.
     */
    private Date streamStartTime;
    /**
     * streamEndTime: startTimeTime the cut was stopped -- coming from
     * assignment messages only. This may or not be used in the end via UI.
     */
    private Date streamEndTime;

    private String streamPlatformTailNumber;
    private boolean autoDf;
    /**
     * operatorId: The operatorID
     * signalType: The associated signalType
     */
    @JsonView(Views.FullView.class)
    private String operatorId;

    @JsonView(Views.FullView.class)
    private Integer signalType;

    /**
     * specialField1: The specialField1
     * specialField2: The specialField2
     */
    @JsonView(Views.FullView.class)
    private Long specialField1;

    @JsonView(Views.FullView.class)
    private String specialField2;

    @JsonView(Views.FullView.class)
    private String dgsSite;

    private String originatorId;
    private String userData;
    private String transactionId;
    private String sensorCopyId;

    public SubjectIDNO() {
        setType(SubjectType.COMINT);
    }

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        List<QueryField> specialCaseQueryableFields = new ArrayList<>(Arrays.asList(
                new QueryField(
                        "assignmentId", "Assignment ID (hidden)", FieldType.STRING, "assignmentId", null, false, null),
                new QueryField("mappingId", "Assignment ID", FieldType.STRING, "mappingId", AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "audioFormatDescription",
                        "Audio Format",
                        FieldType.ENUM,
                        "audioFormatDescription",
                        AUTOCOMPLETE_DATA_TYPE),
                new QueryField("bw", "Bandwidth", FieldType.DOUBLE, UnitType.MHZ),
                new QueryField("callsigns", "Call Sign", FieldType.ENUM, "callsigns", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("casenots", "Case Notation", FieldType.STRING, "casenots", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("collectorIds", "Platform ID", FieldType.STRING, "collectorIds", AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "demodulatorMode",
                        "Demodulator Mode",
                        FieldType.ENUM,
                        "demodulatorMode",
                        AUTOCOMPLETE_DATA_TYPE),
                new QueryField("freq", "Frequency", FieldType.DOUBLE, UnitType.MHZ),
                new QueryField("genders", "Gender", FieldType.GENDER, "genders.label"),
                new QueryField("hasPbit", "Has PBit", FieldType.BOOLEAN),
                new QueryField("hasPred", "Has Pre-D", FieldType.BOOLEAN),
                new QueryField("idNo", "IDNO", FieldType.STRING, "idNo", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("ingestSite", "Ingest Site", FieldType.ENUM, "ingestSite", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("languages", "Language", FieldType.LANGUAGE, "languages.label", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("location", "Location", FieldType.POINT),
                new QueryField("msnNo", "Mission No", FieldType.STRING, "msnNo", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("pddg", "PDDG", FieldType.ENUM, "pddg", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("sigad", "SIGAD", FieldType.ENUM, "sigad", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("preDemodulatedInfoEntries", "Pre-D", FieldType.ARRAY),
                new QueryField("rasins", "RASIN", FieldType.STRING, "rasins", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("speechSeconds", "Speech Seconds", FieldType.INTEGER),
                new QueryField("speakers", "Speaker", FieldType.SPEAKER, "speakers.label", AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "formattedType",
                        "Formatted Data Type",
                        FieldType.ENUM,
                        "formattedType",
                        AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "audioEncoding", "Audio Encoding", FieldType.ENUM, "audioEncoding", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("operatorId", "Operator ID", FieldType.STRING, "operatorId", AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "signalType", "Signal Type", FieldType.SIGNAL_TYPE, "signalType", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("source", "Source", FieldType.ENUM, "source", AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "specialField1", "Special Field 1", FieldType.LONG, "specialField1", AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "specialField2", "Special Field 2", FieldType.STRING, "specialField2", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("dgsSite", "DGS Site", FieldType.ENUM, "dgsSite", AUTOCOMPLETE_DATA_TYPE)));
        specialCaseQueryableFields.addAll(SPECIAL_CASE_QUERYABLE_FIELDS);

        return specialCaseQueryableFields;
    }

    @Override
    @JsonIgnore
    public List<String> getNonQueryableFields() {
        List<String> nonQueryableFields = new ArrayList<>(Arrays.asList(
                "freqList",
                "streamDetailedStatus",
                "streamEndTime",
                "streamPlatformTailNumber",
                "streamSampleRate",
                "streamSignalType",
                "streamStartTime"));
        nonQueryableFields.addAll(NON_QUERYABLE_FIELDS);

        return nonQueryableFields;
    }

    @Override
    @JsonIgnore
    public List<Class<? extends Queryable>> getQueryableSubclasses() {
        return Collections.emptyList();
    }

    /**
     *
     * @return - The specialField1
     */
    public Long getSpecialField1() {
        return specialField1;
    }

    /**
     *
     * @param specialField1 - The specialField1 to set
     */
    public void setSpecialField1(Long specialField1) {
        this.specialField1 = specialField1;
    }

    /**
     *
     * @return The specialField2
     */
    public String getSpecialField2() {
        return specialField2;
    }

    /**
     *
     * @param specialField2 - The specialField2 to set
     */
    public void setSpecialField2(String specialField2) {
        this.specialField2 = specialField2;
    }

    /**
     * @return the operatorId
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * @param operatorId the operatorId to set
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * @return the signalType
     */
    public Integer getSignalType() {
        return signalType;
    }

    /**
     * @param signalType the signalType to set
     */
    public void setSignalType(Integer signalType) {
        this.signalType = signalType;
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
     * @return the casenots
     */
    public List<String> getCasenots() {
        return casenots;
    }

    /**
     * @param casenots the casenots to set
     */
    public void setCasenots(List<String> casenots) {
        this.casenots = casenots;
    }

    /**
     * @return the callsigns
     */
    public List<String> getCallsigns() {
        return callsigns;
    }

    /**
     * @param callsigns the callsigns to set
     */
    public void setCallsigns(List<String> callsigns) {
        this.callsigns = callsigns;
    }

    /**
     * @return the freqList
     */
    public List<Double> getFreqList() {
        return freqList;
    }

    /**
     * @param freqList the freqList to set
     */
    public void setFreqList(List<Double> freqList) {
        this.freqList = freqList;
    }

    /**
     * @return the demodulatorMode
     */
    public String getDemodulatorMode() {
        return demodulatorMode;
    }

    /**
     * @param demodulatorMode the demodulatorMode to set
     */
    public void setDemodulatorMode(String demodulatorMode) {
        this.demodulatorMode = demodulatorMode;
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
     * @return the genders
     */
    public List<PyspeechResult> getGenders() {
        return genders;
    }

    /**
     * @param genders the genders to set
     */
    public void setGenders(List<PyspeechResult> genders) {
        this.genders = genders;
    }

    /**
     * @return the languages
     */
    public List<PyspeechResult> getLanguages() {
        return languages;
    }

    /**
     * @param languages the languages to set
     */
    public void setLanguages(List<PyspeechResult> languages) {
        this.languages = languages;
    }

    /**
     * @return the speakers
     */
    public List<PyspeechResult> getSpeakers() {
        return speakers;
    }

    /**
     * @param speakers the speakers to set
     */
    public void setSpeakers(List<PyspeechResult> speakers) {
        this.speakers = speakers;
    }

    /**
     * @return the lobCount
     */
    public Integer getLobCount() {
        return lobCount;
    }

    /**
     * @param lobCount the lobCount to set
     */
    public void setLobCount(Integer lobCount) {
        this.lobCount = lobCount;
    }

    /**
     * @return the activityAlertCount
     */
    public Integer getActivityAlertCount() {
        return activityAlertCount;
    }

    /**
     * @param activityAlertCount the activityAlertCount to set
     */
    public void setActivityAlertCount(Integer activityAlertCount) {
        this.activityAlertCount = activityAlertCount;
    }

    /**
     * @return the audioCount
     */
    public Integer getAudioCount() {
        return audioCount;
    }

    /**
     * @param audioCount the audioCount to set
     */
    public void setAudioCount(Integer audioCount) {
        this.audioCount = audioCount;
    }

    /**
     * @return the locationDataCount
     */
    public Integer getLocationDataCount() {
        return locationDataCount;
    }

    /**
     * @param locationDataCount the locationDataCount to set
     */
    public void setLocationDataCount(Integer locationDataCount) {
        this.locationDataCount = locationDataCount;
    }

    /**
     * @return the reportCount
     */
    public Integer getReportCount() {
        return reportCount;
    }

    /**
     * @param reportCount the reportCount to set
     */
    public void setReportCount(Integer reportCount) {
        this.reportCount = reportCount;
    }

    /**
     * @return the speechSeconds
     */
    public List<Double> getSpeechSeconds() {
        return speechSeconds;
    }

    /**
     * @param speechSeconds the speechSeconds to set
     */
    public void setSpeechSeconds(List<Double> speechSeconds) {
        this.speechSeconds = speechSeconds;
    }

    /**
     * @return the upDate
     */
    public Date getUpDate() {
        return upDate;
    }

    /**
     * @param upDate the upDate to set
     */
    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    /**
     * @return the downDate
     */
    public Date getDownDate() {
        return downDate;
    }

    /**
     * @param downDate the downDate to set
     */
    public void setDownDate(Date downDate) {
        this.downDate = downDate;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the hasPbit
     */
    public boolean isHasPbit() {
        return hasPbit;
    }

    /**
     * @param hasPbit the hasPbit to set
     */
    public void setHasPbit(boolean hasPbit) {
        this.hasPbit = hasPbit;
    }

    /**
     * @return the hasPred
     */
    public boolean isHasPred() {
        return hasPred;
    }

    /**
     * @param hasPred the hasPred to set
     */
    public void setHasPred(boolean hasPred) {
        this.hasPred = hasPred;
    }

    /**
     * @return the preDemodulatedInfoEntries
     */
    public List<Object> getPreDemodulatedInfoEntries() {
        return preDemodulatedInfoEntries;
    }

    /**
     * @param preDemodulatedInfoEntries the preDemodulatedInfoEntries to set
     */
    public void setPreDemodulatedInfoEntries(List<Object> preDemodulatedInfoEntries) {
        this.preDemodulatedInfoEntries = preDemodulatedInfoEntries;
    }

    /**
     * @return the assignmentId
     */
    public String getAssignmentId() {
        return assignmentId;
    }

    /**
     * @param assignmentId the assignmentId to set
     */
    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    /**
     * @return the formattedType
     */
    public FormattedDataType getFormattedType() {
        return formattedType;
    }

    /**
     * @param formattedType the formattedType to set
     */
    public void setFormattedType(FormattedDataType formattedType) {
        this.formattedType = formattedType;
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
     * @return the streamSignalType
     */
    public StreamSignalType getStreamSignalType() {
        return streamSignalType;
    }

    /**
     * @param streamSignalType the streamSignalType to set
     */
    public void setStreamSignalType(StreamSignalType streamSignalType) {
        this.streamSignalType = streamSignalType;
    }

    /**
     * @return the streamDetailedStatus
     */
    public String getStreamDetailedStatus() {
        return streamDetailedStatus;
    }

    /**
     * @param streamDetailedStatus the streamDetailedStatus to set
     */
    public void setStreamDetailedStatus(String streamDetailedStatus) {
        this.streamDetailedStatus = streamDetailedStatus;
    }

    /**
     * @return the streamPlatformTailNumber
     */
    public String getStreamPlatformTailNumber() {
        return streamPlatformTailNumber;
    }

    /**
     * @param streamPlatformTailNumber the streamPlatformTailNumber to set
     */
    public void setStreamPlatformTailNumber(String streamPlatformTailNumber) {
        this.streamPlatformTailNumber = streamPlatformTailNumber;
    }

    /**
     * @return the autoDf
     */
    public boolean isAutoDf() {
        return autoDf;
    }

    /**
     * @param autoDf the autoDf to set
     */
    public void setAutoDf(boolean autoDf) {
        this.autoDf = autoDf;
    }

    /**
     * @return the streamStartTime
     */
    public Date getStreamStartTime() {
        return streamStartTime;
    }

    /**
     * @param streamStartTime the streamStartTime to set
     */
    public void setStreamStartTime(Date streamStartTime) {
        this.streamStartTime = streamStartTime;
    }

    /**
     * @return the streamEndTime
     */
    public Date getStreamEndTime() {
        return streamEndTime;
    }

    /**
     * @param streamEndTime the streamEndTime to set
     */
    public void setStreamEndTime(Date streamEndTime) {
        this.streamEndTime = streamEndTime;
    }

    /**
     * @return the hasSpecialSignals
     */
    public boolean isHasSpecialSignals() {
        return hasSpecialSignals;
    }

    /**
     * @param hasSpecialSignals the hasSpecialSignals to set
     */
    public void setHasSpecialSignals(boolean hasSpecialSignals) {
        this.hasSpecialSignals = hasSpecialSignals;
    }

    /**
     * @return the rfid
     */
    public String getRfid() {
        return rfid;
    }

    /**
     * @param rfid the rfid to set
     */
    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    /**
     * @return the rasins
     */
    public List<String> getRasins() {
        return rasins;
    }

    /**
     * @param rasins the rasins to set
     */
    public void setRasins(List<String> rasins) {
        this.rasins = rasins;
    }

    /**
     * @return the audioEncoding
     */
    public AudioEncoding getAudioEncoding() {
        return audioEncoding;
    }

    /**
     * @param audioEncoding the audioEncoding to set
     */
    public void setAudioEncoding(AudioEncoding audioEncoding) {
        this.audioEncoding = audioEncoding;
    }

    /**
     *
     * @return the audioFormatDescription
     */
    public String getAudioFormatDescription() {
        return audioFormatDescription;
    }

    /**
     *
     * @param audioFormatDescription the audioFormatDescription to set
     */
    public void setAudioFormatDescription(String audioFormatDescription) {
        this.audioFormatDescription = audioFormatDescription;
    }

    public String getDgsSite() {
        return dgsSite;
    }

    public void setDgsSite(String dgsSite) {
        this.dgsSite = dgsSite;
    }

    public String getOriginatorId() {
        return originatorId;
    }

    public void setOriginatorId(String originatorId) {
        this.originatorId = originatorId;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSensorCopyId() {
        return sensorCopyId;
    }

    public void setSensorCopyId(String sensorCopyId) {
        this.sensorCopyId = sensorCopyId;
    }
}
