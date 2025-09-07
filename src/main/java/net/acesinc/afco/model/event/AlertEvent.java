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
public class AlertEvent extends AADFEvent {

    public AlertEvent() {
        setType(EventType.ALERT);
    }
}
