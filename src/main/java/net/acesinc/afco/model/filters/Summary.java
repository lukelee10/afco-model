package net.acesinc.afco.model.filters;

import java.util.Map;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "summaries")
public class Summary {

    private String id;
    private String type;
    private String title;
    private String subtitle;
    private Integer width;
    private Map<String, Object> typeSpecificField;
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Map<String, Object> getTypeSpecificField() {
        return typeSpecificField;
    }

    public void setTypeSpecificField(Map<String, Object> typeSpecificField) {
        this.typeSpecificField = typeSpecificField;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Summary(
            String id,
            String type,
            String title,
            String subtitle,
            Integer width,
            Map<String, Object> typeSpecificField,
            String userId) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.subtitle = subtitle;
        this.width = width;
        this.typeSpecificField = typeSpecificField;
        this.userId = userId;
    }

    public Summary() {}
}
