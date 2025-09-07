package net.acesinc.afco.model.distribution;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Destination {
    BROADSKY("BROADSKY"),
    IM_S("IM&S"),
    STARGATE("STARGATE"),
    TOXICSMOKE("TOXICSMOKE"),
    SMD("SMD"),
    CEGS("CEGS"),
    SPECTROGRAM("SPECTROGRAM"),
    VAQUERO("VAQUERO"),
    JSP("JSP");

    private String displayName;

    private Destination(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }
}
