package net.acesinc.afco.model.repo;

import java.util.List;
import lombok.NonNull;
import net.acesinc.afco.model.jsp.JspServer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("jspServer")
public interface JspServerRepository extends MongoRepository<JspServer, String> {
    @NonNull
    @Override
    List<JspServer> findAll();

    List<JspServer> findBySite(String site);
}
