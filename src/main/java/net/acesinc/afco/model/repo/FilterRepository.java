package net.acesinc.afco.model.repo;

import java.util.List;
import net.acesinc.afco.model.filter.FilterModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "filters", path = "filters")
public interface FilterRepository extends MongoRepository<FilterModel, String> {

    List<FilterModel> findByUserId(String userId);

    List<FilterModel> findByTypeAndUserId(@Param("type") String type, @Param("userId") String userId);

    List<FilterModel> findAll();
}
