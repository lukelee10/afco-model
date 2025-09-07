package net.acesinc.afco.model.metric.log;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author joshstandiford
 *
 * Contains the shared attributes that are exclusive to the NonEmpty log type files.
 *
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * IF CHANGES ARE MADE TO THIS FILE BASED OFF A NEWER VERSION OF THE ICD, PLEASE KEEP THE
 * DEFINITION FILE VERSION BELOW UP TO DATE:
 *
 * The definition of this class is based off the SDS DRS ICD Rev E. of 2/08/21
 */
@Document(collection = "logMetrics")
public class NonEmptyLog extends BasicLog {

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "log-metrics";

    @JsonIgnore
    protected static List<String> NON_QUERYABLE_FIELDS =
            Arrays.asList("NON_QUERYABLE_FIELDS", "SPECIAL_CASE_QUERYABLE_FIELDS");

    @Override
    @JsonIgnore(false)
    @JsonProperty
    public Long getNewNumberOfMessages() {
        return super.getNewNumberOfMessages();
    }

    @Override
    @JsonIgnore(false)
    @JsonProperty
    public Long getTotalNumberOfMessages() {
        return super.getTotalNumberOfMessages();
    }

    @JsonIgnore
    @Override
    public List<String> getNonQueryableFields() {
        return NON_QUERYABLE_FIELDS;
    }
}
