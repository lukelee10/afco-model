package net.acesinc.afco.model.spectrogram;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpectrogramRequest {

    private String parentDataFileId = "";
    private String parentMappingId = "";

    @JsonProperty(required = false)
    private SpectrogramMetadata data;

    public SpectrogramMetadata getData() {
        return data;
    }

    public void setData(SpectrogramMetadata data) {
        this.data = data;
    }

    public String getParentDataFileId() {
        return parentDataFileId;
    }

    public void setParentDataFileId(String parentDataFileId) {
        this.parentDataFileId = parentDataFileId;
    }

    public String getParentMappingId() {
        return parentMappingId;
    }

    public void setParentMappingId(String parentMappingId) {
        this.parentMappingId = parentMappingId;
    }
}
