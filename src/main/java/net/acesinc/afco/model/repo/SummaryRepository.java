package net.acesinc.afco.model.repo;

import java.util.List;
import net.acesinc.afco.model.filters.Summary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "summary", path = "summary")
public interface SummaryRepository extends MongoRepository<Summary, String> {

    public List<Summary> findByUserId(String userId);
}
