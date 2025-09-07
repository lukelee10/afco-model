package net.acesinc.afco.model.repo;

import java.util.List;
import net.acesinc.afco.model.purge.PurgeRule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "purge-rule", path = "purge-rule")
public interface PurgeRuleRepository extends MongoRepository<PurgeRule, String> {

    Page<PurgeRule> findAllByOrderByDateCreatedDesc(Pageable pageable);

    PurgeRule findByTitle(String title);

    List<PurgeRule> findByAutoPurge(boolean autoPurge);
}
