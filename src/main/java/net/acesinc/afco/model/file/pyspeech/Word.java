package net.acesinc.afco.model.file.pyspeech;

public class Word {

    private String word;
    private Double start;
    private Double stop;
    private Double score;

    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }
    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.word = word;
    }
    /**
     * @return the start
     */
    public Double getStart() {
        return start;
    }
    /**
     * @param start the start to set
     */
    public void setStart(Double start) {
        this.start = start;
    }
    /**
     * @return the stop
     */
    public Double getStop() {
        return stop;
    }
    /**
     * @param stop the stop to set
     */
    public void setStop(Double stop) {
        this.stop = stop;
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
