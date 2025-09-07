/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.repo;

import net.acesinc.afco.model.config.CesiumBaseLayerPickerConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author jeremytaylor
 */
@RepositoryRestResource(collectionResourceRel = "cesiumBaseLayerConfig", path = "cesium-layer-config")
public interface CesiumBaseLayerPickerConfigRepository extends MongoRepository<CesiumBaseLayerPickerConfig, String> {}
