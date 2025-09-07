package net.acesinc.afco.model.changelog;

import java.util.Date;
import net.acesinc.afco.model.NamedField;

public class ChangeLog {

    private String field;
    private Object newValue;
    private Object oldValue;
    private Date timestamp;
    private String user;

    public ChangeLog() {
        super();
    }

    public ChangeLog(String field, String user, Object newValue, Object oldValue) {
        super();
        this.field = field;
        this.user = user;
        this.timestamp = new Date();
        this.newValue = newValue;
        this.oldValue = oldValue;
    }

    public ChangeLog(String field, String user, Object newValue) {
        this(field, user, newValue, null);
    }

    public ChangeLog(NamedField field, String user, Object newValue, Object oldValue) {
        this(field.getFieldName(), user, newValue, oldValue);
    }

    /**
     * @return the field
     */
    public String getField() {
        return field;
    }
    /**
     * @param field the field to set
     */
    public void setField(String field) {
        this.field = field;
    }
    /**
     * @return the newValue
     */
    public Object getNewValue() {
        return newValue;
    }
    /**
     * @param newValue the newValue to set
     */
    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }
    /**
     * @return the oldValue
     */
    public Object getOldValue() {
        return oldValue;
    }
    /**
     * @param oldValue the oldValue to set
     */
    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }
    /**
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }
    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }
    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ChangeLog [field=" + field + ", newValue=" + newValue + ", oldValue=" + oldValue + ", timestamp="
                + timestamp + ", user=" + user + "]";
    }
}
