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
public class PulseWidthSummary {

    private String modType;
    private List<Double> pulseWidthMeanEstimates = new ArrayList<>();
    private Double pulseWidthMin;
    private Double pulseWidthMax;

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
     * @return the pulseWidthMin
     */
    public Double getPulseWidthMin() {
        return pulseWidthMin;
    }

    /**
     * @param pulseWidthMin the pulseWidthMin to set
     */
    public void setPulseWidthMin(Double pulseWidthMin) {
        this.pulseWidthMin = pulseWidthMin;
    }

    /**
     * @return the pulseWidthMax
     */
    public Double getPulseWidthMax() {
        return pulseWidthMax;
    }

    /**
     * @param pulseWidthMax the pulseWidthMax to set
     */
    public void setPulseWidthMax(Double pulseWidthMax) {
        this.pulseWidthMax = pulseWidthMax;
    }

    /**
     * @return the pulseWidthMeanEstimates
     */
    public List<Double> getPulseWidthMeanEstimates() {
        return pulseWidthMeanEstimates;
    }

    /**
     * @param pulseWidthMeanEstimates the pulseWidthMeanEstimates to set
     */
    public void setPulseWidthMeanEstimates(List<Double> pulseWidthMeanEstimates) {
        this.pulseWidthMeanEstimates = pulseWidthMeanEstimates;
    }
}
