/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model;

/**
 *
 * @author jebpair
 */
public class Location {

    private String msnNo;
    private String idNo;
    private String subFileNo;
    private String ellFreq;
    private String ellNumOfLops;
    private org.springframework.data.geo.Point ellCoords;
    private String ellOrient;
    private String ellSmajNmi;
    private String ellSminNmi;
    private String ellTime;
    private String ellCategory;
    private String ellSubtype;
    private String lopNum;
    private String lopTime;
    private org.springframework.data.geo.Point lopCoords;
    private String lopAzimuth;
    private String lopCategory;
    private String lopSubtype;
    private String lopQuality;

    public Location(
            String msnNo,
            String idNo,
            String subFileNo,
            String ellFreq,
            String ellNumOfLops,
            org.springframework.data.geo.Point ellCoords,
            String ellOrient,
            String ellSmajNmi,
            String ellSminNmi,
            String ellTime,
            String ellCategory,
            String ellSubtype,
            String lopNum,
            String lopTime,
            org.springframework.data.geo.Point lopCoords,
            String lopAzimuth,
            String lopCategory,
            String lopSubtype,
            String lopQuality) {

        this.msnNo = msnNo;
        this.idNo = idNo;
        this.subFileNo = subFileNo;
        this.ellFreq = ellFreq;
        this.ellNumOfLops = ellNumOfLops;
        this.ellCoords = ellCoords;
        this.ellOrient = ellOrient;
        this.ellSmajNmi = ellSmajNmi;
        this.ellSminNmi = ellSminNmi;
        this.ellTime = ellTime;
        this.ellCategory = ellCategory;
        this.ellSubtype = ellSubtype;
        this.lopNum = lopNum;
        this.lopTime = lopTime;
        this.lopCoords = lopCoords;
        this.lopAzimuth = lopAzimuth;
        this.lopCategory = lopCategory;
        this.lopSubtype = lopSubtype;
        this.lopQuality = lopQuality;
    }

