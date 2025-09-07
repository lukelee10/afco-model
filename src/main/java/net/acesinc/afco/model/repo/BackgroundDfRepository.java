/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.location.BackgroundDf;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author dylankolson
 */
@RepositoryRestResource(collectionResourceRel = "backgroundDf", path = "backgroundDf")
public interface BackgroundDfRepository extends MongoRepository<BackgroundDf, String> {
    public Long countByMappingIdIn(@Param("mappingId") List<String> mappingId);

    public ArrayList<BackgroundDf> findByMappingIdIn(@Param("mappingId") List<String> mappingId, Pageable pageable);

    @Query(value = "{ 'timestamp' : {$gte : ?0, $lte: ?1 }}")
    ArrayList<BackgroundDf> findbytimestampBefore(Date to);

    @Query(value = "{ 'timestamp' : {$gte : ?0, $lte: ?1 }}")
    ArrayList<BackgroundDf> findbytimestampBetween(Date from, Date to);
}
