package net.acesinc.afco.model.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.distribution.Distributable;
import net.acesinc.afco.model.special.signal.SpecialSignal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "special-signal", path = "special-signal")
public interface SpecialSignalRepository extends MongoRepository<SpecialSignal, String> {

    public Long countByMappingIdIn(@Param("mappingId") List<String> mappingIds);

    public SpecialSignal findByMappingId(String mappingId);

    public Distributable findDistributableById(String id);

    public ArrayList<SpecialSignal> findByParentMappingId(String parentMappingId);

    @Query(value = "{ 'lastUpdated' : {$gte : ?0, $lte: ?1 }}")
    public Page<SpecialSignal> findbylastUpdatedBetween(Date from, Date to, Pageable pageable);

    @Query(value = "{ 'lastUpdated' : { $lte: ?0 }}")
    public Page<SpecialSignal> findbylastUpdatedBefore(Date to, Pageable pageable);

    public Page<SpecialSignal> findByParentMappingIdIn(
            @Param("parentMappingId") List<String> parentMappingId, Pageable pageable);

    public List<SpecialSignal> findByParentMappingIdIn(@Param("parentMappingId") List<String> parentMappingId);
}
