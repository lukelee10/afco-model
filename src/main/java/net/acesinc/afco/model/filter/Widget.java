package net.acesinc.afco.model.filter;

import java.util.Map;

public class Widget {

    private Integer id;
    private String type;
    private String title;
    private String subTitle;
    private Integer width;
    private FilterModel filterModel;
    private Map<String, Object> typeSpecificField;

    public Widget(
            Integer id,
            String type,
            String title,
            String subTitle,
            Integer width,
            FilterModel filterModel,
            Map<String, Object> typeSpecificField) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.subTitle = subTitle;
        this.width = width;
        this.filterModel = filterModel;
        this.typeSpecificField = typeSpecificField;
    }

    public Widget() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public FilterModel getFilterModel() {
        return filterModel;
    }

    public void setFilterModel(FilterModel filterModel) {
        this.filterModel = filterModel;
    }

    public Map<String, Object> getTypeSpecificField() {
        return typeSpecificField;
    }

    public void setTypeSpecificField(Map<String, Object> typeSpecificField) {
        this.typeSpecificField = typeSpecificField;
    }
}
