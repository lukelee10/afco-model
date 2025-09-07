package net.acesinc.afco.model.metric.log;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author joshstandiford
 * EmptyLog class that mocks the data contained in an empty log file line.
 *
 * Empty log extends BasicLog which contains shared attributes for both Empty and NonEmpty metric logs.
 * Since an empty log will only contain bare information, it can extend the BasicLog class directly.
 *
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * IF CHANGES ARE MADE TO THIS FILE BASED OFF A NEWER VERSION OF THE ICD, PLEASE KEEP THE
 * DEFINITION FILE VERSION BELOW UP TO DATE:
 *
 * The definition of this class is based off the SDS DRS ICD Rev E. of 2/08/21
 *
 */
@Document(collection = "logMetrics")
public class EmptyLog extends BasicLog {

    private String status;

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "log-metrics";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
