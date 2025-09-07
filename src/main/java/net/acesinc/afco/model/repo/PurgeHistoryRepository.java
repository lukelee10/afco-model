package net.acesinc.afco.model.repo;

import java.util.List;
import net.acesinc.afco.model.purge.PurgeHistory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "purge-history-list", path = "purge-history-list")
public interface PurgeHistoryRepository extends MongoRepository<PurgeHistory, String> {
    List<PurgeHistory> findByAction(Pageable pageable, String action);
}
