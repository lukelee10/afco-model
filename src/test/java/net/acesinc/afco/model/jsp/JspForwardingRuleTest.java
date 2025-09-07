package net.acesinc.afco.model.jsp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.acesinc.afco.model.repo.JspForwardingRuleRepository;
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
public class JspForwardingRuleTest {

    @Autowired
    JspForwardingRuleRepository repo;

    @BeforeEach
    public void beforeEach() {
        repo.deleteAll();
    }

    @Test
    void testCreateRule() {
        List<String> createdIds = new ArrayList<>();

        JspForwardingRule rule1 = createRule("Rule 1");
        createdIds.add(repo.save(rule1).getId());

        JspForwardingRule rule2 = createRule("Rule 2");
        createdIds.add(repo.save(rule2).getId());

        List<JspForwardingRule> foundRules = repo.findAll();
        assertEquals(createdIds.size(), foundRules.size(), "Number of found rules should equal how many were created");
        assertThat(
                foundRules.stream().map(JspForwardingRule::getId).collect(Collectors.toList()),
                containsInAnyOrder(createdIds.toArray(new String[0])));
    }

    @Test
    void testUpdateRule() {
        JspForwardingRule rule = createRule("Original Green Beans");
        JspForwardingRule savedRule = repo.save(rule);

        String id = savedRule.getId();
        savedRule.setName("New Green Beans");
        repo.save(savedRule);

        JspForwardingRule foundRule = repo.findById(id).orElse(null);
        assertNotNull(foundRule);

        assertEquals("New Green Beans", foundRule.getName());
    }

    @Test
    void testFindByExpirationDateGreaterThan() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();
        calendar.add(Calendar.DATE, 2);
        Date tomorrow = calendar.getTime();

        JspForwardingRule expired = createRule("expired rule");
        expired.setExpirationDate(yesterday);
        expired.addCondition(new JspForwardingRule.Condition(JspForwardingRule.Condition.Field.FREQUENCY, 125.0));
        repo.save(expired);

        JspForwardingRule current = createRule("current rule");
        current.setExpirationDate(tomorrow);
        current.addCondition(new JspForwardingRule.Condition(JspForwardingRule.Condition.Field.FREQUENCY, 125.0));
        repo.save(current);

        assertEquals(2, repo.findAll().size());
        assertEquals(1, repo.findByExpirationDateGreaterThan(new Date()).size());
    }

    @Test
    void testConditions() throws Exception {
        JspForwardingRule rule = createRule("A rule with conditions");
        rule.addCondition(new JspForwardingRule.Condition(
                JspForwardingRule.Condition.Field.MISSION_ID, new String[] {"yomama", "yopappy"}));
        rule.addCondition(new JspForwardingRule.Condition(JspForwardingRule.Condition.Field.FREQUENCY, 500.0));
        rule.addCondition(new JspForwardingRule.Condition(JspForwardingRule.Condition.Field.SIGAD, "12345"));

        // verify you can't add the same field twice
        assertThrows(
                IllegalArgumentException.class,
                () -> rule.addCondition(
                        new JspForwardingRule.Condition(JspForwardingRule.Condition.Field.SIGAD, "12345")));

        // let's verify the conditions before the save
        assertEquals(3, rule.getConditions().size());
        assertNull(rule.getCondition(JspForwardingRule.Condition.Field.OPERATOR_ID));

        // let's verify what you get back from mongo after saving
        String id = repo.save(rule).getId();
        JspForwardingRule savedRule = repo.findById(id).orElse(null);

        assertEquals(3, savedRule.getConditions().size());
        assertNull(savedRule.getCondition(JspForwardingRule.Condition.Field.OPERATOR_ID));

        JspForwardingRule.Condition condition = savedRule.getCondition(JspForwardingRule.Condition.Field.MISSION_ID);
        assertEquals(JspForwardingRule.Condition.Field.MISSION_ID, condition.getField());
        assertEquals("missionId", condition.getFieldName());
        assertEquals(String.class, condition.getFieldType());
        assertNull(condition.getValue());
        assertNotNull(condition.getValues());
        assertTrue(Arrays.asList(condition.getValues()).contains("yomama"));

        condition = savedRule.getCondition(JspForwardingRule.Condition.Field.FREQUENCY);
        assertEquals(JspForwardingRule.Condition.Field.FREQUENCY, condition.getField());
        assertNotNull(condition.getValue());
        assertNull(condition.getValues());
        assertEquals(500.0, condition.getValue());

        condition = savedRule.getCondition(JspForwardingRule.Condition.Field.SIGAD);
        assertEquals(JspForwardingRule.Condition.Field.SIGAD, condition.getField());
        assertEquals("sigad", condition.getFieldName());
        assertEquals(String.class, condition.getFieldType());
        assertNotNull(condition.getValue());
        assertNull(condition.getValues());
        assertEquals("12345", condition.getValue());

        // verify you can't add the same field twice in a saved rule
        assertThrows(
                IllegalArgumentException.class,
                () -> savedRule.addCondition(
                        new JspForwardingRule.Condition(JspForwardingRule.Condition.Field.SIGAD, "12345")));

        // let's print me out! I am awfully pretty!
        log.debug(new ObjectMapper().writeValueAsString(savedRule));
    }

    @Getter
    @AllArgsConstructor
    public static class TestObjectClass {
        private String missionId;
        private Double frequency;
        private String favoriteColor;
    }

    @Test
    void testConditionMatches() {
        JspForwardingRule.Condition condition = null;

        condition = new JspForwardingRule.Condition(JspForwardingRule.Condition.Field.MISSION_ID, "12345");
        assertTrue(condition.matches(new TestObjectClass("12345", 0.0D, "")));

        condition =
                new JspForwardingRule.Condition(JspForwardingRule.Condition.Field.MISSION_ID, new String[] {"12345"});
        assertTrue(condition.matches(new TestObjectClass("12345", 0.0D, "")));

        condition = new JspForwardingRule.Condition(JspForwardingRule.Condition.Field.FREQUENCY, 5001D);
        assertTrue(condition.matches(new TestObjectClass("12346", 5001D, "")));

        condition = new JspForwardingRule.Condition(
                JspForwardingRule.Condition.Field.FREQUENCY, new Double[] {1001D, 5001D});
        assertTrue(condition.matches(new TestObjectClass("12346", 5001D, "")));

        condition =
                new JspForwardingRule.Condition(JspForwardingRule.Condition.Field.MISSION_ID, new String[] {"12345"});
        assertFalse(condition.matches(new TestObjectClass("12346", 0.0D, "")));

        condition = new JspForwardingRule.Condition(JspForwardingRule.Condition.Field.SIG_ID, new String[] {"12345"});
        assertFalse(condition.matches(new TestObjectClass("12345", 5001.0D, "")));
    }

    private JspForwardingRule createRule(String name) {
        JspForwardingRule rule = new JspForwardingRule();
        rule.setName(name);
        rule.setOwner("Frederick Ruggles");
        rule.setSite("DMS-LA");
        rule.setHost("0.0.0.0");
        return rule;
    }
}
