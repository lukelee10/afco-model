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
public class PulseRepititionIntervalSummary {

    /**
     * another modType altogether from the radio freq summary
     */
    private String pulseRepititionIntervalModType;
    /**
     * the mean --> there can be many of these
     */
    private List<Double> pulseRepititionIntervalMeanEstimates = new ArrayList<>();
    /**
     * the min --> there can be many of these due to being able to have many
     * ranges
     */
    private Double pulseRepetitionIntervalMin;
    /**
     * the max --> there can be many of these due to being able to have many
     * ranges
     */
    private Double pulseRepetitionIntervalMax;

    /**
     * @return the pulseRepititionIntervalModType
     */
    public String getPulseRepititionIntervalModType() {
        return pulseRepititionIntervalModType;
    }

    /**
     * @param pulseRepititionIntervalModType the pulseRepititionIntervalModType
     * to set
     */
    public void setPulseRepititionIntervalModType(String pulseRepititionIntervalModType) {
        this.pulseRepititionIntervalModType = pulseRepititionIntervalModType;
    }

    /**
     * @return the pulseRepititionIntervalMeanEstimates
     */
    public List<Double> getPulseRepititionIntervalMeanEstimates() {
        return pulseRepititionIntervalMeanEstimates;
    }

    /**
     * @param pulseRepititionIntervalMeanEstimates the
     * pulseRepititionIntervalMeanEstimates to set
     */
    public void setPulseRepititionIntervalMeanEstimates(List<Double> pulseRepititionIntervalMeanEstimates) {
        this.pulseRepititionIntervalMeanEstimates = pulseRepititionIntervalMeanEstimates;
    }

    /**
     * @return the pulseRepetitionIntervalMin
     */
    public Double getPulseRepetitionIntervalMin() {
        return pulseRepetitionIntervalMin;
    }

    /**
     * @param pulseRepetitionIntervalMin the pulseRepetitionIntervalMin to set
     */
    public void setPulseRepetitionIntervalMin(Double pulseRepetitionIntervalMin) {
        this.pulseRepetitionIntervalMin = pulseRepetitionIntervalMin;
    }

    /**
     * @return the pulseRepetitionIntervalMax
     */
    public Double getPulseRepetitionIntervalMax() {
        return pulseRepetitionIntervalMax;
    }

    /**
     * @param pulseRepetitionIntervalMax the pulseRepetitionIntervalMax to set
     */
    public void setPulseRepetitionIntervalMax(Double pulseRepetitionIntervalMax) {
        this.pulseRepetitionIntervalMax = pulseRepetitionIntervalMax;
    }
}
