package net.acesinc.afco.model.distribution.json.broadsky;

import com.fasterxml.jackson.annotation.*;
import java.io.File;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({
    "camKey",
    "description",
    "entityParentId",
    "fileType",
    "filename",
    "frequency",
    "dataFormat",
    "sampleRate",
    "whoCanAccess",
    "file"
})
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileUploadMetadata {
    private String camKey;
    private String description;
    private String entityParentId;
    private FileType fileType;
    private String filename;
    private Double frequency;
    private DataFormat dataFormat;
    private Double sampleRate;
    private String whoCanAccess;
    private File file;

    public enum FileType {
        FILE_META_DATA,
        FILE_SIGNALS,
        FILE_MEDIA,
        FILE_HTML_LINK,
        FILE_CKEDITOR,
        FILE_SPF
    }

    public enum DataFormat {
        _32f,
        _64f,
        ADPCM_2BIT,
        ADPCM_3BIT,
        ADPCM_4BIT,
        ADPCM_5BIT,
        BIT_8A,
        BIT_8A_REVERSED,
        BIT_8U,
        BIT_8U_REVERSED,
        BIT_8O,
        BIT_8T,
        BIT_16O,
        BIT_16O_SWAPPED,
        BIT_16T,
        BIT_16T_SWAPPED,
        BIT_32T,
        BIT_32T_SWAPPED,
        BIT_FILE,
        CVSD_1V_UNFILTERED,
        CVSD_1V_FILTERED,
        D124,
        M2EXTRA,
        PCAP,
        SFF,
        SYMBOL_FILE,
        TAR,
        UNKNOWN;

        @JsonValue // Used for serialization
        public String getString() {
            return name().startsWith("_") ? name().substring(1) : name();
        }

        @JsonCreator // Used for deserialization
        public static DataFormat fromString(String text) {
            for (DataFormat df : DataFormat.values()) {
                if (df.getString().equalsIgnoreCase(text)) {
                    return df;
                }
            }
            throw new IllegalArgumentException("No enum constant found for: " + text);
        }
    }
}
