/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.subject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.changelog.ChangeLog;
import net.acesinc.afco.model.event.Comment;
import net.acesinc.afco.model.event.signal.Characterization;
import net.acesinc.afco.model.event.signal.EobSiteInfo;
import net.acesinc.afco.model.event.signal.IdentOfEmit;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import net.acesinc.afco.model.query.UnitType;
import net.acesinc.afco.model.view.Views;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author jeremytaylor
 */
@Document(collection = "signal_event")
public class SignalSubject extends Subject implements Queryable {

    private static final Logger log = LoggerFactory.getLogger(SignalSubject.class);

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "elint-signal";

    @JsonView(Views.MapView.class)
    private String missionId;

    @JsonView(Views.MapView.class)
    private Long signalId;
    /**
     * The instanceNumber for now only occurs under Signal XML for NMPG and NOT
     * AE. Thus, this must be optional.
     */
    @JsonView(Views.MapView.class)
    @JsonProperty(required = false)
    private Long instanceNumber;
    /**
     * The sensorId for now only occurs under Signal XML for NMPG and NOT AE.
     * Thus, this must be optional.
     */
    @JsonView(Views.MapView.class)
    @JsonProperty(required = false)
    private String sensorId;

    @JsonView(Views.DashboardView.class)
    private String digraph;

    @JsonView(Views.DashboardView.class)
    private String pddg;

    @JsonView(Views.DashboardView.class)
    private String sigad;

    @JsonView(Views.DefaultView.class)
    private Date startTime;

    @JsonView(Views.DefaultView.class)
    private Date stopTime;
    /**
     * The number of intercepts that contributed to the signal for CETS signals
     * only. This value comes from the Signal XML for CETS signals as described
     * in Signal.xsd and is ingested AS IS. It does not get manipulated or incremented
     * when individual intercepts are ingested, so it's quite possible that this value
     * won't always match the number of intercepts we've ingested at a given time.
     */
    @JsonView(Views.FullView.class)
    private Integer interceptCount;

    @JsonView(Views.DashboardView.class)
    private Integer pdwConvolvedCount;

    @JsonView(Views.FullView.class)
    private String mobility;

    @JsonView(Views.FullView.class)
    private Boolean hasSei;

    @JsonView(Views.FullView.class)
    private Double eobMatchMissDistance;

    @JsonView(Views.FullView.class)
    private EobSiteInfo eobMatchSiteInfo;

    @JsonView(Views.FullView.class)
    private Characterization characterization;

    @JsonView(Views.DefaultView.class)
    private Date timestamp;

    @JsonView(Views.MapView.class)
    private List<IdentOfEmit> idents = new ArrayList<>();

    @JsonView(Views.FullView.class)
    private List<Comment> comments = new ArrayList<>();

    @JsonView(Views.DashboardView.class)
    private Boolean scheduledForDistribution = false;

    @JsonView(Views.DashboardView.class)
    private Boolean validated = false;

    @JsonView(Views.DashboardView.class)
    private Boolean matchedSoiList = false;

    @JsonView(Views.FullView.class)
    private List<ChangeLog> changeLog = new ArrayList<>();

