/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author jeremytaylor
 */
public class Parameters {
    @JsonProperty(required = false)
    private String transparent;

    @JsonProperty(required = false)
    private String format;

    /**
     * @return the transparent
     */
    public String getTransparent() {
        return transparent;
    }

    /**
     * @param transparent the transparent to set
     */
    public void setTransparent(String transparent) {
        this.transparent = transparent;
    }

    /**
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format the format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }
}
