package net.acesinc.afco.model.query;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import net.acesinc.afco.model.NamedField;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryField implements Comparable<QueryField> {

    private Logger log = LoggerFactory.getLogger(QueryField.class);

    private static final String AUTOCOMPLETE_URL_FORMAT = "autoc/%s?queryField=%s&sortDirection=ASC&fieldType=%s";
    private static final String DISTINCT_URL_FORMAT = "distinct/%s?queryField=%s";

    private static final List<String> NON_USER_FACING_FIELDS = Arrays.asList("id");

    private String name;
    private String key;
    private String label;
    private String autocompleteDataType;
    private FieldType fieldType;
    private UnitType units;
    private String autocompleteUrl;
    private boolean userFacing;
    private Integer priorityOrder;
    private boolean indexed;

    public QueryField(Field field) {
        super();
        this.name = field.getName();
        this.key = field.getName();
        this.label = toLabel(field.getName());
        this.userFacing = !NON_USER_FACING_FIELDS.contains(name);
        String fieldTypeString = field.getType().getSimpleName().toUpperCase();
        try {
            this.fieldType = FieldType.valueOf(fieldTypeString);
        } catch (IllegalArgumentException e) {
            log.error(String.format("Unknown FieldType [%s] for field name [%s]", fieldTypeString, name));
            this.fieldType = FieldType.UNKNOWN;
        }
    }

    public QueryField(String key) {
        super();

        // If the key contains a period, then set the name to the first word before the period.
        // For example, if the key is "characterization.radioFreqSummary.freqs", the name would "characterization".
        if (key.contains(".")) {
            this.name = key.split("\\.")[0];

            // Otherwise set the name to the same value as the key
        } else {
            this.name = key;
        }
        this.key = key;
        this.label = toLabel(this.name);
    }

    public QueryField(String name, String label, FieldType fieldType) {
        this(name, label, fieldType, name, (String) null);
    }

    public QueryField(NamedField field, String label, FieldType fieldType) {
        this(field.getFieldName(), label, fieldType);
    }

    public QueryField(String name, String label, FieldType fieldType, UnitType units) {
        this(name, label, fieldType, name, (String) null);
        this.units = units;
    }

    public QueryField(NamedField field, String label, FieldType fieldType, UnitType units) {
        this(field.getFieldName(), label, fieldType, units);
    }

    public QueryField(String name, String label, FieldType fieldType, String key) {
        this(name, label, fieldType, key, (String) null);
    }

    public QueryField(String name, String label, FieldType fieldType, String key, UnitType units) {
        this(name, label, fieldType, key, null, units);
    }

    public QueryField(String name, String label, FieldType fieldType, String key, String autocompleteDataType) {
        this(name, label, fieldType, key, autocompleteDataType, true, null);

        // If this field name is in the list of non-userfacing fields, then set userFacing to false
        if (NON_USER_FACING_FIELDS.contains(name)) {
            this.userFacing = false;
        }
    }

    public QueryField(
            NamedField field, String label, FieldType fieldType, NamedField fieldKey, String autocompleteDataType) {
        this(field.getFieldName(), label, fieldType, fieldKey.getFieldName(), autocompleteDataType);
    }

    public QueryField(
            String name, String label, FieldType fieldType, String key, String autocompleteDataType, UnitType units) {
        this(name, label, fieldType, key, autocompleteDataType);
        this.units = units;
    }

    public QueryField(
            NamedField field,
            String label,
            FieldType fieldType,
            NamedField fieldKey,
            String autocompleteDataType,
            boolean userFacing,
            UnitType units) {
        this(field.getFieldName(), label, fieldType, fieldKey.getFieldName(), autocompleteDataType, userFacing, units);
    }

    public QueryField(
            String name,
            String label,
            FieldType fieldType,
            String key,
            String autocompleteDataType,
            boolean userFacing,
            UnitType units) {
        this.name = name;
        this.key = key;
        this.label = label;
        this.autocompleteDataType = autocompleteDataType;
        this.fieldType = fieldType;
        this.units = units;
        this.userFacing = userFacing;

        if (autocompleteDataType != null) {

            /*
             * ENUM is different from STRING in that it represents a field that
             * has "small known set" of values. Rather than waiting for user input
             * to make an autocomplete query, we can leverage the api/rest/distinct
             * service to populate a select menu with that "small known set" of values
             */
            if (fieldType == FieldType.ENUM) {
                this.autocompleteUrl = String.format(DISTINCT_URL_FORMAT, autocompleteDataType, key);
            } else {
                this.autocompleteUrl = String.format(AUTOCOMPLETE_URL_FORMAT, autocompleteDataType, key, fieldType);
            }
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }
    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }
    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }
    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }
    /**
     * @return the fieldType
     */
    public FieldType getFieldType() {
        return fieldType;
    }
    /**
     * @param fieldType the fieldType to set
     */
    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }
    /**
     * @return the units
     */
    public UnitType getUnits() {
        return units;
    }
    /**
     * @param units the units to set
     */
    public void setUnits(UnitType units) {
        this.units = units;
    }
    /**
     * @return the autocompleteUrl
     */
    public String getAutocompleteUrl() {
        return autocompleteUrl;
    }
    /**
     * @return the userFacing
     */
    public boolean isUserFacing() {
        return userFacing;
    }
    /**
     * @param userFacing the userFacing to set
     */
    public void setUserFacing(boolean userFacing) {
        this.userFacing = userFacing;
    }
    /**
     * @return the priorityOrder
     */
    public Integer getPriorityOrder() {
        return priorityOrder;
    }
    /**
     * @param priorityOrder the priorityOrder to set
     */
    public void setPriorityOrder(Integer priorityOrder) {
        this.priorityOrder = priorityOrder;
    }

    public boolean isIndexed() {
        return indexed;
    }

    public void setIndexed(boolean indexed) {
        this.indexed = indexed;
    }

    /**
     * Sort queryField in alphabetical order by label using the String.compareTo
     */
    @Override
    public int compareTo(QueryField o) {
        return this.label.compareTo(o.label);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        QueryField other = (QueryField) obj;
        if (key == null) {
            if (other.key != null) return false;
        } else if (!key.equals(other.key)) return false;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        return true;
    }

    /**
     * Create a label from the given name. Split the name by camel case with a space and capitalize each word.
     * For example:
     *  input: activityAlertCount
     *  output: "Activity Alert Count"
     *
     * @param name
     * @return
     */
    public static String toLabel(String name) {
        return WordUtils.capitalize(StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(name), " "));
    }
}
