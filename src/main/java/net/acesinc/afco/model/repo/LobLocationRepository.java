package net.acesinc.afco.model.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.location.LobLocation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public interface LobLocationRepository extends MongoRepository<LobLocation, String> {
    public Long countByMappingIdIn(@Param("mappingId") List<String> mappingId);

    public Page<LobLocation> findByMappingId(@Param("mappingId") String mappingId, Pageable pageable);

    public List<LobLocation> findByMappingIdIn(@Param("mappingId") List<String> mappingId, Pageable pageable);

    public List<LobLocation> findByMappingIdIn(@Param("mappingId") List<String> mappingId);

    public Page<LobLocation> findByMappingIdAndTimestampGreaterThan(
            @Param("mappingId") String mappingId,
            @Param("timestamp") @DateTimeFormat(iso = ISO.DATE_TIME) Date timestamp,
            Pageable pageable);

    public Page<LobLocation> findByMappingIdAndIngestTimeGreaterThan(
            @Param("mappingId") String mappingId,
            @Param("ingestTime") @DateTimeFormat(iso = ISO.DATE_TIME) Date ingestTime,
            Pageable pageable);

    public ArrayList<LobLocation> findByMappingId(String mappingId);
}
