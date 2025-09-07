package net.acesinc.afco.model.event;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.Date;
import lombok.Data;
import net.acesinc.afco.model.view.Views;

@Data
public class Comment {

    @JsonView(Views.FullView.class)
    private String user;

    @JsonView(Views.FullView.class)
    private Date timestamp;

    @JsonView(Views.FullView.class)
    private String comment;

    /**
     * Default constructor needed for INGESTED Items. If we don't have this, this will likely cause issues when the
     * service tries to marshall something from mongo back to the UI. The timestamp from ingested items comes from the
     * current time of the packet and this must be maintained.
     */
    public Comment() {
        super();
    }

    /**
     * This is likely what the UI needs when it calls the service. This will automatically give a timestamp of the
     * comment from a manually entered one.
     *
     * @param user a username
     * @param comment a manual operational note comment entered by operator
     */
    public Comment(String user, String comment) {
        this();
        this.user = user;
        this.comment = comment;
        this.timestamp = new Date();
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
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
