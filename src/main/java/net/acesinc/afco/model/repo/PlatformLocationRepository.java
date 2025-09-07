/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.repo;

import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.location.PlatformLocation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 *
 * @author andrewserff
 */
@RepositoryRestResource(collectionResourceRel = "platform_location", path = "platform_location")
public interface PlatformLocationRepository extends MongoRepository<PlatformLocation, String> {
    public Page<PlatformLocation> findByIdIn(@Param("ids") List<String> ids, Pageable pageable);

    public Page<PlatformLocation> findById(@Param("id") String id, Pageable pageable);

    public Page<PlatformLocation> findByCollectorId(@Param("collectorId") String collectorId, Pageable pageable);

    public Page<PlatformLocation> findByCollectorIdAndTimestampGreaterThan(
            @Param("collectorId") String collectorId,
            @Param("timestamp") @DateTimeFormat(iso = ISO.DATE_TIME) Date timestamp,
            Pageable pageable);

    @Query(value = "{ 'timestamp' : {$gte : ?0, $lte: ?1 }}")
    public Page<PlatformLocation> findbyTimestampBetween(Date from, Date to, Pageable pageable);

    @Query(value = "{ 'timestamp' : { $lte: ?0 }}")
    public Page<PlatformLocation> findbyTimestampBefore(Date to, Pageable pageable);
}
