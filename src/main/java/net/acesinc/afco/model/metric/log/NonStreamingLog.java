package net.acesinc.afco.model.metric.log;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import net.acesinc.afco.model.query.QueryField;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author joshstandiford
 * NonStreamingLog class that mocks the data contained in a nonstreaming log file line.
 *
 * This class extends NonEmptyLog which contains shared attributes consistent with all NonEmpty metric log types.
 * NonEmptyLog also extends BasicLog which contains shared attributes for both Empty and NonEmpty metric logs.
 *
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * IF CHANGES ARE MADE TO THIS FILE BASED OFF A NEWER VERSION OF THE ICD, PLEASE KEEP THE
 * DEFINITION FILE VERSION BELOW UP TO DATE:
 *
 * The definition of this class is based off the SDS DRS ICD Rev E. of 2/08/21
 *
 */
@Document(collection = "logMetrics")
public class NonStreamingLog extends NonEmptyLog {

    private String state;
    private String action;
    private String type;
    private String system;

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "log-metrics";

    @Override
    @JsonIgnore(false)
    @JsonProperty
    public String getMissionId() {
        return super.getMissionId();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    @JsonIgnore
    @Override
    public List<QueryField> getSpecialCaseQueryableFields() {
        return SPECIAL_CASE_QUERYABLE_FIELDS;
    }

    @JsonIgnore
    @Override
    public List<String> getNonQueryableFields() {
        return NON_QUERYABLE_FIELDS;
    }
}
