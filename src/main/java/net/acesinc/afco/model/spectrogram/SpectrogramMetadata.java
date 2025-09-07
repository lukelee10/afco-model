package net.acesinc.afco.model.spectrogram;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpectrogramMetadata {

    private Boolean complex;
    private String decimationStrategy;
    private Double deltaZ;
    private Double fftLength;
    private String fileName;
    private Double imageHeight;
    private Double imageWidth;
    private Double markerOneSamples;
    private Double markerTwoSamples;
    private Double maxFreq;
    private Double minFreq;
    private Double numPlots;
    private Double sampleMultiplier;
    private Double sampleRate;
    private Double samplesPerPlot;
    private Double secondsPerPlot;
    private Double startingSample;
    private Double startingTime;
    private Integer totalSamples;
    private Boolean useHeader;
    private Boolean useMarker;
    private Boolean useSuffix;
    private Integer windowLength;
    private String windowType;
    private Double zMax;

    public Boolean getComplex() {
        return complex;
    }

    public void setComplex(Boolean complex) {
        this.complex = complex;
    }

    public String getDecimationStrategy() {
        return decimationStrategy;
    }

    public void setDecimationStrategy(String decimationStrategy) {
        this.decimationStrategy = decimationStrategy;
    }

    public Double getDeltaZ() {
        return deltaZ;
    }

    public void setDeltaZ(Double deltaZ) {
        this.deltaZ = deltaZ;
    }

    public Double getFftLength() {
        return fftLength;
    }

    public void setFftLength(Double fftLength) {
        this.fftLength = fftLength;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Double getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Double imageHeight) {
        this.imageHeight = imageHeight;
    }

    public Double getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Double imageWidth) {
        this.imageWidth = imageWidth;
    }

    public Double getMarkerOneSamples() {
        return markerOneSamples;
    }

    public void setMarkerOneSamples(Double markerOneSamples) {
        this.markerOneSamples = markerOneSamples;
    }

    public Double getMarkerTwoSamples() {
        return markerTwoSamples;
    }

    public void setMarkerTwoSamples(Double markerTwoSamples) {
        this.markerTwoSamples = markerTwoSamples;
    }

    public Double getMaxFreq() {
        return maxFreq;
    }

    public void setMaxFreq(Double maxFreq) {
        this.maxFreq = maxFreq;
    }

    public Double getMinFreq() {
        return minFreq;
    }

    public void setMinFreq(Double minFreq) {
        this.minFreq = minFreq;
    }

    public Double getNumPlots() {
        return numPlots;
    }

    public void setNumPlots(Double numPlots) {
        this.numPlots = numPlots;
    }

    public Double getSampleMultiplier() {
        return sampleMultiplier;
    }

    public void setSampleMultiplier(Double sampleMultiplier) {
        this.sampleMultiplier = sampleMultiplier;
    }

    public Double getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(Double sampleRate) {
        this.sampleRate = sampleRate;
    }

    public Double getSamplesPerPlot() {
        return samplesPerPlot;
    }

    public void setSamplesPerPlot(Double samplesPerPlot) {
        this.samplesPerPlot = samplesPerPlot;
    }

    public Double getSecondsPerPlot() {
        return secondsPerPlot;
    }

    public void setSecondsPerPlot(Double secondsPerPlot) {
        this.secondsPerPlot = secondsPerPlot;
    }

    public Double getStartingSample() {
        return startingSample;
    }

    public void setStartingSample(Double startingSample) {
        this.startingSample = startingSample;
    }

    public Double getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Double startingTime) {
        this.startingTime = startingTime;
    }

    public Integer getTotalSamples() {
        return totalSamples;
    }

    public void setTotalSamples(Integer totalSamples) {
        this.totalSamples = totalSamples;
    }

    public Boolean getUseHeader() {
        return useHeader;
    }

    public void setUseHeader(Boolean useHeader) {
        this.useHeader = useHeader;
    }

    public Boolean getUseMarker() {
        return useMarker;
    }

    public void setUseMarker(Boolean useMarker) {
        this.useMarker = useMarker;
    }

    public Boolean getUseSuffix() {
        return useSuffix;
    }

    public void setUseSuffix(Boolean useSuffix) {
        this.useSuffix = useSuffix;
    }

    public Integer getWindowLength() {
        return windowLength;
    }

    public void setWindowLength(Integer windowLength) {
        this.windowLength = windowLength;
    }

    public String getWindowType() {
        return windowType;
    }

    public void setWindowType(String windowType) {
        this.windowType = windowType;
    }

    public Double getzMax() {
        return zMax;
    }

    public void setzMax(Double zMax) {
        this.zMax = zMax;
    }

    @Override
    public String toString() {
        return "SpectrogramMetadata{" + "complex="
                + complex + ", decimationStrategy='"
                + decimationStrategy + '\'' + ", deltaZ="
                + deltaZ + ", fftLength="
                + fftLength + ", fileName='"
                + fileName + '\'' + ", imageHeight="
                + imageHeight + ", imageWidth="
                + imageWidth + ", markerOneSamples="
                + markerOneSamples + ", markerTwoSamples="
                + markerTwoSamples + ", maxFreq="
                + maxFreq + ", minFreq="
                + minFreq + ", numPlots="
                + numPlots + ", sampleMultiplier="
                + sampleMultiplier + ", sampleRate="
                + sampleRate + ", samplesPerPlot="
                + samplesPerPlot + ", secondsPerPlot="
                + secondsPerPlot + ", startingSample="
                + startingSample + ", startingTime="
                + startingTime + ", totalSamples="
                + totalSamples + ", useHeader="
                + useHeader + ", useMarker="
                + useMarker + ", useSuffix="
                + useSuffix + ", windowLength="
                + windowLength + ", windowType='"
                + windowType + '\'' + ", zMax="
                + zMax + '}';
    }
}
