/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.file;

import java.util.Date;
import net.acesinc.afco.model.classification.Classification;

/**
 *
 * @author andrewserff
 */
public class AudioGist {
    private String gistId;
    private String gistText;
    private String user;
    private Date lastUpdated;
    private String lastUpdatedByUser;
    private Classification classification;

    /**
     * @return the gistText
     */
    public String getGistText() {
        return gistText;
    }

    /**
     * @param gistText the gistText to set
     */
    public void setGistText(String gistText) {
        this.gistText = gistText;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the lastUpdated
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }

    /**
     * @param lastUpdated the lastUpdated to set
     */
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * @return the lastUpdatedByUser
     */
    public String getLastUpdatedByUser() {
        return lastUpdatedByUser;
    }

    /**
     * @param lastUpdatedByUser the lastUpdatedByUser to set
     */
    public void setLastUpdatedByUser(String lastUpdatedByUser) {
        this.lastUpdatedByUser = lastUpdatedByUser;
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

    /**
     * @return the gistId
     */
    public String getGistId() {
        return gistId;
    }

    /**
     * @param gistId the gistId to set
     */
    public void setGistId(String gistId) {
        this.gistId = gistId;
    }
}
