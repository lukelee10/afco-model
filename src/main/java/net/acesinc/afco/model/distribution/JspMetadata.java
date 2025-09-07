package net.acesinc.afco.model.distribution;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class JspMetadata {
    private String site;
    private String machine;
    private String host;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String ruleId;
}
