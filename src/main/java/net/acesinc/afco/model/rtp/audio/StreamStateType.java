/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.rtp.audio;

/**
 *
 * @author jeremytaylor
 */
public enum StreamStateType {
    END("0"),
    START("1"),
    CONTINUATION("2"),
    UNKNOWN("3");

    private String rawStreamStateIndicatorValue;

    StreamStateType(String rawStreamStateIndicatorValue) {
        this.rawStreamStateIndicatorValue = rawStreamStateIndicatorValue;
    }

    /**
     * @return the rawStreamStateIndicatorValue
     */
    public String getRawStreamStateIndicatorValue() {
        return rawStreamStateIndicatorValue;
    }

    public static StreamStateType getStreamStateTypeFromRawValue(String raw) {
        switch (raw) {
            case "0":
                return StreamStateType.END;
            case "1":
                return StreamStateType.START;
            case "2":
                return StreamStateType.CONTINUATION;
            default:
                return StreamStateType.UNKNOWN;
        }
    }
}
