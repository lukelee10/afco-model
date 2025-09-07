package net.acesinc.afco.model.purge;

import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

@Document(collection = "purgeRule")
public class PurgeRule {

    private String id;
    private String title;
    private String user;
    private Date dateCreated;
    private String type; // ingested or filesystem

    private long purgeOlderThanInMinutes;
    private String[] dataTypes;
    private String[] fileSystemDirectories;
    private boolean nonDistributed;
    private boolean systemRule;
    private boolean autoPurge;

    public static final String RULE_TYPE_FILESYSTEM = "FILESYSTEM";
    public static final String RULE_TYPE_MONGO = "MONGO";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPurgeOlderThanInMinutes() {
        return purgeOlderThanInMinutes;
    }

    public void setPurgeOlderThanInMinutes(long purgeOlderThanInMinutes) {
        this.purgeOlderThanInMinutes = purgeOlderThanInMinutes;
    }

    @Nullable
    public String[] getDataTypes() {
        return dataTypes;
    }

    public void setDataTypes(String[] dataTypes) {
        this.dataTypes = dataTypes;
    }

    @Nullable
    public String[] getFileSystemDirectories() {
        return fileSystemDirectories;
    }

    public void setFileSystemDirectories(String[] fileSystemDirectories) {
        this.fileSystemDirectories = fileSystemDirectories;
    }

    public boolean isNonDistributed() {
        return nonDistributed;
    }

    public void setNonDistributed(boolean nonDistributed) {
        this.nonDistributed = nonDistributed;
    }

    public boolean isSystemRule() {
        return systemRule;
    }

    public void setSystemRule(boolean systemRule) {
        this.systemRule = systemRule;
    }

    public boolean isAutoPurge() {
        return autoPurge;
    }

    public void setAutoPurge(boolean autoPurge) {
        this.autoPurge = autoPurge;
    }
}