    @Override
    public String toString() {
        return "msnNo=" + this.msnNo + "::idNo=" + this.idNo + "::subFileNo=" + this.subFileNo + "::ellFreq="
                + this.ellFreq + "::ellNumOfLops=" + this.ellNumOfLops
                + "::ellCoords.getX -->(longitude)=" + this.getEllCoords().getX()
                + "::ellCoords.getY -->(latitude)=" + this.getEllCoords().getY()
                + "::ellOrient=" + this.ellOrient
                + "::ellSmajNmi=" + this.ellSmajNmi + "::ellSminNmi=" + this.ellSminNmi
                + "::ellTime=" + this.ellTime + "::ellCategory=" + this.ellCategory + "::ellSubtype=" + this.ellSubtype
                + "::lopNum=" + this.lopNum + "::lopTime=" + this.lopTime
                + "::lopCoords.getX -->(longitude)=" + this.getLopCoords().getX()
                + "::lopCoords.getY -->(latitude)=" + this.getLopCoords().getY()
                + "::lopAzimuth=" + this.lopAzimuth + "::lopCategory=" + this.lopCategory
                + "::lopSubtype=" + this.lopSubtype + "::lopQuality=" + this.lopQuality;
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
     *
     * @param idNo the idNo to set
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    /**
     * @return the ellFreq
     */
    public String getEllFreq() {
        return ellFreq;
    }

    /**
     * @param ellFreq the ellFreq to set
     */
    public void setEllFreq(String ellFreq) {
        this.ellFreq = ellFreq;
    }

    /**
     * @return the ellNumOfLoops
     */
    public String getEllNumOfLops() {
        return ellNumOfLops;
    }

    /**
     * @param ellNumOfLops the ellNumOfLoops to set
     */
    public void setEllNumOfLops(String ellNumOfLops) {
        this.ellNumOfLops = ellNumOfLops;
    }

    /**
     * @return the ellCoords
     */
    public org.springframework.data.geo.Point getEllCoords() {
        return ellCoords;
    }

    /**
     * @param ellCoords the ellCoords to set
     */
    public void setEllCoords(org.springframework.data.geo.Point ellCoords) {
        this.ellCoords = ellCoords;
    }

    /**
     * @return the ellOrient
     */
    public String getEllOrient() {
        return ellOrient;
    }

    /**
     * @param ellOrient the ellOrient to set
     */
    public void setEllOrient(String ellOrient) {
        this.ellOrient = ellOrient;
    }

    /**
     * @return the ellSmajNmi
     */
    public String getEllSmajNmi() {
        return ellSmajNmi;
    }

    /**
     * @param ellSmajNmi the ellSmajNmi to set
     */
    public void setEllSmajNmi(String ellSmajNmi) {
        this.ellSmajNmi = ellSmajNmi;
    }

    /**
     * @return the ellSminNmi
     */
    public String getEllSminNmi() {
        return ellSminNmi;
    }

    /**
     * @param ellSminNmi the ellSminNmi to set
     */
    public void setEllSminNmi(String ellSminNmi) {
        this.ellSminNmi = ellSminNmi;
    }

    /**
     * @return the ellTime
     */
    public String getEllTime() {
        return ellTime;
    }

    /**
     * @param ellTime the ellTime to set
     */
    public void setEllTime(String ellTime) {
        this.ellTime = ellTime;
    }

    /**
     * @return the ellCategory
     */
    public String getEllCategory() {
        return ellCategory;
    }

    /**
     * @param ellCategory the ellCategory to set
     */
    public void setEllCategory(String ellCategory) {
        this.ellCategory = ellCategory;
    }

    /**
     * @return the ellSubtype
     */
    public String getEllSubtype() {
        return ellSubtype;
    }

    /**
     * @param ellSubtype the ellSubtype to set
     */
    public void setEllSubtype(String ellSubtype) {
        this.ellSubtype = ellSubtype;
    }

    /**
     * @return the lopNum
     */
    public String getLopNum() {
        return lopNum;
    }

    /**
     * @param lopNum the lopNum to set
     */
    public void setLopNum(String lopNum) {
        this.lopNum = lopNum;
    }

    /**
     * @return the lopTime
     */
    public String getLopTime() {
        return lopTime;
    }

    /**
     * @param lopTime the lopTime to set
     */
    public void setLopTime(String lopTime) {
        this.lopTime = lopTime;
    }

    /**
     * @return the lopCoords
     */
    public org.springframework.data.geo.Point getLopCoords() {
        return lopCoords;
    }

    /**
     * @param lopCoords the lopCoords to set
     */
    public void setLopCoords(org.springframework.data.geo.Point lopCoords) {
        this.lopCoords = lopCoords;
    }

    /**
     * @return the lopAzimuth
     */
    public String getLopAzimuth() {
        return lopAzimuth;
    }

    /**
     * @param lopAzimuth the lopAzimuth to set
     */
    public void setLopAzimuth(String lopAzimuth) {
        this.lopAzimuth = lopAzimuth;
    }

    /**
     * @return the lopCategory
     */
    public String getLopCategory() {
        return lopCategory;
    }

    /**
     * @param lopCategory the lopCategory to set
     */
    public void setLopCategory(String lopCategory) {
        this.lopCategory = lopCategory;
    }

    /**
     * @return the lopSubtype
     */
    public String getLopSubtype() {
        return lopSubtype;
    }

    /**
     * @param lopSubtype the lopSubtype to set
     */
    public void setLopSubtype(String lopSubtype) {
        this.lopSubtype = lopSubtype;
    }

    /**
     * @return the lopQuality
     */
    public String getLopQuality() {
        return lopQuality;
    }

    /**
     * @param lopQuality the lopQuality to set
     */
    public void setLopQuality(String lopQuality) {
        this.lopQuality = lopQuality;
    }

    /**
     * @return the subFileNo
     */
    public String getSubFileNo() {
        return subFileNo;
    }

    /**
     * @param subFileNo the subFileNo to set
     */
    public void setSubFileNo(String subFileNo) {
        this.subFileNo = subFileNo;
    }
}
