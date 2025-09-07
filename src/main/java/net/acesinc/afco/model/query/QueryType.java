package net.acesinc.afco.model.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.acesinc.afco.model.data.quality.IngestQualityErrorReporting;
import net.acesinc.afco.model.distribution.DistributionLog;
import net.acesinc.afco.model.event.AADFEvent;
import net.acesinc.afco.model.event.InterceptEvent;
import net.acesinc.afco.model.file.AudioDataFile;
import net.acesinc.afco.model.file.DataFile;
import net.acesinc.afco.model.jsp.JspForwardingRule;
import net.acesinc.afco.model.location.BackgroundDf;
import net.acesinc.afco.model.location.GeoLocation;
import net.acesinc.afco.model.location.LobLocation;
import net.acesinc.afco.model.location.PlatformLocation;
import net.acesinc.afco.model.location.TargetLocation;
import net.acesinc.afco.model.metric.log.BasicLog;
import net.acesinc.afco.model.mission.PlatformMission;
import net.acesinc.afco.model.pod.PodMeta;
import net.acesinc.afco.model.purge.PurgeHistory;
import net.acesinc.afco.model.rtp.audio.stream.UnencryptedAudioStream;
import net.acesinc.afco.model.special.signal.SpecialSignal;
import net.acesinc.afco.model.special.signal.SpecialSignalFolder;
import net.acesinc.afco.model.subject.SignalSubject;
import net.acesinc.afco.model.subject.SubjectIDNO;

@Getter
@AllArgsConstructor
public enum QueryType {
    AUDIO("audio", AudioDataFile.class, "Audio File", "ingestDate", true, true),
    BACKGROUND_DF("background-df", BackgroundDf.class, "Background DF", "timestamp", true, false),
    COMINT_LOCATION("comint-location", TargetLocation.class, "COMINT Location", "timestamp", true, true),
    COMINT_SUBJECT("comint-subject", SubjectIDNO.class, "COMINT Assignment", "lastUpdated", true, true),
    DISTRIBUTION_LOG("distribution-log", DistributionLog.class, "Distribution Log", "timestamp", false, false),
    ELINT_INTERCEPT("elint-intercept", InterceptEvent.class, "ELINT Intercept", "ingestTime", true, false),
    ELINT_SIGNAL("elint-signal", SignalSubject.class, "ELINT", "lastUpdated", true, false),
    EVENT("event", AADFEvent.class, "Activity/Alert", "timestamp", true, false),
    FILE("file", DataFile.class, "Data File", "ingestDate", true, false),
    JSP_FORWARDING_RULE(
            "jsp-forwarding-rule", JspForwardingRule.class, "JSP Forwarding Rule", "createdDate", true, false),
    LOB("lob", LobLocation.class, "LOB", "timestamp", true, true),
    LOG_METRICS("log-metrics", BasicLog.class, "SDS Metrics", "currentTimestamp", true, false),
    PLATFORM("platform", PlatformLocation.class, "Unique Platform", "timestamp", false, false),
    PLATFORM_LOCATION("platform-location", PlatformLocation.class, "Platform Location", "timestamp", true, true),
    PLATFORM_MISSION("platform-mission", PlatformMission.class, "CICS Mission Information", "startTime", true, false),
    PRED("pred", DataFile.class, "Pre-D File", "ingestDate", true, true),
    PURGE_HISTORY("purge-history", PurgeHistory.class, "Purge History", "date", false, false),
    SIGNAL_LOCATION("signal-location", GeoLocation.class, "ELINT Location", "timestamp", true, false),
    SPECIAL_SIGNAL("special-signal", SpecialSignal.class, "IDNO-based Special Signal", "lastUpdated", false, false),
    SPECIAL_SIGNAL_FILE("special-signal-file", DataFile.class, "Special Signal File", "ingestDate", true, true),
    SPECIAL_SIGNAL_MISSION(
            "special-signal-folder", SpecialSignalFolder.class, "Special Signal Folder", null, false, false),
    TARGET_LOCATION("target-location", TargetLocation.class, "Target Location", "timestamp", true, false),
    TRACAL("tracal", DataFile.class, "TRACAL File", "ingestDate", false, false),
    UNENCRYPTED_AUDIO_STREAM(
            "unencrypted-audio-stream", UnencryptedAudioStream.class, "Streaming Audio", "stopTime", true, false),
    INGEST_QUALITY_ERROR_REPORTING(
            "ingest-quality-error-reporting",
            IngestQualityErrorReporting.class,
            "Ingest Quality Error Reporting",
            "stopTime",
            true,
            false),
    POD_META("pod-meta", PodMeta.class, "Pulse on Demand Metadata", "lastUpdated", true, false);

    private final String value;
    private final Class<?> className;
    private final String description;
    private final String timeWindowFieldName;
    private final boolean userFacing;
    private final boolean hasSac2Data;

    public static QueryType fromString(String queryTypeString) {
        for (QueryType queryType : QueryType.values()) {
            if (queryType.getValue().equalsIgnoreCase(queryTypeString)) {
                return queryType;
            }
        }

        throw new IllegalArgumentException(String.format("No QueryType value exists for string [%s]", queryTypeString));
    }
}
