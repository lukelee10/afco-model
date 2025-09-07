/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.repo;

import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.location.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author andrewserff
 */
@RepositoryRestResource(collectionResourceRel = "location", path = "location")
public interface LocationRepository extends MongoRepository<Location, String> {
    public List<Location> findByMappingId(@Param("mappingId") String mappingId);

    public List<Location> findByMappingIdAndTimestampGreaterThan(
            @Param("mappingId") String mappingId, @Param("timestamp") Date timestamp);

    public List<Location> findByMappingIdAndIngestTimeGreaterThan(
            @Param("mappingId") String mappingId, @Param("ingestTime") Date ingestTime);
}
