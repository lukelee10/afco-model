package net.acesinc.afco.model.repo;

import java.util.Date;
import java.util.List;
import java.util.Set;
import net.acesinc.afco.model.metric.log.BasicLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "logMetrics", path = "logMetrics")
public interface LogMetricRepository extends MongoRepository<BasicLog, String> {
    @Query("{ 'missionId' : {$in : ?0}}")
    public List<BasicLog> findByMissionIds(@Param("missionId") Set<String> missionId);

    @Query(value = "{ missionId :?0 , startTimestamp: { $ne: null } }", sort = "{ startTimestamp: 1 }")
    public List<BasicLog> findByMissionIdOrderByStartTimestamp(String missionId);

    @Query(value = "{ missionId :?0 , currentTimestamp: { $ne: null } }", sort = "{ currentTimestamp: 1 }")
    public List<BasicLog> findByMissionIdOrderByCurrentTimestamp(String missionId);

    @Query(value = "{ 'startTimestamp' : {$gte : ?1, $lte: ?2 },'missionId' : {$in : ?0}}")
    public List<BasicLog> findByMissionIdAndStartTimestampBetween(Set<String> missionId, Date from, Date to);
}
