/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.repo;

import java.util.Date;
import java.util.List;
import java.util.Set;
import net.acesinc.afco.model.mission.PlatformMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * limited functionality for focus to mostly purge eventually
 * @author jeremytaylor
 */
@RepositoryRestResource(collectionResourceRel = "platform-mission", path = "platform-mission")
public interface PlatformMissionRepository extends MongoRepository<PlatformMission, String> {
    @Query(value = "{ 'lastUpdated' : {$gte : ?0, $lte: ?1 }}")
    public Page<PlatformMission> findbylastUpdatedBetween(Date from, Date to, Pageable pageable);

    @Query(value = "{ 'lastUpdated' : { $lte: ?0 }}")
    public Page<PlatformMission> findbylastUpdatedBefore(Date to, Pageable pageable);

    @Query(value = "{ missionId :?0 , startTime: { $ne: null } }", sort = "{ startTime: 1 }")
    public List<PlatformMission> findByMissionIds(@Param("missionId") Set<String> missionId);

    public PlatformMission findByMissionId(String missionId);

    @Query(value = "{ 'startTime' : {$gte : ?1, $lte: ?2 },'missionId' : {$in : ?0}}")
    public List<PlatformMission> findByMissionIdAndStartTimeBetween(
            @Param("missionId") Set<String> missionId, @Param("startTime") Date from, @Param("stopTime") Date to);
}
