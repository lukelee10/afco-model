package net.acesinc.afco.model.subject;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.Date;
import net.acesinc.afco.model.view.Views;

public class SignalValidation {

    @JsonView(Views.DashboardView.class)
    private String user;

    @JsonView(Views.MapView.class)
    private Date timestamp;

    public SignalValidation(String user) {
        super();
        this.user = user;
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
}
