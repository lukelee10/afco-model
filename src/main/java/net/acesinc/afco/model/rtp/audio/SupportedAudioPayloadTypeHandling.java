/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.rtp.audio;

import javax.sound.sampled.AudioFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This facilitates audio configuration on audio agents.
 *
 * @author jeremytaylor
 */
public class SupportedAudioPayloadTypeHandling {

    private static final Logger log = LoggerFactory.getLogger(SupportedAudioPayloadTypeHandling.class);
    /**
     * a payload type that relates to a particular audio encoding format
     */
    private int payloadType;
    /**
     * bypassThrough tells the audio agent to not decode and re-encode the audio stream when relaying
     */
    private boolean bypassThrough;
    /**
     * incoming supported audio format that tells us how to decode the raw audio
     */
    private SupportedAudioFormat inSuppAudioFormat;
    /**
     * outgoing supported audio format that tells us how to re-encode the audio
     */
    private SupportedAudioFormat outSuppAudioFormat;

    public AudioFormat toInAudioFormat() {
        // lowering to trace -- this is going to be hard to be helpful from a log aggregated place and this is redundant
        // to revised statements within the agents
        log.trace(String.format("creating incoming AudioFormat from payload type [%d].", this.payloadType));
        return this.getInSuppAudioFormat().toAudioFormat();
    }

    public AudioFormat toOutAudioFormat() {
        // lowering to trace -- this is going to be hard to be helpful from a log aggregated place and this is redundant
        // to revised statements within the agents
        log.trace(String.format("creating outgoing AudioFormat from payload type [%d].", this.payloadType));
        return this.getOutSuppAudioFormat().toAudioFormat();
    }

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
     * @return the inSuppAudioFormat
     */
    public SupportedAudioFormat getInSuppAudioFormat() {
        return inSuppAudioFormat;
    }

    /**
     * @param inSuppAudioFormat the inSuppAudioFormat to set
     */
    public void setInSuppAudioFormat(SupportedAudioFormat inSuppAudioFormat) {
        this.inSuppAudioFormat = inSuppAudioFormat;
    }

    /**
     * @return the outSuppAudioFormat
     */
    public SupportedAudioFormat getOutSuppAudioFormat() {
        return outSuppAudioFormat;
    }

    /**
     * @param outSuppAudioFormat the outSuppAudioFormat to set
     */
    public void setOutSuppAudioFormat(SupportedAudioFormat outSuppAudioFormat) {
        this.outSuppAudioFormat = outSuppAudioFormat;
    }

    public boolean isBypassThrough() {
        return bypassThrough;
    }

    public void setBypassThrough(boolean bypassThrough) {
        this.bypassThrough = bypassThrough;
    }
}
