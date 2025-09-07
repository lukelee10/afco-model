package net.acesinc.afco.model.repo;

import java.util.List;
import net.acesinc.afco.model.purge.PurgePartitionList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "purge-partition-list", path = "purge-partition-list")
public interface PurgePartitionListRepository extends MongoRepository<PurgePartitionList, String> {
    List<PurgePartitionList> findByPartition(String partition);

    PurgePartitionList findByPartitionAndRuleThreshold(String partition, boolean ruleThreshold);
}
