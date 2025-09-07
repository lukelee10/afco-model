/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.acesinc.afco.model.ProcessorResult;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import net.acesinc.afco.model.view.Views;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author andrewserff
 */
public class AADFEvent extends Event {
    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "event";

    @JsonView(Views.DefaultView.class)
    private String msnNo;

    @JsonView(Views.DefaultView.class)
    private String idNo;

    @Field("core-site")
    @JsonView(Views.DefaultView.class)
    private String coreSite;

    @JsonView(Views.FullView.class)
    private String sourcePosition;

    @JsonView(Views.DefaultView.class)
    private String operatorIdentifier;

    @Field("datamsg")
    @JsonView(Views.DefaultView.class)
    private String dataMsg;

    @JsonView(Views.DefaultView.class)
    private String lineText;

    @JsonView(Views.FullView.class)
    private List<ProcessorResult> languageProcessorResults = new ArrayList<>();

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        List<QueryField> specialCaseQueryableFields = new ArrayList<>(Arrays.asList(
                new QueryField("coreSite", "Core Site", FieldType.ENUM, "core-site", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("dataMsg", "Data Message", FieldType.STRING, "datamsg", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("lineText", "Line Text", FieldType.STRING, "lineText", null, false, null),
                new QueryField("idNo", "IDNO", FieldType.STRING, "idNo", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("msnNo", "Mission No", FieldType.STRING, "msnNo", AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "operatorIdentifier",
                        "Operator Identifier",
                        FieldType.STRING,
                        "operatorIdentifier",
                        AUTOCOMPLETE_DATA_TYPE),
                new QueryField(
                        "sourcePosition",
                        "Source Posiion",
                        FieldType.STRING,
                        "sourcePosition",
                        AUTOCOMPLETE_DATA_TYPE)));
        specialCaseQueryableFields.addAll(SPECIAL_CASE_QUERYABLE_FIELDS);

        return specialCaseQueryableFields;
    }

    @Override
    @JsonIgnore
    public List<String> getNonQueryableFields() {
        List<String> nonQueryableFields = new ArrayList<>(Arrays.asList("languageProcessorResults"));
        nonQueryableFields.addAll(NON_QUERYABLE_FIELDS);

        return nonQueryableFields;
    }

    /**
     * @return the msnNo
     */
    public String getMsnNo() {
        return msnNo;
    }

    /**
     * @param msnNo the msnNo to set
     */
    public void setMsnNo(String msnNo) {
        this.msnNo = msnNo;
    }

    /**
     * @return the idNo
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * @param idNo the idNo to set
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    /**
     * @return the coreSite
     */
    public String getCoreSite() {
        return coreSite;
    }

    /**
     * @param coreSite the coreSite to set
     */
    public void setCoreSite(String coreSite) {
        this.coreSite = coreSite;
    }

    /**
     * @return the sourcePosition
     */
    public String getSourcePosition() {
        return sourcePosition;
    }

    /**
     * @param sourcePosition the sourcePosition to set
     */
    public void setSourcePosition(String sourcePosition) {
        this.sourcePosition = sourcePosition;
    }

    /**
     * @return the dataMsg
     */
    public String getDataMsg() {
        return dataMsg;
    }

    /**
     * @param dataMsg the dataMsg to set
     */
    public void setDataMsg(String dataMsg) {
        this.dataMsg = dataMsg;
    }

    /**
     * @return the lineText
     */
    public String getLineText() {
        return lineText;
    }

    /**
     * @param lineText the lineText to set
     */
    public void setLineText(String lineText) {
        this.lineText = lineText;
    }

    /**
     * @return the languageProcessorResults
     */
    public List<ProcessorResult> getLanguageProcessorResults() {
        return languageProcessorResults;
    }

    /**
     * @param languageProcessorResults the languageProcessorResults to set
     */
    public void setLanguageProcessorResults(List<ProcessorResult> languageProcessorResults) {
        this.languageProcessorResults = languageProcessorResults;
    }

    /**
     * @return the operatorIdentifier
     */
    public String getOperatorIdentifier() {
        return operatorIdentifier;
    }

    /**
     * @param operatorIdentifier the operatorIdentifier to set
     */
    public void setOperatorIdentifier(String operatorIdentifier) {
        this.operatorIdentifier = operatorIdentifier;
    }
}
