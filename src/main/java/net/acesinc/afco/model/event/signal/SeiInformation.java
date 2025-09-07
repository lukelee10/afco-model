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
public class SeiInformation {

    private String seiIdTemporaryId;
    private String seiIdPermanentId;
    private Integer umopNumberOfPulses;
    private Double umopSampleWindow;
    private String umopAlgorithmVersion;
    private String umopAlgorithmType;
    private Double umopRadioFrequencyDelta;
    private List<UmopCoefficient> umopCoefficients = new ArrayList<>();
    private List<UmopCoefficientStandardDeviation> umopCoefficientsStandardDeviation = new ArrayList<>();
    private Double umopSampleWindowStandardDeviation;

    /**
     * @return the seiIdTemporaryId
     */
    public String getSeiIdTemporaryId() {
        return seiIdTemporaryId;
    }

    /**
     * @param seiIdTemporaryId the seiIdTemporaryId to set
     */
    public void setSeiIdTemporaryId(String seiIdTemporaryId) {
        this.seiIdTemporaryId = seiIdTemporaryId;
    }

    /**
     * @return the seiIdPermanentId
     */
    public String getSeiIdPermanentId() {
        return seiIdPermanentId;
    }

    /**
     * @param seiIdPermanentId the seiIdPermanentId to set
     */
    public void setSeiIdPermanentId(String seiIdPermanentId) {
        this.seiIdPermanentId = seiIdPermanentId;
    }

    /**
     * @return the umopNumberOfPulses
     */
    public Integer getUmopNumberOfPulses() {
        return umopNumberOfPulses;
    }

    /**
     * @param umopNumberOfPulses the umopNumberOfPulses to set
     */
    public void setUmopNumberOfPulses(Integer umopNumberOfPulses) {
        this.umopNumberOfPulses = umopNumberOfPulses;
    }

    /**
     * @return the umopSampleWindow
     */
    public Double getUmopSampleWindow() {
        return umopSampleWindow;
    }

    /**
     * @param umopSampleWindow the umopSampleWindow to set
     */
    public void setUmopSampleWindow(Double umopSampleWindow) {
        this.umopSampleWindow = umopSampleWindow;
    }

    /**
     * @return the umopAlgorithmVersion
     */
    public String getUmopAlgorithmVersion() {
        return umopAlgorithmVersion;
    }

    /**
     * @param umopAlgorithmVersion the umopAlgorithmVersion to set
     */
    public void setUmopAlgorithmVersion(String umopAlgorithmVersion) {
        this.umopAlgorithmVersion = umopAlgorithmVersion;
    }

    /**
     * @return the umopAlgorithmType
     */
    public String getUmopAlgorithmType() {
        return umopAlgorithmType;
    }

    /**
     * @param umopAlgorithmType the umopAlgorithmType to set
     */
    public void setUmopAlgorithmType(String umopAlgorithmType) {
        this.umopAlgorithmType = umopAlgorithmType;
    }

    /**
     * @return the umopRadioFrequencyDelta
     */
    public Double getUmopRadioFrequencyDelta() {
        return umopRadioFrequencyDelta;
    }

    /**
     * @param umopRadioFrequencyDelta the umopRadioFrequencyDelta to set
     */
    public void setUmopRadioFrequencyDelta(Double umopRadioFrequencyDelta) {
        this.umopRadioFrequencyDelta = umopRadioFrequencyDelta;
    }

    /**
     * @return the umopCoefficients
     */
    public List<UmopCoefficient> getUmopCoefficients() {
        return umopCoefficients;
    }

    /**
     * @param umopCoefficients the umopCoefficients to set
     */
    public void setUmopCoefficients(List<UmopCoefficient> umopCoefficients) {
        this.umopCoefficients = umopCoefficients;
    }

    /**
     * @return the umopCoefficientsStandardDeviation
     */
    public List<UmopCoefficientStandardDeviation> getUmopCoefficientsStandardDeviation() {
        return umopCoefficientsStandardDeviation;
    }

    /**
     * @param umopCoefficientsStandardDeviation the umopCoefficientsStandardDeviation to set
     */
    public void setUmopCoefficientsStandardDeviation(
            List<UmopCoefficientStandardDeviation> umopCoefficientsStandardDeviation) {
        this.umopCoefficientsStandardDeviation = umopCoefficientsStandardDeviation;
    }

    /**
     * @return the umopSampleWindowStandardDeviation
     */
    public Double getUmopSampleWindowStandardDeviation() {
        return umopSampleWindowStandardDeviation;
    }

    /**
     * @param umopSampleWindowStandardDeviation the umopSampleWindowStandardDeviation to set
     */
    public void setUmopSampleWindowStandardDeviation(Double umopSampleWindowStandardDeviation) {
        this.umopSampleWindowStandardDeviation = umopSampleWindowStandardDeviation;
    }
}
