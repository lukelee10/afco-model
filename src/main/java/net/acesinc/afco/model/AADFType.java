/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model;

/**
 *
 * @author andrewserff
 */
public enum AADFType {
    ALERT,
    ACTIVITY,
    DATA_FORWARD,
    UNKNOWN;

    public static AADFType getTypeFromString(String type) {
        switch (type) {
            case "ale":
                return AADFType.ALERT;
            case "act":
                return AADFType.ACTIVITY;
            case "dfor":
                return AADFType.DATA_FORWARD;
            case "unk":
                return AADFType.UNKNOWN;
            default:
                return AADFType.valueOf(type);
        }
    }
}
