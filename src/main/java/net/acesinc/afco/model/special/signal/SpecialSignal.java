/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.special.signal;

import static net.acesinc.afco.model.special.signal.SpecialSignalField.ANALYST;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.ASSOCIATED_MAPPING_ID;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.BW;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.CASE_NOTS;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.DATA_FORMAT;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.FOLDER_NAME_ID;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.FREQUENCY;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.ID_NO;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.INGEST_SITE;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.KEYWORD;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.LOCATION;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.MAPPING_ID;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.MISSION_AOR;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.MISSION_ID;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.MISSION_NAME;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.MODULATION;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.MOD_TYPE;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.OPERATOR_ID;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.OP_SID;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.PARENT_MAPPING_ID;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.PDDG;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.SIGAD;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.SIGNAL_TYPE;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.SIG_ID;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.SPECIAL_FIELD_1;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.SPECIAL_FIELD_2;
import static net.acesinc.afco.model.special.signal.SpecialSignalField.TASK_ID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.Data;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.changelog.ChangeLog;
import net.acesinc.afco.model.classification.Classification;
import net.acesinc.afco.model.deserializer.PointDeserializer;
import net.acesinc.afco.model.distribution.Distributable;
import net.acesinc.afco.model.distribution.DistributionLog;
import net.acesinc.afco.model.event.Comment;
import net.acesinc.afco.model.hal.HALResponse;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import net.acesinc.afco.model.query.UnitType;
import net.acesinc.afco.model.rtp.audio.SignalTypes;
import net.acesinc.afco.model.view.Views;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

/**
 * SpecialSignal bean: for representing data retrieved from the data source.
 * Attempted to make it impossible for this to return nulls by adding getter safeguards.  Unfortunately, the UI is designed in such a way, where it has to have nulls
 * or won't work properly.  The problem is, that's a huge pain and problematic in the Java world for a data bean like this to be null-centric.
 * Added @NonNull and @Nullable annotations to help mark this bean up for future improvement.
 * Even though ArrayLists are instantiated in the field, we were still getting null returns on Lists unfortunately.
 * AE-4533 was created to fix the UI to not require nulls for certain fields.
 *
 * @author jeremytaylor
 */
@Document(collection = "specialSignal")
@JsonPropertyOrder({
    "id",
    "classification",
    "mappingId",
    "parentMappingId",
    "missionId",
    "idNo",
    "startTime",
    "stopTime",
    "lastUpdated",
    "_links"
})
@Data
public class SpecialSignal extends HALResponse implements Queryable, Cloneable, Distributable {
    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "special-signal";

    @JsonIgnore
    protected static final List<String> NON_QUERYABLE_FIELDS = Arrays.asList(
            "AUTOCOMPLETE_DATA_TYPE",
            "NON_QUERYABLE_FIELDS",
            "SPECIAL_CASE_QUERYABLE_FIELDS",
            "SELF",
            "classification",
            "type",
            "log",
            "changeLog",
            "_links",
            "fileNamePrefix");

