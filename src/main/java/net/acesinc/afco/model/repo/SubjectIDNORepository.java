/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.repo;

import java.util.Date;
import java.util.List;
import java.util.Set;
import net.acesinc.afco.model.subject.SubjectIDNO;
import net.acesinc.afco.model.subject.SubjectType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author andrewserff
 */
@RepositoryRestResource(collectionResourceRel = "comint-subject", path = "comint-subject")
public interface SubjectIDNORepository extends MongoRepository<SubjectIDNO, String> {
    SubjectIDNO findByMappingId(String mappingId);

    List<SubjectIDNO> findByType(SubjectType type);

    @Query(value = "{ 'lastUpdated' : {$gte : ?0, $lte: ?1 }}")
    Page<SubjectIDNO> findbylastUpdatedBetween(Date from, Date to, Pageable pageable);

    @Query(value = "{ 'lastUpdated' : { $lte: ?0 }}")
    Page<SubjectIDNO> findbylastUpdatedBefore(Date to, Pageable pageable);

    @Query("{ 'msnNo' : {$in : ?0}}")
    List<SubjectIDNO> findByMsnNoIds(@Param("msnNo") Set<String> msnNo);

    @Query(value = "{ msnNo :?0 , upDate: { $ne: null } }", sort = "{ upDate: 1 }")
    List<SubjectIDNO> findByMsnNoOrderByUpDate(String msnNo);

    @Query(value = "{ msnNo :?0 , downDate: { $ne: null } }", sort = "{ downDate: 1 }")
    List<SubjectIDNO> findByMsnNoOrderByDownDate(String missionId);

    @Query(value = "{ 'upDate' : {$gte : ?1, $lte: ?2 },'msnNo' : {$in : ?0}}")
    List<SubjectIDNO> findByMsnNoAndUpDateBetween(Set<String> msnNo, Date from, Date to);
}
