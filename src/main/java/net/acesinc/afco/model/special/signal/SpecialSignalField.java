package net.acesinc.afco.model.special.signal;

import java.util.Arrays;
import net.acesinc.afco.model.NamedField;
import org.apache.commons.lang3.StringUtils;

/**
 * Represents a field/property of the SpecialSignal class.
 */
public enum SpecialSignalField implements NamedField {
    ANALYST("analyst"),
    ASSOCIATED_MAPPING_ID("associatedMappingId"),
    BW("bw"),
    CASE_NOTS("casenots"),
    CATEGORIES("categories"),
    CLASSIFICATION("classification"),
    DATA_FORMAT("dataFormat"),
    FOLDER_NAME_ID("folderNameId"),
    FREQUENCY("frequency"),
    HIGH_PRIORITY("highPriority"),
    ID_NO("idNo"),
    INGEST_SITE("ingestSite"),
    KEYSPEED("keyspeed"),
    KEYWORD("keyword"),
    LOCATION("location"),
    MAPPING_ID("mappingId"),
    MISSION_AOR("missionAor"),
    MISSION_ID("missionId"),
    MISSION_NAME("missionName"),
    MODULATION("modulation"),
    MOD_TYPE("modType"),
    OPERATOR_ID("operatorId"),
    OP_NOTE("opNote"),
    OP_SID("opSid"),
    PARENT_MAPPING_ID("parentMappingId"),
    PDDG("pddg"),
    PRIORITY("priority"),
    SEMI_MAJOR("semiMajor"),
    SEMI_MINOR("semiMinor"),
    SIGAD("sigad"),
    SIGNAL_TYPE("signalType"),
    SIG_ID("sigId"),
    SPECIAL_FIELD_1("specialField1"),
    SPECIAL_FIELD_2("specialField2"),
    START_TIME("startTime"),
    STOP_TIME("stopTime"),
    STREAM_SAMPLE_RATE("streamSampleRate"),
    TASK_ID("taskId"),
    TILT("tilt");

    private final String fieldName;

    SpecialSignalField(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String getFieldName() {
        return fieldName;
    }

    public static SpecialSignalField fromValue(String v) {
        if (StringUtils.isBlank(v)) {
            return null;
        }
        return Arrays.stream(SpecialSignalField.values())
                .filter(f -> StringUtils.equalsAny(v, f.name(), f.getFieldName()))
                .findFirst()
                .orElse(null);
    }
}
