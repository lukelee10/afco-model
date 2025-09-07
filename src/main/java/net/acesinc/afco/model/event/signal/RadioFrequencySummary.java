/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.event.signal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeremytaylor
 */
public class RadioFrequencySummary {

    private List<Double> freqs = new ArrayList<>();
    private Double rfMin;
    private Double rfMax;
    private String modType;

    /**
     * @return the rfMin
     */
    public Double getRfMin() {
        return rfMin;
    }

    /**
     * @param rfMin the rfMin to set
     */
    public void setRfMin(Double rfMin) {
        this.rfMin = rfMin;
    }

    /**
     * @return the rfMax
     */
    public Double getRfMax() {
        return rfMax;
    }

    /**
     * @param rfMax the rfMax to set
     */
    public void setRfMax(Double rfMax) {
        this.rfMax = rfMax;
    }

    /**
     * @return the modType
     */
    public String getModType() {
        return modType;
    }

    /**
     * @param modType the modType to set
     */
    public void setModType(String modType) {
        this.modType = modType;
    }

    /**
     * @return the freqs
     */
    public List<Double> getFreqs() {
        return freqs;
    }

    /**
     * @param freqs the freqs to set
     */
    public void setFreqs(List<Double> freqs) {
        this.freqs = freqs;
    }
}
