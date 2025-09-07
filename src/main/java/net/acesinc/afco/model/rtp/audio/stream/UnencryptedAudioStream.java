package net.acesinc.afco.model.rtp.audio.stream;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.classification.Classification;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ueAudioStream")
public class UnencryptedAudioStream implements Queryable {
    @JsonIgnore
    protected static List<QueryField> SPECIAL_CASE_QUERYABLE_FIELDS = Collections.singletonList(
            new QueryField("mappingId", "Mapping ID", FieldType.STRING, "mappingId", null, false, null));

    @JsonIgnore
    protected static List<String> NON_QUERYABLE_FIELDS = Arrays.asList(
            "AUTOCOMPLETE_DATA_TYPE",
            "NON_QUERYABLE_FIELDS",
            "SPECIAL_CASE_QUERYABLE_FIELDS",
            "SELF",
            "classification");

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "unencrypted-audio-stream";

    private String missionName;
    private String mappingId;
    private String audioEncoding;
    private String pddg;
    private String sigad;
    private Integer signalType;
    private Integer payloadType;
    private Integer extendedHeaderCount;
    private Date startTime;
    private Date stopTime;
    private Integer rtpSourcePort;
    private Date ingestDate;
    private Classification classification;
    private String ingestSite;
    private Date lastUpdated;

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getMappingId() {
        return mappingId;
    }

    public void setMappingId(String mappingId) {
        this.mappingId = mappingId;
    }

    public String getAudioEncoding() {
        return audioEncoding;
    }

    public void setAudioEncoding(String audioEncoding) {
        this.audioEncoding = audioEncoding;
    }

    public String getPddg() {
        return pddg;
    }

    public void setPddg(String pddg) {
        this.pddg = pddg;
    }

    public String getSigad() {
        return sigad;
    }

    public void setSigad(String sigad) {
        this.sigad = sigad;
    }

    public Integer getSignalType() {
        return signalType;
    }

    public void setSignalType(Integer signalType) {
        this.signalType = signalType;
    }

    public Date getIngestDate() {
        return ingestDate;
    }

    public void setIngestDate(Date ingestDate) {
        this.ingestDate = ingestDate;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public String getIngestSite() {
        return ingestSite;
    }

    public void setIngestSite(String ingestSite) {
        this.ingestSite = ingestSite;
    }

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        List<QueryField> specialCaseQueryableFields = new ArrayList<>(Arrays.asList(
                new QueryField("missionName", "Mission Name", FieldType.STRING, "missionName", AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "audioEncoding", "Audio Encoding", FieldType.ENUM, "audioEncoding", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("pddg", "PDDG", FieldType.ENUM, "pddg", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("sigad", "SIGAD", FieldType.ENUM, "sigad", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("signalType", "Signal Type", FieldType.ENUM, "signalType", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("ingestSite", "Ingest Site", FieldType.ENUM, "ingestSite", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("payloadType", "Payload Type", FieldType.ENUM, "payloadType", AUTOCOMPLETE_DATA_TYPE)));
        specialCaseQueryableFields.addAll(SPECIAL_CASE_QUERYABLE_FIELDS);
        return specialCaseQueryableFields;
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

    public Integer getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(Integer payloadType) {
        this.payloadType = payloadType;
    }

    public Integer getExtendedHeaderCount() {
        return extendedHeaderCount;
    }

    public void setExtendedHeaderCount(Integer extendedHeaderCount) {
        this.extendedHeaderCount = extendedHeaderCount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public Integer getRtpSourcePort() {
        return rtpSourcePort;
    }

    public void setRtpSourcePort(Integer rtpSourcePort) {
        this.rtpSourcePort = rtpSourcePort;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
