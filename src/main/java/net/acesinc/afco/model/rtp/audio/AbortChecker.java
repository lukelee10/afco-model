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
public interface AbortChecker {

    /**
     * a means of callback to an agent to help trigger an abort
     */
    public void abort();
}
