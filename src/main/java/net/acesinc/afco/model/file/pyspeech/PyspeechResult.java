package net.acesinc.afco.model.file.pyspeech;

import com.fasterxml.jackson.annotation.JsonView;
import net.acesinc.afco.model.view.Views;

public class PyspeechResult {

    @JsonView(Views.DashboardView.class)
    private String label;

    @JsonView(Views.DashboardView.class)
    private Double score;

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
     * @return the score
     */
    public Double getScore() {
        return score;
    }
    /**
     * @param score the score to set
     */
    public void setScore(Double score) {
        this.score = score;
    }
}
