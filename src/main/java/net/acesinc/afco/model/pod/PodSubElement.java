package net.acesinc.afco.model.pod;

/**
 * A pod sub element bean that is an element of an array within PodMeta
 * Not used because POD files have a significant amount of data, could be used for future.
 */
public class PodSubElement {
    private Long toa;
    private Double pf;
    private Double pfDev;
    private Double chirp;
    private Double pw;
    private Double pa;
    private Double snr;
    private Double pulseId;
    private Integer targetId;

    public Long getToa() {
        return toa;
    }

    public void setToa(Long toa) {
        this.toa = toa;
    }

    public Double getPf() {
        return pf;
    }

    public void setPf(Double pf) {
        this.pf = pf;
    }

    public Double getPfDev() {
        return pfDev;
    }

    public void setPfDev(Double pfDev) {
        this.pfDev = pfDev;
    }

    public Double getChirp() {
        return chirp;
    }

    public void setChirp(Double chirp) {
        this.chirp = chirp;
    }

    public Double getPw() {
        return pw;
    }

    public void setPw(Double pw) {
        this.pw = pw;
    }

    public Double getPa() {
        return pa;
    }

    public void setPa(Double pa) {
        this.pa = pa;
    }

    public Double getSnr() {
        return snr;
    }

    public void setSnr(Double snr) {
        this.snr = snr;
    }

    public Double getPulseId() {
        return pulseId;
    }

    public void setPulseId(Double pulseId) {
        this.pulseId = pulseId;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }
}
