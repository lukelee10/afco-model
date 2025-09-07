package net.acesinc.afco.model.repo;

import java.util.List;
import net.acesinc.afco.model.event.signal.SignalOfInterest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "signalOfInterest", path = "signalOfInterest")
public interface SignalOfInterestRepository extends MongoRepository<SignalOfInterest, String> {

    public List<SignalOfInterest> findBySiteDigraph(@Param("siteDigraph") String siteDigraph);

    public List<SignalOfInterest> findBySiteDigraph(@Param("siteDigraph") String siteDigraph, Pageable pageable);

    @Query("{ 'siteDigraph' : ?0, 'elnot': ?1 }")
    public SignalOfInterest getBySiteDigraphAndElnot(
            @Param("siteDigraph") String siteDigraph, @Param("elnot") String elnot);

    public List<SignalOfInterest> findBySiteDigraphInAndElnotIn(
            @Param("siteDigraph") List<String> siteDigraph, @Param("elnot") List<String> elnot);

    public Long deleteBySiteDigraph(@Param("siteDigraph") String siteDigraph);
}
