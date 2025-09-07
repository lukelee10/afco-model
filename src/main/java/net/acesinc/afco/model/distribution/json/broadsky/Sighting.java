package net.acesinc.afco.model.distribution.json.broadsky;

import com.fasterxml.jackson.annotation.*;
import java.util.Date;
import java.util.List;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({
    "id",
    "camKey",
    "signalSightingType",
    "frequencyBaseValue",
    "sensorStartTime",
    "sensorEndTime",
    "sampleRate",
    "sourceReference",
    "sigad",
    "pddg",
    "operator",
    "caseNotation",
    "modulationRateBaseValue",
    "geolocations"
})
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
/*
 * {
 *     "camKey": "418C",
 *     "signalSightingType": "MANUAL",
 *     "frequencyBaseValue": 500100000,
 *     "sensorStartTime": "2025-07-22T13:09:00Z",
 *     "sensorEndTime": "2025-07-22T13:24:00Z",
 *     "sampleRate": 500100000,
 *     "sourceReference": "http://signal/123",
 *     "sigad": "DD-01GRST8",
 *     "pddg": "X1",
 *     "operator": "dale",
 *     "caseNotation": "UXYOKGJ6JGMKX6VT",
 *     "modulationRateBaseValue": 1200,
 *     "geolocations": [
 *         {
 *             "latitude": 31.7490,
 *             "longitude": 93.0979
 *         }
 *     ]
 * }
 */
public class Sighting {
    @JsonProperty("_id")
    private String id;

    private String camKey;
    private SignalSightingType signalSightingType;
    private Double frequencyBaseValue;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date sensorStartTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date sensorEndTime;

    private Double sampleRate;
    private String sourceReference;
    private String sigad;
    private String pddg;
    private String operator;
    private String caseNotation;
    private Double modulationRateBaseValue;
    private List<GeoLocation> geolocations;

    @Getter
    @AllArgsConstructor
    public enum SignalSightingType {
        ACORN("Acorn"),
        ACORN2("Acorn 2"),
        CLEANSLATE("Cleanslate"),
        GSAL("GSAL"),
        MANUAL("Manual"),
        SENTINEL("Sentinel"),
        WIRE("Wire"),
        WITCH("Witch"),
        MARKET("Market"),
        RIVET_JOINT("Rivet Joint");

        private final String label;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GeoLocation {
        private Double latitude;
        private Double longitude;
    }
}
