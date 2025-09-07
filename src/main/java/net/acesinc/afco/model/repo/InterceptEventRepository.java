/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.repo;

import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.event.InterceptEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author jeremytaylor
 */
@RepositoryRestResource(collectionResourceRel = "intercept", path = "intercept")
public interface InterceptEventRepository extends MongoRepository<InterceptEvent, String> {
    public List<InterceptEvent> getByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'missionId' : ?0, 'platformId': ?1, 'sensorId': ?2, 'dwellId': ?3, 'year': ?4 }")
    public List<InterceptEvent> getByDwellFileInfo(
            @Param("missionId") String missionId,
            @Param("platformId") String platformId,
            @Param("sensorId") Long sensorId,
            @Param("dwellId") String dwellId,
            @Param("year") Integer year);

    @Query(value = "{ 'ingestTime' : {$gte : ?0, $lte: ?1 }}")
    public Page<InterceptEvent> findbyIngestTimeBetween(Date from, Date to, Pageable pageable);

    @Query(value = "{ 'ingestTime' : { $lte: ?0 }}")
    public Page<InterceptEvent> findbyIngestTimeBefore(Date to, Pageable pageable);
}
