package net.acesinc.afco.model.asip.time;

/**
 * Fancy ASIP sensor time precision
 */
public class StdTime {
    private Long seconds;
    private Long frac;

    public Long getSeconds() {
        return seconds;
    }

    public void setSeconds(Long seconds) {
        this.seconds = seconds;
    }

    public Long getFrac() {
        return frac;
    }

    public void setFrac(Long frac) {
        this.frac = frac;
    }
}
