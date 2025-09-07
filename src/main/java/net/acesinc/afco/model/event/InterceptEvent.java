/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.event.signal.Characterization;
import net.acesinc.afco.model.event.signal.IdentOfEmit;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import net.acesinc.afco.model.view.Views;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jeremytaylor
 */
@Document(collection = "intercept_event")
public class InterceptEvent extends Event {

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "elint-intercept";

    @JsonView(Views.DashboardView.class)
    private String missionId;

    @JsonView(Views.DashboardView.class)
    private Long signalId;

    @JsonView(Views.DefaultView.class)
    private Date startTime;

    @JsonView(Views.DefaultView.class)
    private Date stopTime;

    @JsonView(Views.DashboardView.class)
    private Characterization characterization;

    @JsonView(Views.FullView.class)
    private List<IdentOfEmit> idents = new ArrayList<>();

    @JsonView(Views.DefaultView.class)
    private Integer year;

    @JsonView(Views.DefaultView.class)
    private String interceptId;

    @JsonView(Views.DefaultView.class)
    private String dwellId;
    /**
     * This is the same as sensorNumber within the schema.
     */
    @JsonView(Views.DefaultView.class)
    private Long sensorId;
    /**
     * This is the same as collectorId within the schema.
     */
    @JsonView(Views.DefaultView.class)
    private String platformId;

    @JsonView(Views.DefaultView.class)
    private Integer pulseCount;

    public InterceptEvent() {
        setType(EventType.INTERCEPT);
    }

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        List<QueryField> specialCaseQueryableFields = new ArrayList<>(Arrays.asList(
                new QueryField("dwellId", "Dwell Id", FieldType.STRING, "dwellId", null, false, null),
                new QueryField("idents", "ELNOT", FieldType.STRING, "idents.ident", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("interceptId", "Intercept Id", FieldType.STRING, "interceptId", null, false, null),
                new QueryField("missionId", "Mission Id", FieldType.STRING, "missionId", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("platformId", "Platform Id", FieldType.STRING, "platformId", AUTOCOMPLETE_DATA_TYPE)));
        specialCaseQueryableFields.addAll(SPECIAL_CASE_QUERYABLE_FIELDS);

        return specialCaseQueryableFields;
    }

    @Override
    @JsonIgnore
    public List<String> getNonQueryableFields() {
        List<String> nonQueryableFields = new ArrayList<>(Arrays.asList("characterization"));
        nonQueryableFields.addAll(NON_QUERYABLE_FIELDS);

        return nonQueryableFields;
    }

    /**
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * @return the interceptId
     */
    public String getInterceptId() {
        return interceptId;
    }

    /**
     * @param interceptId the interceptId to set
     */
    public void setInterceptId(String interceptId) {
        this.interceptId = interceptId;
    }

    /**
     * @return the dwellId
     */
    public String getDwellId() {
        return dwellId;
    }

    /**
     * @param dwellId the dwellId to set
     */
    public void setDwellId(String dwellId) {
        this.dwellId = dwellId;
    }

    /**
     * @return the sensorId
     */
    public Long getSensorId() {
        return sensorId;
    }

    /**
     * @param sensorId the sensorId to set
     */
    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * @return the pulseCount
     */
    public Integer getPulseCount() {
        return pulseCount;
    }

    /**
     * @param pulseCount the pulseCount to set
     */
    public void setPulseCount(Integer pulseCount) {
        this.pulseCount = pulseCount;
    }

    /**
     * @return the platformId
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * @param platformId the platformId to set
     */
    public void setPlatformId(String platformId) {
        this.platformId = platformId;
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
}
