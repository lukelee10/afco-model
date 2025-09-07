package net.acesinc.afco.model.filter;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "summaries")
public class Summaries {

    private String id;
    private String title;
    private String userId;
    private List<Widget> widgets;

    public Summaries(String id, String title, String userId, List<Widget> widgets) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.widgets = widgets;
    }

    public Summaries() {}

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }
}
