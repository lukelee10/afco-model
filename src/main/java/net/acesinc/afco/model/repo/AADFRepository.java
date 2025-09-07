/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.repo;

import net.acesinc.afco.model.AADF;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author jeremytaylor
 */
@RepositoryRestResource(collectionResourceRel = "aadf", path = "aadf")
public interface AADFRepository extends MongoRepository<AADF, String> {}
