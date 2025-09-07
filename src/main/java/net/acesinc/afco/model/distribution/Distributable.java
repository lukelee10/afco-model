package net.acesinc.afco.model.distribution;

import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.classification.Classification;
import net.acesinc.afco.model.event.Comment;
import org.springframework.data.geo.Point;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public interface Distributable {

    @NonNull
    String getAnalyst();

    @NonNull
    List<String> getCasenots();

    @NonNull
    Classification getClassification();

    @Nullable
    String getDataFormat();

    @Nullable
    String getDistributionReferenceUrlPath();

    @NonNull
    String getFileNamePrefix();

    void setFileNamePrefix(String fileNamePrefix);

    @NonNull
    Double getFrequency();

    @NonNull
    String getId();

    @Nullable
    Double getKeyspeed();

    @Nullable
    Point getLocation();

    @NonNull
    String getOperatorId();

    @NonNull
    String getOpNote();

    @NonNull
    List<Comment> getOpNotes();

    @NonNull
    String getMappingId();

    @NonNull
    String getModType();

    @NonNull
    String getModulation();

    @NonNull
    String getMissionAor();

    @Nullable
    String getPddg();

    @Nullable
    String getSemiMajor();

    @Nullable
    String getSemiMinor();

    @Nullable
    String getSigad();

    @NonNull
    String getSigId();

    @Nullable
    Date getStartTime();

    @Nullable
    Date getStopTime();

    @NonNull
    Double getStreamSampleRate();

    @Nullable
    String getTilt();
}
