/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jeremytaylor
 */
@Document(collection = "cesiumBaseLayerConfig")
public class CesiumBaseLayerPickerConfig implements Serializable {
    @Id
    private String id;

    @JsonProperty(required = false)
    private List<ProviderViewModel> imageryProviderViewModels = new ArrayList<>();

    @JsonProperty(required = false)
    private List<ProviderViewModel> terrainProviderViewModels = new ArrayList<>();

    /**
     * @return the imageryProviderViewModels
     */
    public List<ProviderViewModel> getImageryProviderViewModels() {
        return imageryProviderViewModels;
    }

    /**
     * @param imageryProviderViewModels the imageryProviderViewModels to set
     */
    public void setImageryProviderViewModels(List<ProviderViewModel> imageryProviderViewModels) {
        this.imageryProviderViewModels = imageryProviderViewModels;
    }

    /**
     * @return the terrainProviderViewModels
     */
    public List<ProviderViewModel> getTerrainProviderViewModels() {
        return terrainProviderViewModels;
    }

    /**
     * @param terrainProviderViewModels the terrainProviderViewModels to set
     */
    public void setTerrainProviderViewModels(List<ProviderViewModel> terrainProviderViewModels) {
        this.terrainProviderViewModels = terrainProviderViewModels;
    }

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
}
