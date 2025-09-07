/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.file;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import lombok.Data;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.distribution.Distributable;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import net.acesinc.afco.model.special.signal.SpecialSignal;
import net.acesinc.afco.model.view.Views;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

/**
 * Represents data in the dataFile collection for ingested files
 * Added @NonNull and @Nullable annotations to help mark this bean up for future improvement.
 * AE-4533 was created to fix the UI to not require nulls for certain fields.
 */
@Document(collection = "dataFile")
@Data
public class DataFile extends SpecialSignal implements Queryable, Distributable {
    @JsonIgnore
    protected static final String AUTOCOMPLETE_DATA_TYPE = "file";

    @JsonIgnore
    protected static List<QueryField> SPECIAL_CASE_QUERYABLE_FIELDS = Arrays.asList(
            new QueryField("absolutePath", "Absolute Path", FieldType.STRING, "absolutePath", null, false, null),
            new QueryField("analyst", "Analyst", FieldType.STRING, "analyst", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("dataType", "Data Type", FieldType.ENUM, "dataType", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("fileName", "File Name", FieldType.STRING, "fileName", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("mappingId", "Mapping Id", FieldType.STRING, "mappingId", null, false, null),
            new QueryField("mimeType", "Mime Type", FieldType.ENUM, "mimeType", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("pddg", "PDDG", FieldType.ENUM, "pddg", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("sigad", "Sigad", FieldType.ENUM, "sigad", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("site", "Site", FieldType.ENUM, "site", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("source", "Source", FieldType.ENUM, "source", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("sensor", "Sensor", FieldType.STRING, "sensor", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("sensorType", "Sensor Type", FieldType.STRING, "sensorType", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("user", "User", FieldType.STRING, "user", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("contentType", "Content Type", FieldType.STRING, "ContentType", AUTOCOMPLETE_DATA_TYPE));

    @JsonIgnore
    protected static List<String> NON_QUERYABLE_FIELDS = Arrays.asList(
            "AUTOCOMPLETE_DATA_TYPE",
            "NON_QUERYABLE_FIELDS",
            "QUERYABLE_SUBCLASSES",
            "SPECIAL_CASE_QUERYABLE_FIELDS",
            "audioAnalysis",
            "classification",
            "distributionLog",
            "fileNamePrefix",
            "status",
            "uuid");

    /**
     * See comment in {@link net.acesinc.afco.model.Queryable#getQueryableSubclasses()} for how
     * and why this is used. If a new subclass to DataFile is created, this list must be updated so the
     * query results will return all appropriate fields in the new subclass.
     */
    @JsonIgnore
    private static final List<Class<? extends Queryable>> QUERYABLE_SUBCLASSES = Arrays.asList(
            AudioDataFile.class, ElintDataFile.class, MultipleMissionDataFile.class, SpectrogramDataFile.class);

    @JsonView(Views.DashboardView.class)
    private String absolutePath;

    @JsonView(Views.DashboardView.class)
    private String fileName;
    /**
     * The fileSize attribute for NiFi is a string and CANNOT be modified. This
     * means that it cannot be made a number without giving a different name for
     * the property. Thus, fileSize to size...
     */
    @JsonView(Views.DashboardView.class)
    private long size;

    @JsonView(Views.DashboardView.class)
    private Date ingestDate;

    @JsonView(Views.DashboardView.class)
    private String dataType;

    @JsonView(Views.FullView.class)
    private String mimeType;

    @JsonView(Views.DashboardView.class)
    private String sensor;

    @JsonView(Views.DashboardView.class)
    private String sensorType;

    @JsonView(Views.DashboardView.class)
    private String site;

    @JsonView(Views.DashboardView.class)
    private String source;

    @JsonView(Views.FullView.class)
    private String user;

    @JsonView(Views.FullView.class)
    private String uuid;

    @JsonView(Views.FullView.class)
    private String contentType;

    /**
     * This status field is used for binary files derived from RTP encrypted
     * audio streams, which may not be encrypted and may not be audio, but they
     * are binary data and this status field signifies that the cut has
     * been made.
     */
    @JsonView(Views.DashboardView.class)
    private StatusType status;

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
        return QUERYABLE_SUBCLASSES;
    }

    /**
     * @return the absolutePath
     */
    @Nullable
    public String getAbsolutePath() {
        return absolutePath;
    }

    /**
     * @return the distributionReferenceUrlPath that gets built using the mappingId or null
     * if dataType is either null or doesn't have a supported type for distributing to repositories
     * that use this field, such as BROADSKY
     */
    @Override
    @Nullable
    public String getDistributionReferenceUrlPath() {
        // Return null if dataType is blank or null
        if (StringUtils.isBlank(dataType)) {
            return null;
        }

        // Otherwise return an appropriate referenceUrlPath for supported dataTypes
        switch (dataType) {
            case "SPECIAL_SIGNAL":
                return String.format("special-signal/%s/details", getMappingId());
            case "DATA":
                return String.format("special-signal/%s/details", getMappingId());
            case "BINARY-DAT":
            case "PBIT":
            case "PRED":
                return String.format("dashboard/idno/%s", getMappingId());
            case "PDW":
            case "PDW-CONVOLVED":
                return String.format("dashboard/signal/%s", getMappingId());

                // Return null if dataType isn't supported
            default:
                return null;
        }
    }
}
