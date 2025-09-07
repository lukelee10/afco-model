package net.acesinc.afco.model.repo;

import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.jsp.JspForwardingRule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("jspForwardingRule")
public interface JspForwardingRuleRepository extends MongoRepository<JspForwardingRule, String> {
    List<JspForwardingRule> findByExpirationDateGreaterThan(Date date);
}
