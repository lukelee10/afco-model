package net.acesinc.afco.model.rtp.audio;

import java.util.ArrayList;

/**
 * Enumeration of the signal types defined in the CIDS ICD G16559.00.28 Rev. D.  This is to be used with the
 * RTP profile 19510, and any additional future profiles.
 */
public enum SignalTypes {
    SIGNAL_TYPE_UNKNOWN(0),
    TCS_AUDIO(2),
    TCS_SPECIAL_SIGNALS(3),
    TYPE_MINI_C_AUDIO(4),
    TYPE_MINI_C_SPECIAL_SIGNALS(5),
    TAS_AUDIO(8),
    TAS_SPECIAL_SIGNALS(9),
    TYPE_C_AUDIO(16),
    TYPE_C_SPECIAL_SIGNALS(17),
    TYPE_B_AUDIO(32),
    TYPE_B_SPECIAL_SIGNALS(33),
    TYPE_E_AUDIO(64),
    TYPE_E_SPECIAL_SIGNALS(65);

    private Short rawSignalTypeValue = 0;

    SignalTypes(int rawSignalTypeValue) {
        this.rawSignalTypeValue = (short) rawSignalTypeValue;
    }

    /**
     * signalTypeValue is defined in the CIDS ICD G16559.00.28 Rev. D.  The signal type value is a [1 byte unsigned integer]
     * @return - byte - The byte value of the signal type
     */
    public Short signalTypeValue() {
        return this.rawSignalTypeValue;
    }

    /**
     * Returns the enum SignalType based off the raw value extracted from the RTP extended header. This can be used
     * to map raw byte values to their corresponding signal type name.
     * @param rawSignal - The byte value extracted from the RTP extended header
     * @return - SignalType - The enum mapped to the byte value passed in.  If the byte value is not mapped to any
     * known SignalType, then an enum of SignalType.SIGNAL_TYPE_UNKNOWN is returned.
     */
    public static SignalTypes getSignalTypeFromRawValue(short rawSignal) {
        switch (rawSignal) {
            case 2:
                return TCS_AUDIO;
            case 3:
                return TCS_SPECIAL_SIGNALS;
            case 4:
                return TYPE_MINI_C_AUDIO;
            case 5:
                return TYPE_MINI_C_SPECIAL_SIGNALS;
            case 8:
                return TAS_AUDIO;
            case 9:
                return TAS_SPECIAL_SIGNALS;
            case 16:
                return TYPE_C_AUDIO;
            case 17:
                return TYPE_C_SPECIAL_SIGNALS;
            case 32:
                return TYPE_B_AUDIO;
            case 33:
                return TYPE_B_SPECIAL_SIGNALS;
            case 64:
                return TYPE_E_AUDIO;
            case 65:
                return TYPE_E_SPECIAL_SIGNALS;
            default:
                return SIGNAL_TYPE_UNKNOWN;
        }
    }

    /**
     * This can be used to help with streaming and generating values without having to add any
     * additional logic.  Adding to the SignalType enum list above will include the enums in the
     * returned array below, when belonging to the Data SignalTypes.
     * @return - SignalTypes[] - Returns the Data SignalTypes as an array.
     */
    public static SignalTypes[] getDataSignalTypes() {
        ArrayList<SignalTypes> dataList = new ArrayList<>();
        for (SignalTypes signal : SignalTypes.values()) {
            // Data SignalType raw values are odd, so we're checking for odds to populate the array
            // We're also going to exclude the SIGNAL_TYPE_UNKNOWN enum.
            if (signal != SIGNAL_TYPE_UNKNOWN && signal.rawSignalTypeValue % 2 != 0) {
                dataList.add(signal);
            }
        }
        return dataList.toArray(new SignalTypes[0]);
    }

    /**
     * This can be used to help with streaming and generating values without having to add any
     * additional logic.  Adding to the SignalType enum list above will include the enums in the
     * returned array below, when belonging to the Audio SignalTypes.
     * @return - SignalTypes[] - Returns the Audio SignalTypes as an array.
     */
    public static SignalTypes[] getAudioSignalTypes() {
        ArrayList<SignalTypes> audioList = new ArrayList<>();
        for (SignalTypes signal : SignalTypes.values()) {
            // Audio SignalType raw values are even, so we're checking for evens to populate the array
            // We're also going to exclude the SIGNAL_TYPE_UNKNOWN enum.
            if (signal != SIGNAL_TYPE_UNKNOWN && signal.rawSignalTypeValue % 2 == 0) {
                audioList.add(signal);
            }
        }
        return audioList.toArray(new SignalTypes[0]);
    }
}
