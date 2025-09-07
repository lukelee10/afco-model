package net.acesinc.afco.model.special.signal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.query.QueryField;
import net.acesinc.afco.model.spectrogram.SpectrogramMetadata;

public class SpecialSignalSpectrogramResult implements Queryable {

    private String parentDataFileId = "";
    private String parentMappingId = "";
    private String user;
    private String statusMessage;
    private Date timestamp;
    private String status;
    private String fileName;
    private SpectrogramMetadata data;
    private String collectionId;
    private String collectionName;
    private Date startTime;
    private Date stopTime;
    private String absoluteFilePath;
    private String result;
    private String jobId;

    @JsonIgnore
    protected static List<String> NON_QUERYABLE_FIELDS =
            Arrays.asList("NON_QUERYABLE_FIELDS", "SPECIAL_CASE_QUERYABLE_FIELDS");

    public SpecialSignalSpectrogramResult() {}

    public String getParentDataFileId() {
        return parentDataFileId;
    }

    public void setParentDataFileId(String parentDataFileId) {
        this.parentDataFileId = parentDataFileId;
    }

    public String getParentMappingId() {
        return parentMappingId;
    }

    public void setParentMappingId(String parentMappingId) {
        this.parentMappingId = parentMappingId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public SpectrogramMetadata getData() {
        return data;
    }

    public void setData(SpectrogramMetadata data) {
        this.data = data;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public String getAbsoluteFilePath() {
        return absoluteFilePath;
    }

    public void setAbsoluteFilePath(String absoluteFilePath) {
        this.absoluteFilePath = absoluteFilePath;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        return null;
    }

    @Override
    @JsonIgnore
    public List<String> getNonQueryableFields() {
        return NON_QUERYABLE_FIELDS;
    }

    @Override
    @JsonIgnore
    public List<Class<? extends Queryable>> getQueryableSubclasses() {
        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return "SpecialSignalSpectrogramResult{" + "parentMappingId='"
                + parentMappingId + '\'' + ", user='"
                + user + '\'' + ", statusMessage='"
                + statusMessage + '\'' + ", timestamp="
                + timestamp + ", status='"
                + status + '\'' + ", fileName='"
                + fileName + '\'' + ", data="
                + data + ", collectionId='"
                + collectionId + '\'' + ", collectionName='"
                + collectionName + '\'' + ", startTime="
                + startTime + ", stopTime="
                + stopTime + ", absoluteFilePath='"
                + absoluteFilePath + '\'' + ", result='"
                + result + '\'' + ", jobId='"
                + jobId + '\'' + '}';
    }
}
