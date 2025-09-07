package net.acesinc.afco.model.metric.log;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author joshstandiford
 * StreamingLog class that mocks the data contained in a streaming log file line.
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
public class StreamingLog extends NonEmptyLog {

    private Integer portNumber;
    private String category;
    private String protocolType;

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "log-metrics";

    /*
     * SETTERS & GETTERS
     */
    public Integer getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }
}
