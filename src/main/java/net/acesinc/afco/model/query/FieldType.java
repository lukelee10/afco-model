package net.acesinc.afco.model.query;

public enum FieldType {
    ARRAY,
    BOOLEAN,
    DATE,
    DESTINATION,
    DISTRIBUTION_DATA_TYPE,
    DISTRIBUTION_STATUS,
    DOUBLE,
    ELNOT("ident", "confidence"),
    ENUM,
    GENDER("label", "score"),
    INTEGER,
    LANGUAGE("label", "score"),
    LIST,
    LOB_TYPE,
    LOCATION_TYPE,
    LONG,
    PLATFORMSOURCETYPE,
    PLATFORM_SOURCE_TYPE,
    POINT,
    SIGNAL_TYPE,
    SPEAKER("label", "score"),
    STRING,
    UNKNOWN;

    private String confidenceFieldName;
    private String labelFieldName;

    private FieldType() {}

    private FieldType(String labelFieldName, String confidenceFieldName) {
        this.labelFieldName = labelFieldName;
        this.confidenceFieldName = confidenceFieldName;
    }

    public static FieldType fromString(String fieldTypeString) {
        for (FieldType fieldType : FieldType.values()) {
            if (fieldType.toString().equalsIgnoreCase(fieldTypeString)) {
                return fieldType;
            }
        }

        throw new IllegalArgumentException(String.format("No FieldType value exists for string [%s]", fieldTypeString));
    }

    /**
     * @return the confidenceFieldName
     */
    public String getConfidenceFieldName() {
        return confidenceFieldName;
    }

    /**
     * @return the labelFieldName
     */
    public String getLabelFieldName() {
        return labelFieldName;
    }
}
