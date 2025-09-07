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
public class Characterization {

    private String dataType;
    private RadioFrequencySummary radioFreqSummary;
    private Double groupRepititionIntervalMeanEstimate;
    private Integer numPriPositions;
    private Integer numPriElements;
    private PulseRepititionIntervalSummary pulseRepIntervalSummary;
    private PulseWidthSummary pulseWidthSummary;
    private Double signalToNoiseRatio;
    private Double crystalClockValue;
    private List<InterferometerData> interferometerDatas = new ArrayList<>();
    private String polarization;
    private String scanType;
    private Double scanRate;
    private Double illuminationRate;
    private SeiInformation seiInfo;

    /**
     * @return the dataType
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * @return the radioFreqSummary
     */
    public RadioFrequencySummary getRadioFreqSummary() {
        return radioFreqSummary;
    }

    /**
     * @param radioFreqSummary the radioFreqSummary to set
     */
    public void setRadioFreqSummary(RadioFrequencySummary radioFreqSummary) {
        this.radioFreqSummary = radioFreqSummary;
    }

    /**
     * @return the groupRepititionIntervalMeanEstimate
     */
    public Double getGroupRepititionIntervalMeanEstimate() {
        return groupRepititionIntervalMeanEstimate;
    }

    /**
     * @param groupRepititionIntervalMeanEstimate the
     * groupRepititionIntervalMeanEstimate to set
     */
    public void setGroupRepititionIntervalMeanEstimate(Double groupRepititionIntervalMeanEstimate) {
        this.groupRepititionIntervalMeanEstimate = groupRepititionIntervalMeanEstimate;
    }

    /**
     * @return the numPriPositions
     */
    public Integer getNumPriPositions() {
        return numPriPositions;
    }

    /**
     * @param numPriPositions the numPriPositions to set
     */
    public void setNumPriPositions(Integer numPriPositions) {
        this.numPriPositions = numPriPositions;
    }

    /**
     * @return the numPriElements
     */
    public Integer getNumPriElements() {
        return numPriElements;
    }

    /**
     * @param numPriElements the numPriElements to set
     */
    public void setNumPriElements(Integer numPriElements) {
        this.numPriElements = numPriElements;
    }

    /**
     * @return the pulseWidthSummary
     */
    public PulseWidthSummary getPulseWidthSummary() {
        return pulseWidthSummary;
    }

    /**
     * @param pulseWidthSummary the pulseWidthSummary to set
     */
    public void setPulseWidthSummary(PulseWidthSummary pulseWidthSummary) {
        this.pulseWidthSummary = pulseWidthSummary;
    }

    /**
     * @return the signalToNoiseRatio
     */
    public Double getSignalToNoiseRatio() {
        return signalToNoiseRatio;
    }

    /**
     * @param signalToNoiseRatio the signalToNoiseRatio to set
     */
    public void setSignalToNoiseRatio(Double signalToNoiseRatio) {
        this.signalToNoiseRatio = signalToNoiseRatio;
    }

    /**
     * @return the crystalClockValue
     */
    public Double getCrystalClockValue() {
        return crystalClockValue;
    }

    /**
     * @param crystalClockValue the crystalClockValue to set
     */
    public void setCrystalClockValue(Double crystalClockValue) {
        this.crystalClockValue = crystalClockValue;
    }

    /**
     * @return the interferometerDatas
     */
    public List<InterferometerData> getInterferometerDatas() {
        return interferometerDatas;
    }

    /**
     * @param interferometerDatas the interferometerDatas to set
     */
    public void setInterferometerDatas(List<InterferometerData> interferometerDatas) {
        this.interferometerDatas = interferometerDatas;
    }

    /**
     * @return the polarization
     */
    public String getPolarization() {
        return polarization;
    }

    /**
     * @param polarization the polarization to set
     */
    public void setPolarization(String polarization) {
        this.polarization = polarization;
    }

    /**
     * @return the scanType
     */
    public String getScanType() {
        return scanType;
    }

    /**
     * @param scanType the scanType to set
     */
    public void setScanType(String scanType) {
        this.scanType = scanType;
    }

    /**
     * @return the scanRate
     */
    public Double getScanRate() {
        return scanRate;
    }

    /**
     * @param scanRate the scanRate to set
     */
    public void setScanRate(Double scanRate) {
        this.scanRate = scanRate;
    }

    /**
     * @return the illuminationRate
     */
    public Double getIlluminationRate() {
        return illuminationRate;
    }

    /**
     * @param illuminationRate the illuminationRate to set
     */
    public void setIlluminationRate(Double illuminationRate) {
        this.illuminationRate = illuminationRate;
    }

    /**
     * @return the seiInfo
     */
    public SeiInformation getSeiInfo() {
        return seiInfo;
    }

    /**
     * @param seiInfo the seiInfo to set
     */
    public void setSeiInfo(SeiInformation seiInfo) {
        this.seiInfo = seiInfo;
    }

    /**
     * @return the pulseRepIntervalSummary
     */
    public PulseRepititionIntervalSummary getPulseRepIntervalSummary() {
        return pulseRepIntervalSummary;
    }

    /**
     * @param pulseRepIntervalSummary the pulseRepIntervalSummary to set
     */
    public void setPulseRepIntervalSummary(PulseRepititionIntervalSummary pulseRepIntervalSummary) {
        this.pulseRepIntervalSummary = pulseRepIntervalSummary;
    }
}
