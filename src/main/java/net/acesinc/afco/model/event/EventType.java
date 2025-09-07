/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.event;

/**
 *
 * @author andrewserff
 */
public enum EventType {
    ALERT,
    ACTIVITY,
    DATA_FORWARD,
    FOI,
    INTERCEPT,
    UNKNOWN;

    public static EventType getTypeFromString(String type) {
        switch (type) {
            case "ale":
                return EventType.ALERT;
            case "act":
                return EventType.ACTIVITY;
            case "dfor":
                return EventType.DATA_FORWARD;
            case "foi":
            case "edw":
                return EventType.FOI;
            case "unk":
                return EventType.UNKNOWN;
            default:
                return EventType.valueOf(type);
        }
    }
}
