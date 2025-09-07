/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author jeremytaylor
 */
public class ProcessorResult {

    @Field("lang-proc-name")
    private String languageProcessorName;

    @Field("lang-result-fips")
    private String languageFips;

    @Field("lang-result-full")
    private String languageFull;

    @Field("lang-conf")
    private Integer languageConfidence;

    @Field("process-time-millis")
    private Long processTimeInMillis;

    /**
     * @return the languageProcessorName
     */
    public String getLanguageProcessorName() {
        return languageProcessorName;
    }

    /**
     * @param languageProcessorName the languageProcessorName to set
     */
    public void setLanguageProcessorName(String languageProcessorName) {
        this.languageProcessorName = languageProcessorName;
    }

    /**
     * @return the languageConfidence
     */
    public Integer getLanguageConfidence() {
        return languageConfidence;
    }

    /**
     * @param languageConfidence the languageConfidence to set
     */
    public void setLanguageConfidence(Integer languageConfidence) {
        this.languageConfidence = languageConfidence;
    }

    /**
     * @return the processTimeInMillis
     */
    public Long getProcessTimeInMillis() {
        return processTimeInMillis;
    }

    /**
     * @param processTimeInMillis the processTimeInMillis to set
     */
    public void setProcessTimeInMillis(Long processTimeInMillis) {
        this.processTimeInMillis = processTimeInMillis;
    }

    /**
     * @return the languageFips
     */
    public String getLanguageFips() {
        return languageFips;
    }

    /**
     * @param languageFips the languageFips to set
     */
    public void setLanguageFips(String languageFips) {
        this.languageFips = languageFips;
    }

    /**
     * @return the languageFull
     */
    public String getLanguageFull() {
        return languageFull;
    }

    /**
     * @param languageFull the languageFull to set
     */
    public void setLanguageFull(String languageFull) {
        this.languageFull = languageFull;
    }
}
