/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.location.TargetLocation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 *
 * @author andrewserff
 */
@RepositoryRestResource(collectionResourceRel = "target_location", path = "target_location")
public interface TargetLocationRepository extends MongoRepository<TargetLocation, String> {
    public Long countByMappingIdIn(@Param("mappingId") List<String> mappingId);

    public Page<TargetLocation> findByIdIn(@Param("ids") List<String> ids, Pageable pageable);

    public Page<TargetLocation> findById(@Param("id") String id, Pageable pageable);

    public Page<TargetLocation> findByMappingId(@Param("mappingId") String mappingId, Pageable pageable);

    public List<TargetLocation> findByMappingIdIn(@Param("mappingId") List<String> mappingId, Pageable pageable);

    public List<TargetLocation> findByMappingIdIn(@Param("mappingId") List<String> mappingId);

    public Page<TargetLocation> findByMappingIdAndTimestampGreaterThan(
            @Param("mappingId") String mappingId,
            @Param("timestamp") @DateTimeFormat(iso = ISO.DATE_TIME) Date timestamp,
            Pageable pageable);

    public Page<TargetLocation> findByMappingIdAndIngestTimeGreaterThan(
            @Param("mappingId") String mappingId,
            @Param("ingestTime") @DateTimeFormat(iso = ISO.DATE_TIME) Date ingestTime,
            Pageable pageable);

    public ArrayList<TargetLocation> findByMappingId(String mappingId);
}
