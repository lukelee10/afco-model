package net.acesinc.afco.model.data.quality;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ingestQualityErrorReporting")
public class IngestQualityErrorReporting implements Queryable {

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

    private String dgsSite;
    private String missionName;
    private String idNo;
    private String mappingId;
    private Set<String> errorComplaints = new LinkedHashSet<>();
    private QualityControlDataType qualityControlType;
    private InspectionType inspectionType;
    private String pddg;
    private String sigad;
    private Integer rtpSourcePort;
    private Boolean autoCorrected;
    private Date ingestDate;
    private Date stopTime;
    private Date lastUpdated;

    public String getDgsSite() {
        return dgsSite;
    }

    public void setDgsSite(String dgsSite) {
        this.dgsSite = dgsSite;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMappingId() {
        return mappingId;
    }

    public void setMappingId(String mappingId) {
        this.mappingId = mappingId;
    }

    public Set<String> getErrorComplaints() {
        return errorComplaints;
    }

    /**
     * This may never get used, but providing convenience method anyway for adding to the error complaint set.
     * UI would have to provide a way to add to the set if this were ever to be used.
     *
     * @param msg
     */
    public void addErrorComplaint(String msg) {
        this.errorComplaints.add(msg);
    }

    public void setErrorComplaints(Set<String> errorComplaints) {
        this.errorComplaints = errorComplaints;
    }

    public QualityControlDataType getQualityControlType() {
        return qualityControlType;
    }

    public void setQualityControlType(QualityControlDataType qualityControlType) {
        this.qualityControlType = qualityControlType;
    }

    public Integer getRtpSourcePort() {
        return rtpSourcePort;
    }

    public void setRtpSourcePort(Integer rtpSourcePort) {
        this.rtpSourcePort = rtpSourcePort;
    }

    public Boolean getAutoCorrected() {
        return autoCorrected;
    }

    public void setAutoCorrected(Boolean autoCorrected) {
        this.autoCorrected = autoCorrected;
    }

    public Date getIngestDate() {
        return ingestDate;
    }

    public void setIngestDate(Date ingestDate) {
        this.ingestDate = ingestDate;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
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

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        List<QueryField> specialCaseQueryableFields = new ArrayList<>(Arrays.asList(
                new QueryField("dgsSite", "Dgs Site", FieldType.STRING, "dgsSite", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("missionName", "Mission Name", FieldType.STRING, "missionName", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("idNo", "idNo", FieldType.ENUM, "idNo", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("mappingId", "Mapping Id", FieldType.STRING, "mappingId", AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "qualityControlDataType",
                        "Quality Control Data Type",
                        FieldType.STRING,
                        "qualityControlDataType",
                        AUTOCOMPLETE_DATA_TYPE)));
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
}
