package net.acesinc.afco.model.repo;

import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.distribution.Destination;
import net.acesinc.afco.model.distribution.DistributionDataType;
import net.acesinc.afco.model.distribution.DistributionLog;
import net.acesinc.afco.model.distribution.DistributionStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "distribution-log", path = "distribution-log")
public interface DistributionLogRepository extends MongoRepository<DistributionLog, String> {
    @Query("{ 'parentMappingId' : ?0, 'destination' : ?1, 'type' : ?2, 'status' : ?3 }")
    public List<DistributionLog> findByParentMappingIdAndDestinationAndTypeAndStatus(
            String parentMappingId, Destination destination, DistributionDataType type, DistributionStatus status);

    @Query("{ 'parentMappingId' : ?0, 'parentDataFileId' : ?1, 'destination' : ?2, 'type' : ?3, 'status' : ?4 }")
    public List<DistributionLog> findByParentMappingIdAndParentDataFileIdAndDestinationAndTypeAndStatus(
            String parentMappingId,
            String parentDataFileId,
            Destination destination,
            DistributionDataType type,
            DistributionStatus status);

    @Query("{ 'parentMappingId' : ?0 }")
    public List<DistributionLog> findByParentMappingId(String parentMappingId, Pageable pageable);

    @Query("{ 'parentMappingId' : ?0, 'parentDataFileId' : ?1 }")
    public List<DistributionLog> findByParentMappingIdAndParentDataFileId(
            String parentMappingId, String parentDataFileId, Pageable pageable);

    @Query("{ 'status' : ?0 }")
    public List<DistributionLog> findByStatus(@Param("status") DistributionStatus status, Pageable pageable);

    @Query(value = "{'status': {$eq: ?0}, 'timestamp' : { $lte: ?1 }}")
    public List<DistributionLog> findByStatusAndTimestampBefore(
            DistributionStatus status, Date timestamp, Pageable pageable);

    @Query("{ 'status' : ?0, 'type' : ?1 }")
    public List<DistributionLog> findByStatusAndType(
            DistributionStatus status, DistributionDataType type, Pageable pageable);

    @Query("{ 'timestamp' : ?0, 'absoluteFilePath' : ?1, 'status' : ?2 }")
    public DistributionLog findByTimestampAndAbsoluteFilePathAndStatus(
            Date timestamp, String absoluteFilePath, DistributionStatus status);

    @Query("{ 'parentId' : ?0, 'parentDataFileId' : ?1, 'type' : ?2, 'status' : ?3 }")
    public DistributionLog findByParentIdAndParentDataFileIdAndTypeAndStatus(
            String parentId, String parentDataFileId, DistributionDataType type, DistributionStatus status);

    @Query("{ 'parentDataFileId' : ?0, 'type' : ?1 }")
    public List<DistributionLog> findByParentDataFileIdAndType(String parentDataFileId, DistributionDataType type);

    @Query("{ 'jspMetadata.ruleId': { $in: ?0 } }")
    public List<DistributionLog> findByJspRuleIds(List<String> ruleIds);

    @Query("{ 'status' : ?0, 'destination' : ?1 }")
    public List<DistributionLog> findByStatusAndDestination(DistributionStatus status, Destination destination);
}
