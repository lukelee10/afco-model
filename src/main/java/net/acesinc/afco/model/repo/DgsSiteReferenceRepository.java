package net.acesinc.afco.model.repo;

import net.acesinc.afco.model.dgsSiteReference.DgsSiteReference;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "dgsSiteReference", path = "dgsSiteReference")
public interface DgsSiteReferenceRepository extends MongoRepository<DgsSiteReference, String> {

    // This repository will provide means to returning a DgsSiteReference by ID with a "/api/rest/dgsSiteReference GET
    // call. It will also DELETE by ID using "api/rest/dgsSiteReference/{id}" sending a DELETE request. This class can
    // also add a new DgsSiteReference sending a POST request to "/api/rest/dgsSiteReference/{id}"

}
