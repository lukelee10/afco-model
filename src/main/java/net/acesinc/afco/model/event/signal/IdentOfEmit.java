/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.event.signal;

import com.fasterxml.jackson.annotation.JsonView;
import net.acesinc.afco.model.subject.SignalValidation;
import net.acesinc.afco.model.view.Views;

/**
 *
 * @author jeremytaylor
 */
public class IdentOfEmit {

    @JsonView(Views.MapView.class)
    private String ident;

    @JsonView(Views.FullView.class)
    private String modeCode;

    @JsonView(Views.FullView.class)
    private String nickName;

    @JsonView(Views.FullView.class)
    private String assocWeapon;

    @JsonView(Views.DashboardView.class)
    private String functionCode;

    @JsonView(Views.MapView.class)
    private Integer confidence;

    @JsonView(Views.MapView.class)
    private SignalValidation validation;

    /**
     * @return the ident
     */
    public String getIdent() {
        return ident;
    }

    /**
     * @param ident the ident to set
     */
    public void setIdent(String ident) {
        this.ident = ident;
    }

    /**
     * @return the modeCode
     */
    public String getModeCode() {
        return modeCode;
    }

    /**
     * @param modeCode the modeCode to set
     */
    public void setModeCode(String modeCode) {
        this.modeCode = modeCode;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the assocWeapon
     */
    public String getAssocWeapon() {
        return assocWeapon;
    }

    /**
     * @param assocWeapon the assocWeapon to set
     */
    public void setAssocWeapon(String assocWeapon) {
        this.assocWeapon = assocWeapon;
    }

    /**
     * @return the functionCode
     */
    public String getFunctionCode() {
        return functionCode;
    }

    /**
     * @param functionCode the functionCode to set
     */
    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    /**
     * @return the confidence
     */
    public Integer getConfidence() {
        return confidence;
    }

    /**
     * @param confidence the confidence to set
     */
    public void setConfidence(Integer confidence) {
        this.confidence = confidence;
    }

    /**
     * @return the validation
     */
    public SignalValidation getValidation() {
        return validation;
    }

    /**
     * @param validation the validation to set
     */
    public void setValidation(SignalValidation validation) {
        this.validation = validation;
    }

    public int compareTo(IdentOfEmit o) {
        if (o.confidence == null) {
            return -1;
        }

        if (confidence == null) {
            return 1;
        }
        return o.confidence - confidence;
    }

    public static int compareToValid(IdentOfEmit o) {
        if (o.validation != null) {
            return 1;
        } else {
            return -1;
        }
    }
}
