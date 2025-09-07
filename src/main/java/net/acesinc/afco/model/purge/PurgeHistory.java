/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.purge;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.hal.HALResponse;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import net.acesinc.afco.model.query.QueryType;
import net.acesinc.afco.model.view.Views;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

/**
 *
 * @author dylankolson
 */
@Document(collection = "purgeHistory")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurgeHistory extends HALResponse implements Queryable {

    @Id
    @JsonView(Views.DefaultView.class)
    private String id;

    @JsonView(Views.DefaultView.class)
    private String partition;

    @JsonView(Views.DefaultView.class)
    private Object[] filesAffected;

    @JsonView(Views.DefaultView.class)
    private String action;

    @JsonView(Views.DefaultView.class)
    private String mappingId;

    @JsonView(Views.DefaultView.class)
    @Builder.Default
    private boolean deleteMappingId = true;

    @JsonView(Views.DefaultView.class)
    @Builder.Default
    private boolean mappingIdMissingDeleteAnyway = false;

    @JsonView(Views.DefaultView.class)
    @Builder.Default
    private List<String> dataFileIds = new ArrayList<String>();

    @JsonView(Views.DefaultView.class)
    private Date date;

    @JsonView(Views.DefaultView.class)
    private Date dateReviewed;

    @JsonView(Views.DefaultView.class)
    private String justification;

    @JsonView(Views.DefaultView.class)
    private String approver;

    @JsonView(Views.DefaultView.class)
    private String user;

    @JsonView(Views.DefaultView.class)
    private Date start;

    @JsonView(Views.DefaultView.class)
    private Date end;

    @JsonView(Views.DefaultView.class)
    private PurgeRule rule;

    @JsonView(Views.DefaultView.class)
    private QueryType type;

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "purge-history";

    @JsonIgnore
    protected static List<QueryField> SPECIAL_CASE_QUERYABLE_FIELDS = Arrays.asList(
            new QueryField("user", "User", FieldType.STRING, "user", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("approver", "Approver", FieldType.STRING, "approver", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("action", "Action", FieldType.ENUM, "action", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("partition", "Partition", FieldType.ENUM, "partition", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("type", "Type", FieldType.ENUM, "type", AUTOCOMPLETE_DATA_TYPE),
            new QueryField("mappingId", "Mapping ID", FieldType.STRING, "mappingId", null, false, null),
            new QueryField("justification", "Justification", FieldType.STRING, "justification", null, false, null));

    @JsonIgnore
    protected static List<String> NON_QUERYABLE_FIELDS = Arrays.asList(
            "AUTOCOMPLETE_DATA_TYPE", "NON_QUERYABLE_FIELDS", "SPECIAL_CASE_QUERYABLE_FIELDS", "SELF", "_links");

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getPartition() {
        return partition;
    }

    public void setPartition(String partition) {
        this.partition = partition;
    }

    @Nullable
    public Object[] getFilesAffected() {
        return filesAffected;
    }

    public void setFilesAffected(Object[] filesAffected) {
        this.filesAffected = filesAffected;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Nullable
    public String getMappingId() {
        return mappingId;
    }

    public void setMappingId(String location) {
        this.mappingId = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public PurgeRule getRule() {
        return rule;
    }

    public void setRule(PurgeRule rule) {
        this.rule = rule;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public void setDateReviewed(Date dateReviewed) {
        this.dateReviewed = dateReviewed;
    }

    public Date getDateReviewed() {
        return dateReviewed;
    }

    public QueryType getType() {
        return type;
    }

    public void setType(QueryType type) {
        this.type = type;
    }

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        return SPECIAL_CASE_QUERYABLE_FIELDS;
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

    public boolean isDeleteMappingId() {
        return deleteMappingId;
    }

    public void setDeleteMappingId(boolean deleteMappingId) {
        this.deleteMappingId = deleteMappingId;
    }

    public boolean isMappingIdMissingDeleteAnyway() {
        return mappingIdMissingDeleteAnyway;
    }

    public void setMappingIdMissingDeleteAnyway(boolean mappingIdMissingDeleteAnyway) {
        this.mappingIdMissingDeleteAnyway = mappingIdMissingDeleteAnyway;
    }

    public List<String> getDataFileIds() {
        return dataFileIds;
    }

    public void setDataFileIds(List<String> dataFileIds) {
        this.dataFileIds = dataFileIds;
    }
}
