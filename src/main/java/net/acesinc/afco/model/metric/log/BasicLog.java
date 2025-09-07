package net.acesinc.afco.model.metric.log;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author joshstandiford
 * This class has all of the shared data between all of the log files (Empty & NonEmpty).
 *
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * IF CHANGES ARE MADE TO THIS FILE BASED OFF A NEWER VERSION OF THE ICD, PLEASE KEEP THE
 * DEFINITION FILE VERSION BELOW UP TO DATE:
 *
 * The definition of this class is based off the SDS DRS ICD Rev E. of 2/08/21
 */
@Document(collection = "logMetrics")
public class BasicLog implements Queryable {

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "log-metrics";

    @JsonIgnore
    protected static List<QueryField> SPECIAL_CASE_QUERYABLE_FIELDS = Arrays.asList(
            new QueryField("fileName", "File Name", FieldType.STRING, "fileName", null, false, null),
            new QueryField("logType", "Log Type", FieldType.ENUM, "logType", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("messageType", "Message Type", FieldType.STRING, "messageType", null, false, null),
            new QueryField("missionId", "Mission ID", FieldType.STRING, "missionId", AUTOCOMPLETE_DATA_TYPE));

    @JsonIgnore
    protected static List<String> NON_QUERYABLE_FIELDS =
            Arrays.asList("AUTOCOMPLETE_DATA_TYPE", "NON_QUERYABLE_FIELDS", "SPECIAL_CASE_QUERYABLE_FIELDS");

    private String id;
    private String logType;
    private String fileName;
    private String messageType;
    private Date startTimestamp;
    private Date currentTimestamp;
    // numberOfMessages in the streaming metrics refers to the number of RTP packets gathered over an interval
    @JsonIgnore
    private Long newNumberOfMessages;

    @JsonIgnore
    private Long totalNumberOfMessages;

    @JsonIgnore
    private String missionId;

    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    public Long getNewNumberOfMessages() {
        return newNumberOfMessages;
    }

    public void setNewNumberOfMessages(Long newNumberOfMessages) {
        this.newNumberOfMessages = newNumberOfMessages;
    }

    public Long getTotalNumberOfMessages() {
        return totalNumberOfMessages;
    }

    public void setTotalNumberOfMessages(Long totalNumberOfMessages) {
        this.totalNumberOfMessages = totalNumberOfMessages;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Date getCurrentTimestamp() {
        return currentTimestamp;
    }

    public void setCurrentTimestamp(Date currentTimestamp) {
        this.currentTimestamp = currentTimestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    @JsonIgnore
    public List<Class<? extends Queryable>> getQueryableSubclasses() {
        return Collections.emptyList();
    }
}
