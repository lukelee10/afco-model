package net.acesinc.afco.model.event.signal;

public class SignalOfInterestRange {

    private Double min;
    private Double max;

    /**
     * Return true if the given value is great than or equal to the min value and
     * less than or equal to the max value.
     *
     * @param value The value to test against the min and max
     * @return Return true if the given value is within the range, otherwise returns false
     */
    public boolean isWithinRange(Double value) {
        if (value >= min && value <= max) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the min
     */
    public Double getMin() {
        return min;
    }
    /**
     * @param min the min to set
     */
    public void setMin(Double min) {
        this.min = min;
    }
    /**
     * @return the max
     */
    public Double getMax() {
        return max;
    }
    /**
     * @param max the max to set
     */
    public void setMax(Double max) {
        this.max = max;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((max == null) ? 0 : max.hashCode());
        result = prime * result + ((min == null) ? 0 : min.hashCode());
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
        SignalOfInterestRange other = (SignalOfInterestRange) obj;
        if (max == null) {
            if (other.max != null) return false;
        } else if (!max.equals(other.max)) return false;
        if (min == null) {
            if (other.min != null) return false;
        } else if (!min.equals(other.min)) return false;
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SignalOfInterestRange [min=" + min + ", max=" + max + "]";
    }
}
