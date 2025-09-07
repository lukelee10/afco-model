package net.acesinc.afco.model.file;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import net.acesinc.afco.model.file.pyspeech.PyspeechTranscript;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class AudioAnalysis {

    private Object pyspeech;
    private PyspeechTranscript pyspeechTranscript;

    public AudioAnalysis() {}

    public AudioAnalysis(PySpeech pyspeech) {
        this.pyspeech = pyspeech;
    }

    /**
     * Creates an AudioAnalysisObject by ingesting a JSON file.
     * The JSON file should directly contain the structure that goes under the "audioAnalysis" key,
     * meaning it should start with the "pyspeech" object.
     *
     * @param jsonFile Path to the JSON file.
     * @return An AudioAnalysisObject populated with data from the JSON file.
     * @throws IOException If there's an error reading or parsing the file.
     */
    public AudioAnalysis createFromFile(File jsonFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<PySpeech> pySpeechList = objectMapper.readValue(jsonFile, new TypeReference<List<PySpeech>>() {});

        if (pySpeechList == null || pySpeechList.isEmpty()) {
            throw new IllegalStateException(
                    "JSON file is empty or does not contain a valid PySpeech object, json file: " + jsonFile);
        }
        return new AudioAnalysis(pySpeechList.get(0));
    }

    @Override
    public String toString() {
        return "AudioAnalysisObject{" + "AudioAnalysis=" + pyspeech + '}';
    }

    public static class Score {
        @Field("label")
        @JsonProperty("label")
        public String label;

        @Field("llr")
        @JsonProperty("llr")
        public Double llr;

        @Field("score")
        @JsonProperty("score")
        public Double score;

        @Override
        public String toString() {
            return "Score{" + "label='" + label + '\'' + ", llr=" + llr + ", score=" + score + '}';
        }
    }

    public static class Result {
        @Field("model_name")
        @JsonProperty("model_name")
        public String modelName;

        @Field("model_type")
        @JsonProperty("model_type")
        public String modelType;

        @Field("scores")
        @JsonProperty("scores")
        public List<Score> scores;

        @Override
        public String toString() {
            return "Result{" + "modelName='"
                    + modelName + '\'' + ", modelType='"
                    + modelType + '\'' + ", scores="
                    + scores + '}';
        }
    }

    public static class Segment {
        @Field("speech_secs")
        @JsonProperty("speech_secs")
        public Double speechSecs;

        @Field("anomaly_score")
        @JsonProperty("anomaly_score")
        public Double anomalyScore;

        @Field("sad_marks")
        @JsonProperty("sad_marks")
        public String sadMarks;

        @Field("results")
        @JsonProperty("results")
        public List<Result> results;

        @Override
        public String toString() {
            return "Segment{" + "speechSecs="
                    + speechSecs + ", anomalyScore="
                    + anomalyScore + ", sadMarks='"
                    + sadMarks + '\'' + ", results="
                    + results + '}';
        }
    }

    public static class PySpeech {
        @Field("audiokey")
        @JsonProperty("audiokey")
        public String audioKey;

        @Field("audio_secs")
        @JsonProperty("audio_secs")
        public Long audioSecs;

        @Field("segments")
        @JsonProperty("segments")
        public List<Segment> segments;

        @Override
        public String toString() {
            return "PySpeech{" + "audiokey='"
                    + audioKey + '\'' + ", audio_secs="
                    + audioSecs + ", segments="
                    + segments + '}';
        }
    }
}
