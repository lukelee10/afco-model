package net.acesinc.afco.model.pod;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import net.acesinc.afco.model.view.Views;

/**
 * The main PodMeta bean that holds pod metadata that comes from the Pod-slayer tool.
 */
public class PodMeta implements Queryable {

    @JsonIgnore
    protected static List<QueryField> SPECIAL_CASE_QUERYABLE_FIELDS = Collections.singletonList(
            new QueryField("mappingId", "Mapping ID", FieldType.STRING, "mappingId", null, false, null));

    @JsonIgnore
    protected static List<String> NON_QUERYABLE_FIELDS = Arrays.asList(
            "AUTOCOMPLETE_DATA_TYPE",
            "NON_QUERYABLE_FIELDS",
            "SPECIAL_CASE_QUERYABLE_FIELDS",
            "SELF",
            // "subElements",
            "classification");

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "pod-meta";

    @JsonView(Views.DashboardView.class)
    private String id;

    @JsonView(Views.DashboardView.class)
    private String acquisitionDate;

    @JsonView(Views.DashboardView.class)
    private String acquisitionTime;

    @JsonView(Views.DashboardView.class)
    private String timeEpoch;

    @JsonView(Views.DashboardView.class)
    private Double timeDelta;

    @JsonView(Views.DashboardView.class)
    private String toa;

    @JsonView(Views.DashboardView.class)
    private String pf;

    @JsonView(Views.DashboardView.class)
    private String pfDev;

    @JsonView(Views.DashboardView.class)
    private String chirp;

    @JsonView(Views.DashboardView.class)
    private String pw;

    @JsonView(Views.DashboardView.class)
    private String pa;

    @JsonView(Views.DashboardView.class)
    private String snr;

    @JsonView(Views.DashboardView.class)
    private String pulseId;

    @JsonView(Views.DashboardView.class)
    private String targetId;

    @JsonView(Views.DashboardView.class)
    private Double rfFreq;

    @JsonView(Views.DashboardView.class)
    private Integer dataRfUnits;

    @JsonView(Views.DashboardView.class)
    private String application;

    @JsonView(Views.DashboardView.class)
    private Integer eventOffset;

    @JsonView(Views.DashboardView.class)
    private Long eventTime;

    @JsonView(Views.DashboardView.class)
    private Integer eventTimeUnits;

    @JsonView(Views.DashboardView.class)
    private Double eventDuration;

    @JsonView(Views.DashboardView.class)
    private String dataFile;

    @JsonView(Views.DashboardView.class)
    private String source;

    @JsonView(Views.DashboardView.class)
    private String missionId;

    @JsonView(Views.DashboardView.class)
    private String platformId;

    @JsonView(Views.DashboardView.class)
    private String sensorId;

    @JsonView(Views.DashboardView.class)
    private String podDwellId;

    @JsonView(Views.DashboardView.class)
    private String mappingId;

    @JsonView(Views.DashboardView.class)
    private String timeCode;

    @JsonView(Views.DashboardView.class)
    private Date startTime;

    @JsonView(Views.DashboardView.class)
    private String rawStartTime;

    @JsonView(Views.DashboardView.class)
    private String dataRep;

    @JsonView(Views.DashboardView.class)
    private Double numberOfElements;

    @JsonView(Views.DashboardView.class)
    private String fileType;

    @JsonView(Views.DashboardView.class)
    private String dataFormat;

    @JsonView(Views.DashboardView.class)
    private String writeProtect;

    @JsonView(Views.DashboardView.class)
    private String abscissaUnits;

    @JsonView(Views.DashboardView.class)
    private Double abscissaStart;

    @JsonView(Views.DashboardView.class)
    private Double abscissaDelta;

    @JsonView(Views.DashboardView.class)
    private String duration;

    @JsonView(Views.DashboardView.class)
    private Integer numberOfSubRecords;

    @JsonView(Views.DashboardView.class)
    private Integer bytesPerRecord;

    @JsonView(Views.DashboardView.class)
    private String ingestSite;

    @JsonView(Views.DashboardView.class)
    private Date lastUpdated;

