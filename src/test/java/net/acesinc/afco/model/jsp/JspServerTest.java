package net.acesinc.afco.model.jsp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import net.acesinc.afco.model.repo.JspServerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ActiveProfiles("test")
@DataMongoTest()
@EnableMongoRepositories(basePackages = "net.acesinc.afco.model.repo")
@ContextConfiguration(classes = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class JspServerTest {

    @Autowired
    JspServerRepository repo;

    @BeforeEach
    void beforeEach() {
        repo.deleteAll();
        JspServer jspServer1 = new JspServer("DMS-GA", "nmp001.dms-ga.dcgs.usaf.nsa.ic.gov", "10.0.1.201");
        JspServer jspServer2 = new JspServer("DMS-DC", "nmp002.dms-dc.dcgs.usaf.nsa.ic.gov", "10.0.1.202");
        repo.save(jspServer1);
        repo.save(jspServer2);
    }

    @Test
    void testFindAll() {
        List<JspServer> jspServers = repo.findAll();
        assertEquals(2, jspServers.size());
    }

    @Test
    void testFindBySite() {
        List<JspServer> jspServers = repo.findBySite("DMS-GA");
        assertEquals(1, jspServers.size());
    }
}
