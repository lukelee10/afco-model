package net.acesinc.afco.model.filter;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "filters")
public class FilterModel {

    private String id;
    private String userId;
    private List<String> set;
    private String type;
    private String name;
    private String filters;
    private Boolean showing;
    private Boolean shared;

    public FilterModel(
            String id,
            String userId,
            List<String> set,
            String type,
            String name,
            String filters,
            Boolean showing,
            Boolean shared) {
        this.id = id;
        this.userId = userId;
        this.set = set;
        this.type = type;
        this.name = name;
        this.filters = filters;
        this.showing = showing;
        this.shared = shared;
    }

    public FilterModel() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getSet() {
        return set;
    }

    public void setSet(List<String> set) {
        this.set = set;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public Boolean getShowing() {
        return showing;
    }

    public void setShowing(Boolean showing) {
        this.showing = showing;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }
}
