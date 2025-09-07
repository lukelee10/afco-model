/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.rtp.audio;

import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 *
 * @author jeremytaylor
 */
public class PayloadTypeHandling {
    private int payloadType;
    private boolean bypassThrough;

    @NestedConfigurationProperty
    private AudioHandling in;

    @NestedConfigurationProperty
    private AudioHandling out;

    /**
     * @return the payloadType
     */
    public int getPayloadType() {
        return payloadType;
    }

    /**
     * @param payloadType the payloadType to set
     */
    public void setPayloadType(int payloadType) {
        this.payloadType = payloadType;
    }

    /**
     * @return the in
     */
    public AudioHandling getIn() {
        return in;
    }

    /**
     * @param in the in to set
     */
    public void setIn(AudioHandling in) {
        this.in = in;
    }

    /**
     * @return the out
     */
    public AudioHandling getOut() {
        return out;
    }

    /**
     * @param out the out to set
     */
    public void setOut(AudioHandling out) {
        this.out = out;
    }

    public boolean isBypassThrough() {
        return bypassThrough;
    }

    public void setBypassThrough(boolean bypassThrough) {
        this.bypassThrough = bypassThrough;
    }
}