    public SignalSubject() {
        setType(SubjectType.ELINT);
    }

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        List<QueryField> specialCaseQueryableFields = new ArrayList<>(Arrays.asList(
                new QueryField(
                        "characterization",
                        "Characterization",
                        FieldType.ENUM,
                        "characterization.dataType",
                        AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "characterization",
                        "RF",
                        FieldType.DOUBLE,
                        "characterization.radioFreqSummary.freqs",
                        UnitType.MHZ),
                new QueryField(
                        "characterization",
                        "GRI",
                        FieldType.DOUBLE,
                        "characterization.groupRepititionIntervalMeanEstimate",
                        UnitType.MICROSECONDS),
                new QueryField(
                        "characterization",
                        "PRI",
                        FieldType.DOUBLE,
                        "characterization.pulseRepIntervalSummary.pulseRepititionIntervalMeanEstimates",
                        UnitType.MICROSECONDS),
                new QueryField(
                        "characterization",
                        "PW",
                        FieldType.DOUBLE,
                        "characterization.pulseWidthSummary.pulseWidthMeanEstimates",
                        UnitType.MICROSECONDS),
                new QueryField(
                        "characterization",
                        "Polarization",
                        FieldType.ENUM,
                        "characterization.polarization",
                        AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "characterization",
                        "Scan Type",
                        FieldType.STRING,
                        "characterization.scanType",
                        AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "characterization",
                        "Scan Rate",
                        FieldType.DOUBLE,
                        "characterization.scanRate",
                        null,
                        UnitType.HZ),
                new QueryField(
                        "characterization",
                        "Illumination Rate",
                        FieldType.DOUBLE,
                        "characterization.illuminationRate",
                        UnitType.HZ),
                new QueryField("collectorIds", "Platform ID", FieldType.STRING, "collectorIds", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("digraph", "Digraph", FieldType.STRING, "digraph", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("pddg", "PDDG", FieldType.ENUM, "pddg", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("sigad", "SIGAD", FieldType.ENUM, "sigad", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("sensorId", "Sensor Id", FieldType.STRING, "sensorId", null, false, null),
                new QueryField("hasSei", "Has SEI", FieldType.BOOLEAN),
                new QueryField("idents", "ELNOT", FieldType.ELNOT, "idents.ident", AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "idents", "Function Code", FieldType.STRING, "idents.functionCode", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("ingestSite", "Ingest Site", FieldType.ENUM, "ingestSite", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("location", "Location", FieldType.POINT),
                new QueryField("matchedSoiList", "Matched SOI List", FieldType.BOOLEAN),
                new QueryField("missionId", "Mission ID", FieldType.STRING, "missionId", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("mobility", "Mobility", FieldType.ENUM, "mobility", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("pdwConvolvedCount", "Convolved PDW Count", FieldType.INTEGER),
                new QueryField("signalId", "Signal ID", FieldType.LONG, "signalId", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("source", "Source", FieldType.ENUM, "source", AUTOCOMPLETE_DATA_TYPE)));
        specialCaseQueryableFields.addAll(SPECIAL_CASE_QUERYABLE_FIELDS);

        return specialCaseQueryableFields;
    }

    @Override
    @JsonIgnore
    public List<String> getNonQueryableFields() {
        List<String> nonQueryableFields =
                new ArrayList<>(Arrays.asList("eobMatchMissDistance", "eobMatchSiteInfo", "comments"));
        nonQueryableFields.addAll(NON_QUERYABLE_FIELDS);

        return nonQueryableFields;
    }

    @Override
    @JsonIgnore
    public List<Class<? extends Queryable>> getQueryableSubclasses() {
        return Collections.emptyList();
    }

    /**
     * @return the signalId
     */
    public Long getSignalId() {
        return signalId;
    }

    /**
     * @param signalId the signalId to set
     */
    public void setSignalId(Long signalId) {
        this.signalId = signalId;
    }

    /**
     * @return the digraph
     */
    public String getDigraph() {
        return digraph;
    }

    /**
     * @param digraph the digraph to set
     */
    public void setDigraph(String digraph) {
        this.digraph = digraph;
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
     * @return the interceptCount
     */
    public Integer getInterceptCount() {
        return interceptCount;
    }

    /**
     * @param interceptCount the interceptCount to set
     */
    public void setInterceptCount(Integer interceptCount) {
        this.interceptCount = interceptCount;
    }

    /**
     * @return the pdwConvolvedCount
     */
    public Integer getPdwConvolvedCount() {
        return pdwConvolvedCount;
    }

    /**
     * @param pdwConvolvedCount the pdwConvolvedCount to set
     */
    public void setPdwConvolvedCount(Integer pdwConvolvedCount) {
        this.pdwConvolvedCount = pdwConvolvedCount;
    }

    /**
     * @return the idents
     */
    public List<IdentOfEmit> getIdents() {
        return idents;
    }

    /**
     * @param idents the idents to set
     */
    public void setIdents(List<IdentOfEmit> idents) {
        this.idents = idents;
    }

    /**
     * @return the mobility
     */
    public String getMobility() {
        return mobility;
    }

    /**
     * @param mobility the mobility to set
     */
    public void setMobility(String mobility) {
        this.mobility = mobility;
    }

    /**
     * @return the hasSei
     */
    public Boolean getHasSei() {
        return hasSei;
    }

    /**
     * @param hasSei the hasSei to set
     */
    public void setHasSei(Boolean hasSei) {
        this.hasSei = hasSei;
    }

    /**
     * @return the characterization
     */
    public Characterization getCharacterization() {
        return characterization;
    }

    /**
     * @param characterization the characterization to set
     */
    public void setCharacterization(Characterization characterization) {
        this.characterization = characterization;
    }

    /**
     * @return the eobMatchMissDistance
     */
    public Double getEobMatchMissDistance() {
        return eobMatchMissDistance;
    }

    /**
     * @param eobMatchMissDistance the eobMatchMissDistance to set
     */
    public void setEobMatchMissDistance(Double eobMatchMissDistance) {
        this.eobMatchMissDistance = eobMatchMissDistance;
    }

    /**
     * @return the eobMatchSiteInfo
     */
    public EobSiteInfo getEobMatchSiteInfo() {
        return eobMatchSiteInfo;
    }

    /**
     * @param eobMatchSiteInfo the eobMatchSiteInfo to set
     */
    public void setEobMatchSiteInfo(EobSiteInfo eobMatchSiteInfo) {
        this.eobMatchSiteInfo = eobMatchSiteInfo;
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
     * @return the instanceNumber
     */
    public Long getInstanceNumber() {
        return instanceNumber;
    }

    /**
     * @param instanceNumber the instanceNumber to set
     */
    public void setInstanceNumber(Long instanceNumber) {
        this.instanceNumber = instanceNumber;
    }

    /**
     * @return the sensorId
     */
    public String getSensorId() {
        return sensorId;
    }

    /**
     * @param sensorId the sensorId to set
     */
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * @return the comments
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /**
     * @return the scheduledForDistribution
     */
    public Boolean getScheduledForDistribution() {
        return scheduledForDistribution;
    }

    /**
     * @param scheduledForDistribution the scheduledForDistribution to set
     */
    public void setScheduledForDistribution(Boolean scheduledForDistribution) {
        this.scheduledForDistribution = scheduledForDistribution;
    }

    /**
     * @return the validated
     */
    public Boolean getValidated() {
        return validated;
    }

    /**
     * @param validated the validated to set
     */
    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    /**
     * @return the matchedSoiList
     */
    public Boolean getMatchedSoiList() {
        return matchedSoiList;
    }

    /**
     * @param matchedSoiList the matchedSoiList to set
     */
    public void setMatchedSoiList(Boolean matchedSoiList) {
        this.matchedSoiList = matchedSoiList;
    }

    /**
     * @return the changeLog
     */
    public List<ChangeLog> getChangeLog() {
        return changeLog;
    }

    /**
     * @param changeLog the changeLog to set
     */
    public void setChangeLog(List<ChangeLog> changeLog) {
        this.changeLog = changeLog;
    }

    /**
     * Add a changeLog entry to the changeLog list if the new value differs from the old value. Otherwise,
     * it is ignored.
     *
     * @param changeLog The ChangeLog object to add
     * @return True if changeLog was was added, False otherwise
     */
    public boolean addChangeLog(ChangeLog changeLog) {
        // If the new value is not null and it is different than the old value, then add it to the changeLog list and
        // return true
        if (changeLog.getNewValue() != null && !changeLog.getNewValue().equals(changeLog.getOldValue())) {
            this.changeLog.add(changeLog);
            return true;
        }

        // Otherwise return false
        return false;
    }
}
