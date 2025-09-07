/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.event.signal;

/**
 *
 * @author jeremytaylor
 */
public class InterferometerData {

    private Integer differenceNumber;
    private Double phaseDifference;
    private Double amplitudeDifference;

    /**
     * @return the differenceNumber
     */
    public Integer getDifferenceNumber() {
        return differenceNumber;
    }

    /**
     * @param differenceNumber the differenceNumber to set
     */
    public void setDifferenceNumber(Integer differenceNumber) {
        this.differenceNumber = differenceNumber;
    }

    /**
     * @return the phaseDifference
     */
    public Double getPhaseDifference() {
        return phaseDifference;
    }

    /**
     * @param phaseDifference the phaseDifference to set
     */
    public void setPhaseDifference(Double phaseDifference) {
        this.phaseDifference = phaseDifference;
    }

    /**
     * @return the amplitudeDifference
     */
    public Double getAmplitudeDifference() {
        return amplitudeDifference;
    }

    /**
     * @param amplitudeDifference the amplitudeDifference to set
     */
    public void setAmplitudeDifference(Double amplitudeDifference) {
        this.amplitudeDifference = amplitudeDifference;
    }
}
