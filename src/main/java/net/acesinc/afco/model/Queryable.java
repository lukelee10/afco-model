package net.acesinc.afco.model;

import java.util.List;
import net.acesinc.afco.model.query.QueryField;

public interface Queryable {

    /**
     * Return a list of special case QueryFields that override the default behavior
     * in the {@link net.acesinc.afco.rest.web.QueryController#queryDetails} service
     * which uses reflection by default to populate field labels. This should be used
     * to modify the label, specify autocomplete endpoint, or other special cases to
     * populate the query builder in the dashboard UI.
     *
     * @return list of QueryField objects to override defaults
     */
    public List<QueryField> getSpecialCaseQueryableFields();

    /**
     * Return a list of fields which should not be returned by the
     * {@link net.acesinc.afco.rest.web.QueryController#queryDetails} service
     * since they're not intended to be queryable in the UI.
     *
     * @return list of QueryField objects to override defaults
     */
    public List<String> getNonQueryableFields();

    /**
     * Return a list of subclasses of the implementing class that can have
     * additional properties that should be returned as part of the query
     * results when projections are used. This was added to fix bug ticket AE-6756
     * specifically for subclasses of DataFile in the dataFile collection, such as
     * {@link net.acesinc.afco.model.file.AudioDataFile}. Prior to this fix, when
     * projections were used and the subclass properties were not added to
     * {@link net.acesinc.afco.rest.service.QueryService#getQueryFieldProjections},
     * these fields were ignored in the query results which caused problems in the UI.
     *
     * @return list of Queryable subclasses
     */
    public List<Class<? extends Queryable>> getQueryableSubclasses();
}
