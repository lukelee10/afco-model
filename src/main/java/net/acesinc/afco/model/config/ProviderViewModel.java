/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 *
 * @author jeremytaylor
 */
public class ProviderViewModel implements Serializable {
    private String name;

    @JsonProperty(required = false)
    private String tooltip;

    @JsonProperty(required = false)
    private String iconUrl;
    /**
     * to at least help differentiate between base and top imagery layers, but leaving a little more generic for now.
     * Leaving optional for now due to terrain layers may not needing to use this.
     */
    @JsonProperty(required = false)
    private LayerType type;

    private ProviderConfig providerConfig;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the tooltip
     */
    public String getTooltip() {
        return tooltip;
    }

    /**
     * @param tooltip the tooltip to set
     */
    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    /**
     * @return the iconUrl
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * @param iconUrl the iconUrl to set
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * @return the providerConfig
     */
    public ProviderConfig getProviderConfig() {
        return providerConfig;
    }

    /**
     * @param providerConfig the providerConfig to set
     */
    public void setProviderConfig(ProviderConfig providerConfig) {
        this.providerConfig = providerConfig;
    }

    /**
     * @return the type
     */
    public LayerType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(LayerType type) {
        this.type = type;
    }
}
