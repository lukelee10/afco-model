/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.subject;

/**
 *
 * @author jeremytaylor
 */
public enum FormattedDataType {
    USER_DEFINED("USER_DEFINED"),
    PRED("PreD"),
    AUDIO("Audio"),
    BIT("Bit"),
    PSD("PSD"),
    SIGNAL("Signal"),
    UNKNOWN("UNKNOWN");

    private String literalValue;

    FormattedDataType(String literalValue) {
        this.literalValue = literalValue;
    }

    public String getValue() {
        return this.literalValue;
    }

    public static FormattedDataType getFormattedTypeByValue(String value) {
        switch (value) {
            case "USER_DEFINED":
                return USER_DEFINED;
            case "PreD":
                return PRED;
            case "Audio":
                return AUDIO;
            case "Bit":
                return BIT;
            case "PSD":
                return PSD;
            default:
                return UNKNOWN;
        }
    }

    @Override
    public String toString() {
        return this.literalValue;
    }
}