    @JsonIgnore
    protected static final List<QueryField> SPECIAL_CASE_QUERYABLE_FIELDS = Arrays.asList(
            new QueryField(ANALYST, "Analyst", FieldType.STRING, ANALYST, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(
                    ASSOCIATED_MAPPING_ID,
                    "Associated Mapping ID",
                    FieldType.STRING,
                    ASSOCIATED_MAPPING_ID,
                    null,
                    false,
                    null),
            new QueryField(BW, "Bandwidth", FieldType.DOUBLE, UnitType.MHZ),
            new QueryField(CASE_NOTS, "Case Notation", FieldType.STRING, CASE_NOTS, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(DATA_FORMAT, "Data Format", FieldType.ENUM, DATA_FORMAT, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(FOLDER_NAME_ID, "Folder Name ID", FieldType.STRING, FOLDER_NAME_ID, null, false, null),
            new QueryField(FREQUENCY, "Frequency", FieldType.DOUBLE, UnitType.MHZ),
            new QueryField(ID_NO, "IDNO", FieldType.STRING, ID_NO, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(INGEST_SITE, "Ingest Site", FieldType.ENUM, INGEST_SITE, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(KEYWORD, "Keyword", FieldType.STRING, KEYWORD, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(LOCATION, "Location", FieldType.POINT),
            new QueryField(MISSION_AOR, "Mission AoR", FieldType.ENUM, MISSION_AOR, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(MAPPING_ID, "Mapping ID", FieldType.STRING, MAPPING_ID, null, false, null),
            new QueryField(MISSION_ID, "Mission ID", FieldType.STRING, MISSION_ID, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(MISSION_NAME, "Mission Name", FieldType.STRING, MISSION_NAME, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(MOD_TYPE, "Mod Type", FieldType.ENUM, MOD_TYPE, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(MODULATION, "Modulation", FieldType.ENUM, MODULATION, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(
                    PARENT_MAPPING_ID, "Parent Mapping ID", FieldType.STRING, PARENT_MAPPING_ID, null, false, null),
            new QueryField(PDDG, "PDDG", FieldType.ENUM, PDDG, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(OPERATOR_ID, "Operator ID", FieldType.STRING, OPERATOR_ID, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(OP_SID, "Op Sid", FieldType.STRING, OP_SID, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(SIGAD, "Sigad", FieldType.ENUM, SIGAD, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(SIG_ID, "Sig ID", FieldType.STRING, SIG_ID, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(SIGNAL_TYPE, "Signal Type", FieldType.INTEGER, SIGNAL_TYPE, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(SPECIAL_FIELD_1, "Special Field 1", FieldType.LONG, SPECIAL_FIELD_1, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(
                    SPECIAL_FIELD_2, "Special Field 2", FieldType.STRING, SPECIAL_FIELD_2, AUTOCOMPLETE_DATA_TYPE),
            new QueryField(TASK_ID, "Task ID", FieldType.STRING, TASK_ID, AUTOCOMPLETE_DATA_TYPE));

    @JsonView(Views.DashboardView.class)
    private String id;

    @JsonView(Views.DashboardView.class)
    private Classification classification = new Classification();
    /**
     * User cannot input ingestSite.  This field will never be null though.
     */
    @JsonView(Views.FullView.class)
    private String ingestSite = "";

    @JsonView(Views.FullView.class)
    private Date lastUpdated;

    @JsonView(Views.DashboardView.class)
    private String missionId = "";

    @JsonView(Views.DashboardView.class)
    private String idNo = "";

    @JsonView(Views.DashboardView.class)
    private String mappingId = "";

    /**
     * The associated mapping ID is set by the UI and gives the operators
     * a way to link a Special Signal to another IDNO that contains
     * associated files, such as Pre-D
     */
    @JsonView(Views.DashboardView.class)
    private String associatedMappingId = "";

    @JsonView(Views.FullView.class)
    private String parentMappingId = "";

    @JsonView(Views.DashboardView.class)
    private List<String> casenots =
            new ArrayList<>(); // this will now never be null -- gets rid of null check when folks are trying to update

    @JsonView(Views.FullView.class)
    private List<String> categories =
            new ArrayList<>(); // this will now never be null -- gets rid of null check when folks are trying to update

    @JsonView(Views.FullView.class)
    private List<Object> results =
            new ArrayList<>(); // this will now never be null -- gets rid of null check when folks are trying to update

    @JsonView(Views.FullView.class)
    private List<Object> spectrogramResults =
            new ArrayList<>(); // this will now never be null -- gets rid of null check when folks are trying to update

    @JsonView(Views.DashboardView.class)
    private String sigad;

    @JsonView(Views.FullView.class)
    private String fileNamePrefix;

    @JsonView(Views.DashboardView.class)
    private Double frequency = 0.0D;

    @JsonView(Views.FullView.class)
    private Double bw = 0.0D;

    @JsonView(Views.FullView.class)
    private Integer priority = 0;
    /**
     * The modulation type of the special signal. It is populated on ingest.
     * Used to populate the "rcvrdetectmode" field for BROADSKY sightings and
     * the "Detect Mode" field in the UI.
     * <p>
     * <p>
     * User can input modType as detect-mode-- behaves better w/ UI when this is set to empty-string and getter is non-null.
     */
    @JsonView(Views.DashboardView.class)
    private String modType = "";

    @JsonView(Views.FullView.class)
    private String opNote = "";

    @JsonView(Views.FullView.class)
    private List<Comment> opNotes = new ArrayList<>(); // this will now never be null -- gets rid of a null check

    @JsonView(Views.FullView.class)
    private String keyword;

    @JsonView(Views.DashboardView.class)
    private String pddg;

    @JsonView(Views.DashboardView.class)
    private Boolean highPriority = false;

    /**
     * Manual reference to the _id field in the SpecialSignalFolder class
     */
    @JsonView(Views.DashboardView.class)
    private String folderNameId;
    /**
     * The mission name that the folderNameId refers to in the
     * specialSignalFolder collection
     */
    @JsonView(Views.FullView.class)
    private String missionName = "";
    /**
     * User can input taskId -- behaves better w/ UI when this is set to empty-string and getter is non-null.
     */
    @JsonView(Views.FullView.class)
    private String taskId = "";

    @JsonView(Views.DashboardView.class)
    private String dataFormat = "UNKNOWN";
    /**
     * The start time of the WHOLE stream of the special signal, which would
     * be the startTime of the particular mission and idNo combination. This
     * is populated on ingest.  This value is used in the regular IDNO ingest
     * in terms of using it to populate the “DTG Up” field for the subject
     * collection and will match this value there.
     */
    @JsonView(Views.DashboardView.class)
    private Date startTime;
    /**
     * The stopTime of the special signal cut of the unique mission and idNo combination.
     * This is populated on ingest. Can also be used to populate the “DTG Down” field in the UI.
     * The “DTG Down” in the subject collection should now match this value. This is ONLY derived
     * from the current packet timestamp or when a timeout occurs.  This is intended to be the time
     * of the cut.
     */
    @JsonView(Views.DashboardView.class)
    private Date stopTime;
    /**
     * User can input sigId -- behaves better w/ UI when this is set to empty-string and getter is non-null.
     */
    @JsonView(Views.DashboardView.class)
    private String sigId = "";
    /**
     * The modulation of the special signal. It is populated only by the UI and
     * required for BROADSKY sightings. Not populated on ingest.
     * <p>
     * User can input modulation -- behaves better w/ UI when this is set to empty-string and getter is non-null.
     */
    @JsonView(Views.DashboardView.class)
    private String modulation = "";

    @Nullable
    @JsonView(Views.FullView.class)
    private Double keyspeed = null;
    /**
     * opSid: DEPRECATION NOTICE.  OPERATORID WILL REPLACE OPSID
     */
    @Deprecated
    @JsonView(Views.FullView.class)
    private String opSid = "";
    /**
     * Objection: We are being asked to provide poor quality coding in Java to support a null-thirsty experience on the front-end.  Through poor logic handling on the front-end,
     * it was requested to have this field return null when not filled in.  The front-end can be adjusted to handle things a better way w/o causing a null-thirsty situation on the
     * back-end Java baseline.
     * If location is null, this will be null now regardless if that causes JSON and XML building issues during distribution phases.  It usually goes the wrong way to have a null-thirsty baseline and makes your baseline buggy.
     */
    @JsonView(Views.DashboardView.class)
    @JsonDeserialize(using = PointDeserializer.class)
    private Point location = null;
    /**
     * User can input missionAor -- behaves better w/ UI when this is set to empty-string and getter is non-null.
     */
    @JsonView(Views.FullView.class)
    private String missionAor = "";

    @JsonView(Views.DashboardView.class)
    private Boolean scheduledForDistribution = false;

    @JsonView(Views.FullView.class)
    private String semiMajor;

    @JsonView(Views.FullView.class)
    private String semiMinor;

    @JsonView(Views.FullView.class)
    private String tilt;
    /**
     * The sample rate coming from RTP encrypted audio stream XML metadata only
     * via related NMPG agent. Clarification: sampleRate in dataFile related
     * info will ALSO come from metadata of the RTP streams for RTP encrypted
     * audio stream derived data. In this case, sampleRate will be originally
     * derived from payloadType of RTP header.
     */
    @JsonView(Views.DashboardView.class)
    private Double streamSampleRate = 0.0D;

    @JsonView(Views.FullView.class)
    private List<ChangeLog> changeLog = new ArrayList<>(); // cannot be null

    @JsonView(Views.FullView.class)
    private List<DistributionLog> distributionLog = new ArrayList<>(); // cannot be null

    /**
     * The analyst field for sending to BROADSKY that can now be set in the UI as of AE-6550
     */
    @JsonView(Views.DashboardView.class)
    private String analyst = "";

    /**
     * operatorId: The operatorID
     * <p>
     * User can input operatorId -- behaves better w/ UI when this is set to empty-string and getter is non-null.
     */
    @JsonView(Views.DashboardView.class)
    private String operatorId = "";

    /**
     * signalType: The associated signalType
     */
    @JsonView(Views.DashboardView.class)
    private Integer signalType = SignalTypes.SIGNAL_TYPE_UNKNOWN
            .signalTypeValue()
            .intValue(); // 0 = UNKNOWN type by default, might as well set it

    /**
     * specialField1: The specialField1
     */
    @JsonView(Views.DashboardView.class)
    private Long specialField1;
    /**
     * specialField2: The specialField2
     */
    @JsonView(Views.DashboardView.class)
    private String specialField2;

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        return SPECIAL_CASE_QUERYABLE_FIELDS;
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

    public SpecialSignal() {
        super();
    }

    /**
     * @param specialField1 - The specialField1 to set
     */
    public void setSpecialField1(Long specialField1) {
        this.specialField1 = specialField1;
    }

    /**
     * @return - The specialField1: can return null
     */
    @Nullable
    public Long getSpecialField1() {
        return specialField1;
    }

    /**
     * @return the specialField2: can return null;
     */
    @Nullable
    public String getSpecialField2() {
        return this.specialField2;
    }

    /**
     * @param specialField2 the specialField2 to set
     */
    public void setSpecialField2(String specialField2) {
        this.specialField2 = specialField2;
    }

    /**
     * @return the analyst
     */
    @Override
    @NonNull
    public String getAnalyst() {
        return analyst;
    }

    /**
     * @param analyst the analyst to set
     */
    public void setAnalyst(String analyst) {
        this.analyst = analyst;
    }

    /**
     * User can input operatorId -- behaves better w/ UI when this is set to empty-string and getter is non-null.
     *
     * @return the operatorId - If operatorId is null, then return an empty String
     */
    @NonNull
    public String getOperatorId() {
        return Optional.ofNullable(this.operatorId).orElse("");
    }

    /**
     * @param operatorId the operatorId to set
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * @return the signalType -- SignalTypes.SIGNAL_TYPE_UNKNOWN.signalTypeValue().intValue() for UNKNOWN signalType if null
     */
    @NonNull
    public Integer getSignalType() {
        return Optional.ofNullable(signalType)
                .orElse(SignalTypes.SIGNAL_TYPE_UNKNOWN.signalTypeValue().intValue());
    }

    /**
     * @param signalType the signalType to set
     */
    public void setSignalType(Integer signalType) {
        this.signalType = signalType;
    }

    /**
     * not possible for this to be null as mongo creates this
     *
     * @return the id
     */
    @NonNull
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
     * @return the classification
     */
    @NonNull
    public Classification getClassification() {
        Assert.notNull(this.classification, "classification should NEVER be null");
        return this.classification;
    }

    /**
     * @param classification the classification to set
     */
    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    /**
     * @return the ingestSite
     */
    @NonNull
    public String getIngestSite() {
        return Optional.ofNullable(ingestSite).orElse("");
    }

    /**
     * @param ingestSite the ingestSite to set
     */
    public void setIngestSite(String ingestSite) {
        this.ingestSite = ingestSite;
    }

    /**
     * @return the lastUpdated
     */
    @Nullable
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
     * @return the missionId
     */
    @NonNull
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
    @NonNull
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
     * @return the mappingId
     */
    @NonNull
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
     * @return the associatedMappingId
     */
    @NonNull
    public String getAssociatedMappingId() {
        return associatedMappingId;
    }

    /**
     * @param associatedMappingId the associatedMappingId to set
     */
    public void setAssociatedMappingId(String associatedMappingId) {
        this.associatedMappingId = associatedMappingId;
    }

    /**
     * @return the casenots
     */
    @NonNull
    public List<String> getCasenots() {
        return this.casenots;
    }

    /**
     * @param casenots the casenots to set
     */
    public void setCasenots(List<String> casenots) {
        this.casenots = casenots;
    }

    /**
     * @return the categories
     */
    @NonNull
    public List<String> getCategories() {
        return this.categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    /**
     * @return the sigad
     */
    @Nullable
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
     * @return the fileNamePrefix
     */
    @Override
    @Nullable
    public String getFileNamePrefix() {
        return fileNamePrefix;
    }

    /**
     * @param fileNamePrefix the fileNamePrefix to set
     */
    @Override
    public void setFileNamePrefix(String fileNamePrefix) {
        this.fileNamePrefix = fileNamePrefix;
    }

    /**
     * @return the frequency
     */
    @NonNull
    public Double getFrequency() {
        return Optional.ofNullable(this.frequency).orElse(0.0D);
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
    @NonNull
    public Double getBw() {
        return Optional.ofNullable(this.bw).orElse(0.0D);
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
    @NonNull
    public Integer getPriority() {
        return Optional.ofNullable(this.priority).orElse(0);
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * User can input modType as detect-mode-- behaves better w/ UI when this is set to empty-string and getter is non-null.
     *
     * @return the modType
     */
    @NonNull
    public String getModType() {
        return Optional.ofNullable(modType).orElse("");
    }

    /**
     * @param modType the modType to set
     */
    public void setModType(String modType) {
        this.modType = modType;
    }

    /**
     * return the opNote
     */
    @NonNull
    public String getOpNote() {
        return this.opNote;
    }

    /**
     * @param opNote set opNote
     */
    public void setOpNote(String opNote) {
        this.opNote = opNote;
    }

    /**
     * return opNote list
     */
    @NonNull
    public List<Comment> getOpNotes() {
        return this.opNotes;
    }

    /**
     * @param opNotes set opNotes list type Comment
     */
    public void setOpNotes(List<Comment> opNotes) {
        this.opNotes = opNotes;
    }

    /**
     * Unfortunately, the UI misbehaves if null is prevented here
     *
     * @return the keyword
     */
    @Nullable
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
     * Unfortunately, the UI misbehaves if null is prevented here
     *
     * @return the pddg
     */
    @Nullable
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
    @NonNull
    public Boolean isHighPriority() {
        return Optional.ofNullable(this.highPriority).orElse(false);
    }

    /**
     * @param highPriority the highPriority to set
     */
    public void setHighPriority(Boolean highPriority) {
        this.highPriority = highPriority;
    }

    /**
     * This field is not being ingested by the XSL, so this is someone's hack. It is anyone's guess how this is populated, and I have no idea what populates this other than the user.
     * So, treating this is it could be null at some point in time.
     * Unfortunately, the UI misbehaves if null is prevented here.
     *
     * @return the folderNameId
     */
    @Nullable
    public String getFolderNameId() {
        return folderNameId;
    }

    /**
     * @param folderNameId the folderNameId to set
     */
    public void setFolderNameId(String folderNameId) {
        this.folderNameId = folderNameId;
    }

    /**
     * This field is not being ingested by the XSL, so this is someone's hack. It is anyone's guess how this is populated, and I have no idea what populates this other than the user.
     * So, treating this is it could be null at some point in time.
     * Unfortunately, the UI misbehaves if null is prevented here.
     *
     * @return the missionName
     */
    @Nullable
    public String getMissionName() {
        return missionName;
    }

    /**
     * @param missionName the missionName to set
     */
    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    /**
     * User can input taskId -- behaves better w/ UI when this is set to empty-string and getter is non-null.
     *
     * @return the taskId
     */
    @NonNull
    public String getTaskId() {
        return Optional.ofNullable(this.taskId).orElse("");
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
    @NonNull
    public String getDataFormat() {
        return Optional.ofNullable(this.dataFormat).orElse("UNKNOWN");
    }

    /**
     * @param dataFormat the dataFormat to set
     */
    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }

    /**
     * @return the distributionReferenceUrlPath that gets built with the mappingId
     */
    @Nullable
    public String getDistributionReferenceUrlPath() {
        return String.format("special-signal/%s/details", mappingId);
    }

    /**
     * @return the startTime
     */
    @Nullable
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
    @Nullable
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
     * User can input sigId -- behaves better w/ UI when this is set to empty-string and getter is non-null.
     *
     * @return the sigId
     */
    @NonNull
    public String getSigId() {
        return Optional.ofNullable(sigId).orElse("");
    }

    /**
     * @param sigId the sigId to set
     */
    public void setSigId(String sigId) {
        this.sigId = sigId;
    }

    /**
     * User can input modulation -- behaves better w/ UI when this is set to empty-string and getter is non-null.
     *
     * @return the modulation
     */
    @NonNull
    public String getModulation() {
        return Optional.ofNullable(modulation).orElse("");
    }

    /**
     * @param modulation the modulation to set
     */
    public void setModulation(String modulation) {
        this.modulation = modulation;
    }

    /**
     * Unfortunately, the UI misbehaves if null is prevented here
     *
     * @return the keyspeed
     */
    @Nullable
    public Double getKeyspeed() {
        return this.keyspeed;
    }

    /**
     * @param keyspeed the keyspeed to set
     */
    public void setKeyspeed(Double keyspeed) {
        this.keyspeed = keyspeed;
    }

    /**
     * @return the opSid, Unfortunately, the UI misbehaves if null is prevented here
     * @deprecated DEPRECATION NOTICE.  OPERATORID WILL REPLACE OPSID
     */
    @NonNull
    public String getOpSid() {
        return Optional.ofNullable(this.opSid).orElse("");
    }

    /**
     * @param opSid the opSid to set
     * @deprecated DEPRECATION NOTICE.  OPERATORID WILL REPLACE OPSID
     */
    public void setOpSid(String opSid) {
        this.opSid = opSid;
    }

    /**
     * Objection: We are being asked to provide poor quality coding in Java to support a null-thirsty experience on the front-end.  Through poor logic handling on the front-end,
     * it was requested to have this field return null when not filled in.  The front-end can be adjusted to handle things a better way w/o causing a null-thirsty situation on the
     * back-end Java baseline.
     * This getter will return null on location when null. It usually goes the wrong way to have a null-thirsty baseline and makes your baseline buggy.
     *
     * @return the location
     */
    @Nullable
    public Point getLocation() {
        return this.location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Point location) {
        this.location = location;
    }

    /**
     * User can input missionAor -- behaves better w/ UI when this is set to empty-string and getter is non-null.
     *
     * @return the missionAor
     */
    @NonNull
    public String getMissionAor() {
        return Optional.ofNullable(missionAor).orElse("");
    }

    /**
     * @param missionAor the missionAor to set
     */
    public void setMissionAor(String missionAor) {
        this.missionAor = missionAor;
    }

    /**
     * Sample rate should pretty much always have a real value based on how ingest works.
     *
     * @return the streamSampleRate
     */
    @NonNull
    public Double getStreamSampleRate() {
        return Optional.ofNullable(this.streamSampleRate).orElse(0.0D);
    }

    /**
     * @param streamSampleRate the streamSampleRate to set
     */
    public void setStreamSampleRate(Double streamSampleRate) {
        this.streamSampleRate = streamSampleRate;
    }

    /**
     * @return the changeLog
     */
    @NonNull
    public List<ChangeLog> getChangeLog() {
        return this.changeLog;
    }

    /**
     * @param changeLog the changeLog to set
     */
    public void setChangeLog(List<ChangeLog> changeLog) {
        this.changeLog = changeLog;
    }

    /**
     * Add a changeLog entry to the changeLog list if the new value differs from
     * the old value. Otherwise, it is ignored.
     *
     * @param changeLog The ChangeLog object to add
     * @return True if changeLog was added, False otherwise
     */
    public boolean addChangeLog(ChangeLog changeLog) {
        Optional<Object> newValue = Optional.ofNullable(changeLog.getNewValue());
        Optional<Object> oldValue = Optional.ofNullable(changeLog.getOldValue());
        // If the new value is different than the old value, then add it to the changeLog list and return true
        if ((!newValue.isPresent() && oldValue.isPresent())
                || (newValue.isPresent() && !newValue.get().equals(oldValue.orElse(null)))) {
            this.changeLog.add(changeLog);
            return true;
        }

        // Otherwise return false
        return false;
    }

    /**
     * @return the results
     */
    @NonNull
    public List<Object> getResults() {
        return this.results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<Object> results) {
        this.results = results;
    }

    /**
     * @return the spectrogramResults
     */
    @NonNull
    public List<Object> getSpectrogramResults() {
        return this.spectrogramResults;
    }

    /**
     * @param spectrogramResults the spectrogramResults to set
     */
    public void setSpectrogramResults(List<Object> spectrogramResults) {
        this.spectrogramResults = spectrogramResults;
    }

    /**
     * @return the parentMappingId
     */
    @NonNull
    public String getParentMappingId() {
        if (StringUtils.isBlank(parentMappingId)) {
            return mappingId;
        }
        return parentMappingId;
    }

    /**
     * @param parentMappingId the parentMappingId to set
     */
    public void setParentMappingId(String parentMappingId) {
        this.parentMappingId = parentMappingId;
    }

    /**
     * @return the scheduledForDistribution
     */
    @NonNull
    public Boolean getScheduledForDistribution() {
        return Optional.ofNullable(this.scheduledForDistribution).orElse(Boolean.FALSE);
    }

    /**
     * @param scheduledForDistribution the scheduledForDistribution to set
     */
    public void setScheduledForDistribution(Boolean scheduledForDistribution) {
        this.scheduledForDistribution = scheduledForDistribution;
    }

    /**
     * @return the semiMajor
     */
    @Nullable
    public String getSemiMajor() {
        return semiMajor;
    }

    /**
     * @param semiMajor the semiMajor to set
     */
    public void setSemiMajor(String semiMajor) {
        this.semiMajor = semiMajor;
    }

    /**
     * @return the semiMinor
     */
    @Nullable
    public String getSemiMinor() {
        return semiMinor;
    }

    /**
     * @param semiMinor the semiMinor to set
     */
    public void setSemiMinor(String semiMinor) {
        this.semiMinor = semiMinor;
    }

    /**
     * @return the tilt
     */
    @Nullable
    public String getTilt() {
        return tilt;
    }

    /**
     * @param tilt the tilt to set
     */
    public void setTilt(String tilt) {
        this.tilt = tilt;
    }

    /**
     * @return the distributionLog
     */
    @NonNull
    public List<DistributionLog> getDistributionLog() {
        return this.distributionLog;
    }

    /**
     * @param distributionLog the distributionLog to set
     */
    public void setDistributionLog(List<DistributionLog> distributionLog) {
        this.distributionLog = distributionLog;
    }

    @Override
    public Object clone() {
        SpecialSignal s = new SpecialSignal();
        s.setBw(this.bw);
        s.setCasenots(this.casenots);
        s.setCategories(this.categories);
        s.setChangeLog(this.changeLog);
        s.setClassification(this.classification);
        s.setDistributionLog(this.distributionLog);
        s.setDataFormat(this.dataFormat);
        s.setFolderNameId(this.folderNameId);
        s.setFrequency(this.frequency);
        s.setHighPriority(this.highPriority);
        s.setId(this.id);
        s.setIdNo(this.idNo);
        s.setHighPriority(this.highPriority);
        s.setIngestSite(this.ingestSite);
        s.setKeyspeed(this.keyspeed);
        s.setKeyword(this.keyword);
        s.setLastUpdated(this.lastUpdated);
        s.setLocation(this.location);
        s.setMappingId(this.mappingId);
        s.setMissionAor(this.missionAor);
        s.setMissionId(this.missionId);
        s.setMissionName(this.missionName);
        s.setModType(this.modType);
        s.setModulation(this.modulation);
        s.setOperatorId(this.operatorId);
        s.setOpNotes(this.opNotes);
        s.setParentMappingId(this.parentMappingId);
        s.setPriority(this.priority);
        s.setResults(this.results);
        s.setPddg(this.pddg);
        s.setScheduledForDistribution(this.scheduledForDistribution);
        s.setSemiMajor(this.semiMajor);
        s.setSemiMinor(this.semiMinor);
        s.setSigad(this.sigad);
        s.setSigId(this.sigId);
        s.setSignalType(this.signalType);
        s.setSpecialField1(this.specialField1);
        s.setSpecialField2(this.specialField2);
        s.setSpectrogramResults(this.spectrogramResults);
        s.setStreamSampleRate(this.streamSampleRate);
        s.setStartTime(this.startTime);
        s.setStopTime(this.stopTime);
        return s;
    }
}
