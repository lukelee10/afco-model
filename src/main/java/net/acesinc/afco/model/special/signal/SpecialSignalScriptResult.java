package net.acesinc.afco.model.special.signal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.query.QueryField;
import org.bson.types.ObjectId;

public class SpecialSignalScriptResult implements Queryable {
    private String id;
    private String parentDataFileId = "";
    private String parentMappingId = "";
    private String user = "";
    private String scriptName = "";
    private String scriptResult = "";
    private Date timestamp;
    private int exitCode;
    private String parameters;
    private SpecialSignalScriptStatus status;
    private List<String> fileName;
    private String scriptDisplayName;
    private Set<String> invalidFields = new TreeSet<String>();

    @JsonIgnore
    protected static List<String> NON_QUERYABLE_FIELDS =
            Arrays.asList("NON_QUERYABLE_FIELDS", "SPECIAL_CASE_QUERYABLE_FIELDS");

    public SpecialSignalScriptResult() {}

    public SpecialSignalScriptResult(
            String user,
            String script,
            Date date,
            String parameters,
            SpecialSignalScriptStatus status,
            String parentMappingId,
            String parentDataFileId) {
        this.user = user;
        this.scriptName = script;
        this.timestamp = date;
        this.parameters = parameters;
        this.status = status;
        this.parentMappingId = parentMappingId;
        this.parentDataFileId = parentDataFileId;
        this.id = new ObjectId().toString();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public String getScriptResult() {
        return scriptResult;
    }

    public void setScriptResult(String scriptResult) {
        this.scriptResult = scriptResult;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getExitCode() {
        return exitCode;
    }

    public void setExitCode(int exitCode) {
        this.exitCode = exitCode;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public SpecialSignalScriptStatus getStatus() {
        return status;
    }

    public void setStatus(SpecialSignalScriptStatus status) {
        this.status = status;
    }

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

    public List<String> getFileName() {
        return fileName;
    }

    public void setFileName(List<String> fileName) {
        this.fileName = fileName;
    }

    public String getScriptDisplayName() {
        return scriptDisplayName;
    }

    public void setScriptDisplayName(String scriptDisplayName) {
        this.scriptDisplayName = scriptDisplayName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<String> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(Set<String> invalidFields) {
        this.invalidFields = invalidFields;
    }

    @Override
    public String toString() {
        return "SpecialSignalScriptResult [id=" + id + ", parentDataFileId=" + parentDataFileId + ", parentMappingId="
                + parentMappingId + ", user=" + user + ", scriptName=" + scriptName + ", scriptResult=" + scriptResult
                + ", timestamp=" + timestamp + ", exitCode=" + exitCode + ", parameters=" + parameters + ", status="
                + status + ", fileName=" + fileName + ", scriptDisplayName=" + scriptDisplayName + "]";
    }
}
