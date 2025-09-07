/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.file;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Data;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import net.acesinc.afco.model.query.UnitType;
import net.acesinc.afco.model.view.Views;

/**
 *
 * @author andrewserff
 */
@Data
public class AudioDataFile extends DataFile {
    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "audio";
    /**
     * Explaining startTime for AudioDataFile:
     * 1) For siphoned AUDIO WAV files
     * from a stream, this time is ingested when the WAV is being ingested and
     * this value is approximated by taking the stopTime (derived from the RTP
     * packet's currentPacketTimestamp) and using the utility called sox to
     * obtain the duration. When we take the stopTime and duration for audio, we
     * approximate the startTime for a wav file, so audio files do have a
     * meaningful value here.
     * 2) For AUDIO WAV files from a CUT-zip, the
     * directory_file, which is a metadata file gives us the stop and start
     * times of each wav more or less and so startTime is determined that way in
     * that scenario.
     * 3) For DAT files (a.k.a. special
     * signals/binary-cuts/encrypted-audio/BINARY_DATA), this startTime is NEVER
     * ingested into this related collection (dataFile) via the related XSL
     * for this possible ingest and XSL is the only means for this type of data
     * to be ingested. As streamId was removed, it could be possible for us to eventually ingest
     * the startTime for the BINARY_DATA scenario of the related XSL.
     * This startTime, if eventually ingested, would mean the start time of the ENTIRE stream, which would now
     * also relate to being the start time of the particular mission & idno combination, which makes up the
     * revised mappingId for the dataFile collection for special signals DAT files.
     * The startTime of the related, decrypted WAV file is more than likely auto-calculated instead during ingest and is likely far more helpful.
     * Nevertheless, this info may be revised and revisited at a later time if and when ingest of DAT files is revisited in this scope.
     *
     */
    // private Date startTime;
    // This field is now in SpecialSignals.java, keeping as commented out to explain the ingest above
    /**
     * This is the stopTime of a file. If a time out occurs, this was the
     * approximated value. When a timeout does not occur, this is usually the
     * value from the currentPacketTimestamp derived from the RTP extended
     * header.
     */
    // private Date stopTime;
    // This field is now in SpecialSignals.java, keeping as commented out to explain the ingest above

    @JsonView(Views.DashboardView.class)
    private Long duration;

    @JsonView(Views.DashboardView.class)
    private Boolean contiguous;

    @JsonView(Views.FullView.class)
    private List<AudioGist> audioGists;

    @JsonView(Views.FullView.class)
    private AudioAnalysis audioAnalysis;

