package net.acesinc.afco.model.data.quality;

public enum InspectionType {
    NIFI("NiFi"),
    NMPG_AUDIO_AGENT("NMPG Audio Agent"),
    NMPG_DATA_AGENT("NMPG Data Agent"),
    END_USER("End User"),
    OTHER("Other");

    private String displayableValue;

    InspectionType(String displayableValue) {
        this.displayableValue = displayableValue;
    }

    public String getValue() {
        return this.displayableValue;
    }

    @Override
    public String toString() {
        return this.displayableValue;
    }
}
