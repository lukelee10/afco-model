package net.acesinc.afco.model.location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.*;
import lombok.experimental.SuperBuilder;
import net.acesinc.afco.model.Queryable;
import net.acesinc.afco.model.query.FieldType;
import net.acesinc.afco.model.query.QueryField;
import net.acesinc.afco.model.query.UnitType;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Getter
@Data
@AllArgsConstructor
@Document(collection = "backgroundDf")
public class BackgroundDf extends LobLocation implements Queryable {
    private Double freq;
    private List<String> callsigns;
    private String idno; // new identifier not related to any other IDNOs

    @JsonIgnore
    private static final String AUTOCOMPLETE_DATA_TYPE = "background-df";

    @Override
    @JsonIgnore
    public List<QueryField> getSpecialCaseQueryableFields() {
        List<QueryField> specialCaseQueryableFields = new ArrayList<QueryField>(Arrays.asList(
                new QueryField("bw", "Bandwidth", FieldType.DOUBLE, UnitType.MHZ),
                new QueryField("collectorId", "Platform ID", FieldType.STRING, "collectorId", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("freq", "Frequency", FieldType.DOUBLE, UnitType.MHZ),
                new QueryField("idno", "IDNO", FieldType.STRING, "idno", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("ingestSite", "Ingest Site", FieldType.ENUM, "ingestSite", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("missionId", "Mission No", FieldType.STRING, "missionId", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("pddg", "PDDG", FieldType.ENUM, "pddg", AUTOCOMPLETE_DATA_TYPE),
                new QueryField("sigad", "Sigad", FieldType.ENUM, "sigad", AUTOCOMPLETE_DATA_TYPE)));
        specialCaseQueryableFields.addAll(SPECIAL_CASE_QUERYABLE_FIELDS);

        return specialCaseQueryableFields;
    }

    @Override
    @JsonIgnore
    public List<String> getNonQueryableFields() {
        List<String> nonQueryableFields = new ArrayList<String>(Arrays.asList(
                "callsigns",
                "languages",
                "lobType",
                "sensorId",
                "parentId",
                "AUTOCOMPLETE_DATA_TYPE",
                "NON_QUERYABLE_FIELDS",
                "SPECIAL_CASE_QUERYABLE_FIELDS",
                "classification"));
        nonQueryableFields.addAll(nonQueryableFields);

        return nonQueryableFields;
    }

    public BackgroundDf() {
        setLobType(LobType.BACKGROUND_DF);
    }
}