    // @JsonView(Views.FullView.class)
    // private List<PodSubElement> subElements = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getAcquisitionTime() {
        return acquisitionTime;
    }

    public void setAcquisitionTime(String acquisitionTime) {
        this.acquisitionTime = acquisitionTime;
    }

    public String getTimeEpoch() {
        return timeEpoch;
    }

    public void setTimeEpoch(String timeEpoch) {
        this.timeEpoch = timeEpoch;
    }

    public Double getTimeDelta() {
        return timeDelta;
    }

    public void setTimeDelta(Double timeDelta) {
        this.timeDelta = timeDelta;
    }

    public String getToa() {
        return toa;
    }

    public void setToa(String toa) {
        this.toa = toa;
    }

    public String getPf() {
        return pf;
    }

    public void setPf(String pf) {
        this.pf = pf;
    }

    public String getPfDev() {
        return pfDev;
    }

    public void setPfDev(String pfDev) {
        this.pfDev = pfDev;
    }

    public String getChirp() {
        return chirp;
    }

    public void setChirp(String chirp) {
        this.chirp = chirp;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    public String getSnr() {
        return snr;
    }

    public void setSnr(String snr) {
        this.snr = snr;
    }

    public String getPulseId() {
        return pulseId;
    }

    public void setPulseId(String pulseId) {
        this.pulseId = pulseId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public Double getRfFreq() {
        return rfFreq;
    }

    public void setRfFreq(Double rfFreq) {
        this.rfFreq = rfFreq;
    }

    public Integer getDataRfUnits() {
        return dataRfUnits;
    }

    public void setDataRfUnits(Integer dataRfUnits) {
        this.dataRfUnits = dataRfUnits;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public Integer getEventOffset() {
        return eventOffset;
    }

    public void setEventOffset(Integer eventOffset) {
        this.eventOffset = eventOffset;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }

    public Integer getEventTimeUnits() {
        return eventTimeUnits;
    }

    public void setEventTimeUnits(Integer eventTimeUnits) {
        this.eventTimeUnits = eventTimeUnits;
    }

    public Double getEventDuration() {
        return eventDuration;
    }

    public void setEventDuration(Double eventDuration) {
        this.eventDuration = eventDuration;
    }

    public String getDataFile() {
        return dataFile;
    }

    public void setDataFile(String dataFile) {
        this.dataFile = dataFile;
    }

    public String getTimeCode() {
        return timeCode;
    }

    public void setTimeCode(String timeCode) {
        this.timeCode = timeCode;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getDataRep() {
        return dataRep;
    }

    public void setDataRep(String dataRep) {
        this.dataRep = dataRep;
    }

    public Double getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(Double numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }

    public String getWriteProtect() {
        return writeProtect;
    }

    public void setWriteProtect(String writeProtect) {
        this.writeProtect = writeProtect;
    }

    public String getAbscissaUnits() {
        return abscissaUnits;
    }

    public void setAbscissaUnits(String abscissaUnits) {
        this.abscissaUnits = abscissaUnits;
    }

    public Double getAbscissaStart() {
        return abscissaStart;
    }

    public void setAbscissaStart(Double abscissaStart) {
        this.abscissaStart = abscissaStart;
    }

    public Double getAbscissaDelta() {
        return abscissaDelta;
    }

    public void setAbscissaDelta(Double abscissaDelta) {
        this.abscissaDelta = abscissaDelta;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getSubrecords() {
        return numberOfSubRecords;
    }

    public void setNumberOfSubRecords(Integer numberOfSubRecords) {
        this.numberOfSubRecords = numberOfSubRecords;
    }

    public Integer getBytesPerRecord() {
        return bytesPerRecord;
    }

    public void setBytesPerRecord(Integer bytesPerRecord) {
        this.bytesPerRecord = bytesPerRecord;
    }

    /*     public List<PodSubElement> getSubElements() {
        return subElements;
    }

    public void setSubElements(List<PodSubElement> subElements) {
        this.subElements = subElements;
    } */

    public String getRawStartTime() {
        return rawStartTime;
    }

    public void setRawStartTime(String rawStartTime) {
        this.rawStartTime = rawStartTime;
    }

    public String getIngestSite() {
        return ingestSite;
    }

    public void setIngestSite(String ingestSite) {
        this.ingestSite = ingestSite;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getPodDwellId() {
        return podDwellId;
    }

    public void setPodDwellId(String podDwellId) {
        this.podDwellId = podDwellId;
    }

    public String getMappingId() {
        return mappingId;
    }

    public void setMappingId(String mappingId) {
        this.mappingId = mappingId;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        List<QueryField> specialCaseQueryableFields = new ArrayList<>(Arrays.asList(
                new QueryField("missionId", "Mission ID", FieldType.STRING, "missionId", AUTOCOMPLETE_DATA_TYPE)));
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
