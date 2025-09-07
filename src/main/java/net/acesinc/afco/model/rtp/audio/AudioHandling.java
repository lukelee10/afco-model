/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.rtp.audio;

/**
 * This model matches up with how yaml config has to look for decoding or re-encoding an audio stream.
 * This info later gets converted into a SupportedAudioFormat instance via an adapter.
 *
 * @author jeremytaylor
 */
public class AudioHandling {
    private String encoding;
    private float sampleRate;
    private int sampleSizeInBits;
    private int channels;
    private int frameSize;
    private float frameRate;
    private boolean bigEndian;

    /**
     * @return the encoding
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * @param encoding the encoding to set
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * @return the sampleRate
     */
    public float getSampleRate() {
        return sampleRate;
    }

    /**
     * @param sampleRate the sampleRate to set
     */
    public void setSampleRate(float sampleRate) {
        this.sampleRate = sampleRate;
    }

    /**
     * @return the sampleSizeInBits
     */
    public int getSampleSizeInBits() {
        return sampleSizeInBits;
    }

    /**
     * @param sampleSizeInBits the sampleSizeInBits to set
     */
    public void setSampleSizeInBits(int sampleSizeInBits) {
        this.sampleSizeInBits = sampleSizeInBits;
    }

    /**
     * @return the channels
     */
    public int getChannels() {
        return channels;
    }

    /**
     * @param channels the channels to set
     */
    public void setChannels(int channels) {
        this.channels = channels;
    }

    /**
     * @return the frameSize
     */
    public int getFrameSize() {
        return frameSize;
    }

    /**
     * @param frameSize the frameSize to set
     */
    public void setFrameSize(int frameSize) {
        this.frameSize = frameSize;
    }

    /**
     * @return the frameRate
     */
    public float getFrameRate() {
        return frameRate;
    }

    /**
     * @param frameRate the frameRate to set
     */
    public void setFrameRate(float frameRate) {
        this.frameRate = frameRate;
    }

    /**
     * @return the bigEndian
     */
    public boolean isBigEndian() {
        return bigEndian;
    }

    /**
     * @param bigEndian the bigEndian to set
     */
    public void setBigEndian(boolean bigEndian) {
        this.bigEndian = bigEndian;
    }
}
