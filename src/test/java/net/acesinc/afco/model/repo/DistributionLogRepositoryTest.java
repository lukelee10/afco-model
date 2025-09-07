package net.acesinc.afco.model.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.acesinc.afco.model.distribution.DistributionLog;
import net.acesinc.afco.model.distribution.JspMetadata;
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
@Slf4j
public class DistributionLogRepositoryTest {

    @Autowired
    DistributionLogRepository repo;

    @BeforeEach
    void setUp() {
        repo.deleteAll();

        DistributionLog distributionLog = new DistributionLog();
        JspMetadata jspMetadata = new JspMetadata();
        jspMetadata.setMachine("machine");
        jspMetadata.setSite("site");
        jspMetadata.setHost("host");
        jspMetadata.setRuleId("rulez");
        distributionLog.setJspMetadata(jspMetadata);
        repo.save(distributionLog);
    }

    @Test
    void testFindByJspRuleIds() {
        List<DistributionLog> logs = repo.findByJspRuleIds(Collections.singletonList("rulez"));
        assertEquals(1, logs.size());
        logs = repo.findByJspRuleIds(Collections.singletonList("rules"));
        assertEquals(0, logs.size());
    }
}