    // RTP stream oriented items
    /**
     * the sample rate of the RTP stream whether encrypted or unencrypted audio
     * streams as transport
     */
    @JsonView(Views.DashboardView.class)
    private Double sampleRate;
    /**
     * The payloadType of the RTP stream. The enum PayloadType is not used here
     * as that is more agent focused, but an instance of PayloadType may be
     * obtained with the integer value of the payloadType here.
     */
    @JsonView(Views.DashboardView.class)
    private Integer payloadType;

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        List<QueryField> specialCaseQueryableFields = new ArrayList<>(Arrays.asList(
                new QueryField("assignmentId", "Assignment ID", FieldType.STRING, "assignmentId", null, false, null),
                new QueryField("mappingId", "Assignment ID", FieldType.STRING, "mappingId", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("bw", "Bandwidth", FieldType.DOUBLE, UnitType.MHZ),
                new QueryField(
                        "audioGists", "Gist Created By", FieldType.STRING, "audioGists.user", AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "audioGists",
                        "Gist Updated By",
                        FieldType.STRING,
                        "audioGists.lastUpdatedByUser",
                        AUTOCOMPLETE_DATA_TYPE)));
        specialCaseQueryableFields.addAll(SPECIAL_CASE_QUERYABLE_FIELDS);

        return specialCaseQueryableFields;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AudioDataFile [duration=");
        builder.append(duration);
        builder.append(", contiguous=");
        builder.append(contiguous);
        builder.append(", audioGists=");
        builder.append(audioGists);
        builder.append(", audioAnalysis=");
        builder.append(audioAnalysis);
        builder.append(", sampleRate=");
        builder.append(sampleRate);
        builder.append(", payloadType=");
        builder.append(payloadType);
        builder.append(", source=");
        builder.append(getSource());
        builder.append(", status=");
        builder.append(getStatus());
        builder.append(", getNonQueryableFields()=");
        builder.append(getNonQueryableFields());
        builder.append(", getQueryableSubclasses()=");
        builder.append(getQueryableSubclasses());
        builder.append(", getAbsolutePath()=");
        builder.append(getAbsolutePath());
        builder.append(", getFileName()=");
        builder.append(getFileName());
        builder.append(", getSize()=");
        builder.append(getSize());
        builder.append(", getIngestDate()=");
        builder.append(getIngestDate());
        builder.append(", getDataType()=");
        builder.append(getDataType());
        builder.append(", getMimeType()=");
        builder.append(getMimeType());
        builder.append(", getSite()=");
        builder.append(getSite());
        builder.append(", getUser()=");
        builder.append(getUser());
        builder.append(", getUuid()=");
        builder.append(getUuid());
        builder.append(", getDistributionReferenceUrlPath()=");
        builder.append(getDistributionReferenceUrlPath());
        builder.append(", getSpecialField1()=");
        builder.append(getSpecialField1());
        builder.append(", getSpecialField2()=");
        builder.append(getSpecialField2());
        builder.append(", getAnalyst()=");
        builder.append(getAnalyst());
        builder.append(", getOperatorId()=");
        builder.append(getOperatorId());
        builder.append(", getSignalType()=");
        builder.append(getSignalType());
        builder.append(", getId()=");
        builder.append(getId());
        builder.append(", getClassification()=");
        builder.append(getClassification());
        builder.append(", getIngestSite()=");
        builder.append(getIngestSite());
        builder.append(", getLastUpdated()=");
        builder.append(getLastUpdated());
        builder.append(", getMissionId()=");
        builder.append(getMissionId());
        builder.append(", getIdNo()=");
        builder.append(getIdNo());
        builder.append(", getMappingId()=");
        builder.append(getMappingId());
        builder.append(", getAssociatedMappingId()=");
        builder.append(getAssociatedMappingId());
        builder.append(", getCasenots()=");
        builder.append(getCasenots());
        builder.append(", getCategories()=");
        builder.append(getCategories());
        builder.append(", getSigad()=");
        builder.append(getSigad());
        builder.append(", getFileNamePrefix()=");
        builder.append(getFileNamePrefix());
        builder.append(", getFrequency()=");
        builder.append(getFrequency());
        builder.append(", getBw()=");
        builder.append(getBw());
        builder.append(", getPriority()=");
        builder.append(getPriority());
        builder.append(", getModType()=");
        builder.append(getModType());
        builder.append(", getOpNote()=");
        builder.append(getOpNote());
        builder.append(", getOpNotes()=");
        builder.append(getOpNotes());
        builder.append(", getKeyword()=");
        builder.append(getKeyword());
        builder.append(", getPddg()=");
        builder.append(getPddg());
        builder.append(", isHighPriority()=");
        builder.append(isHighPriority());
        builder.append(", getFolderNameId()=");
        builder.append(getFolderNameId());
        builder.append(", getMissionName()=");
        builder.append(getMissionName());
        builder.append(", getTaskId()=");
        builder.append(getTaskId());
        builder.append(", getDataFormat()=");
        builder.append(getDataFormat());
        builder.append(", getStartTime()=");
        builder.append(getStartTime());
        builder.append(", getStopTime()=");
        builder.append(getStopTime());
        builder.append(", getSigId()=");
        builder.append(getSigId());
        builder.append(", getModulation()=");
        builder.append(getModulation());
        builder.append(", getKeyspeed()=");
        builder.append(getKeyspeed());
        builder.append(", getOpSid()=");
        builder.append(getOpSid());
        builder.append(", getLocation()=");
        builder.append(getLocation());
        builder.append(", getMissionAor()=");
        builder.append(getMissionAor());
        builder.append(", getStreamSampleRate()=");
        builder.append(getStreamSampleRate());
        builder.append(", getChangeLog()=");
        builder.append(getChangeLog());
        builder.append(", getResults()=");
        builder.append(getResults());
        builder.append(", getSpectrogramResults()=");
        builder.append(getSpectrogramResults());
        builder.append(", getParentMappingId()=");
        builder.append(getParentMappingId());
        builder.append(", getScheduledForDistribution()=");
        builder.append(getScheduledForDistribution());
        builder.append(", getSemiMajor()=");
        builder.append(getSemiMajor());
        builder.append(", getSemiMinor()=");
        builder.append(getSemiMinor());
        builder.append(", getTilt()=");
        builder.append(getTilt());
        builder.append(", getDistributionLog()=");
        builder.append(getDistributionLog());
        builder.append(", get_links()=");
        builder.append(get_links());
        builder.append(", getClass()=");
        builder.append(getClass());
        builder.append(", hashCode()=");
        builder.append(hashCode());
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
}
