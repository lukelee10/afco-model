/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model;

import java.io.Serializable;
import java.util.Date;
import net.acesinc.afco.model.classification.Classification;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author jebpair
 */
@Document(collection = "aadf_location")
public class AADFLocation implements Serializable {

    @Id
    private String id;

    @Field("SUL")
    private String sul;
    /**
     * mission num is not in the official data model,
     * but is likely still needed separately for front-end related functionality.
     * Officially, the sul encloses and replaces this for the location data model.
     */
    private String msnNo;
    /**
     * id num is not in the official data model,
     * but is likely still needed separately for front-end related functionality.
     * Officially, the sul encloses and replaces this for the location data model.
     */
    private String idNo;

    private Integer subFileNo;
    private Date time;

    @Field("platform-alt")
    private Integer platformAltitude;

    @Field("platform-point")
    private org.springframework.data.geo.Point platformPoint;

    @Field("platform-hdg")
    private Double platformHeading;

    @Field("target-point")
    private org.springframework.data.geo.Point targetPoint;

    @Field("target-orient")
    private Double targetOrient;

    @Field("target-smaj")
    private Double targetSemiMajorAxis;

    @Field("target-smin")
    private Double targetSemiMinorAxis;

    private Classification classification;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the sul
     */
    public String getSul() {
        return sul;
    }

    /**
     * @param sul the sul to set
     */
    public void setSul(String sul) {
        this.sul = sul;
    }

    /**
     * @return the msnNo
     */
    public String getMsnNo() {
        return msnNo;
    }

    /**
     * @param msnNo the msnNo to set
     */
    public void setMsnNo(String msnNo) {
        this.msnNo = msnNo;
    }

    /**
     * @return the idNo
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * @param idNo the idNo to set
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    /**
     * @return the subFileNo
     */
    public Integer getSubFileNo() {
        return subFileNo;
    }

    /**
     * @param subFileNo the subFileNo to set
     */
    public void setSubFileNo(Integer subFileNo) {
        this.subFileNo = subFileNo;
    }

    /**
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * @return the platformAltitude
     */
    public Integer getPlatformAltitude() {
        return platformAltitude;
    }

    /**
     * @param platformAltitude the platformAltitude to set
     */
    public void setPlatformAltitude(Integer platformAltitude) {
        this.platformAltitude = platformAltitude;
    }

    /**
     * @return the platformPoint
     */
    public org.springframework.data.geo.Point getPlatformPoint() {
        return platformPoint;
    }

    /**
     * @param platformPoint the platformPoint to set
     */
    public void setPlatformPoint(org.springframework.data.geo.Point platformPoint) {
        this.platformPoint = platformPoint;
    }

    /**
     * @return the platformHeading
     */
    public Double getPlatformHeading() {
        return platformHeading;
    }

    /**
     * @param platformHeading the platformHeading to set
     */
    public void setPlatformHeading(Double platformHeading) {
        this.platformHeading = platformHeading;
    }

    /**
     * @return the targetPoint
     */
    public org.springframework.data.geo.Point getTargetPoint() {
        return targetPoint;
    }

    /**
     * @param targetPoint the targetPoint to set
     */
    public void setTargetPoint(org.springframework.data.geo.Point targetPoint) {
        this.targetPoint = targetPoint;
    }

    /**
     * @return the targetSemiMajorAxis
     */
    public Double getTargetSemiMajorAxis() {
        return targetSemiMajorAxis;
    }

    /**
     * @param targetSemiMajorAxis the targetSemiMajorAxis to set
     */
    public void setTargetSemiMajorAxis(Double targetSemiMajorAxis) {
        this.targetSemiMajorAxis = targetSemiMajorAxis;
    }

    /**
     * @return the targetSemiMinorAxis
     */
    public Double getTargetSemiMinorAxis() {
        return targetSemiMinorAxis;
    }

    /**
     * @param targetSemiMinorAxis the targetSemiMinorAxis to set
     */
    public void setTargetSemiMinorAxis(Double targetSemiMinorAxis) {
        this.targetSemiMinorAxis = targetSemiMinorAxis;
    }

    /**
     * @return the targetOrient
     */
    public Double getTargetOrient() {
        return targetOrient;
    }

    /**
     * @param targetOrient the targetOrient to set
     */
    public void setTargetOrient(Double targetOrient) {
        this.targetOrient = targetOrient;
    }

    /**
     * @return the classification
     */
    public Classification getClassification() {
        return classification;
    }

    /**
     * @param classification the classification to set
     */
    public void setClassification(Classification classification) {
        this.classification = classification;
    }
}
