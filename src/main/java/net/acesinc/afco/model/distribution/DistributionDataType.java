package net.acesinc.afco.model.distribution;

public enum DistributionDataType {
    PDW("dataFile", "pdw"),
    SIGNAL("signal_event", "signal"),
    SPECIAL_SIGNAL("specialSignal", "special-signal"),
    SIRETIPEE("multiple", "siretipee"),
    COLLECTOR_NAVIGATION("platform_location", "collector-nav"),
    PRED("dataFile", "pred"),
    PBIT("dataFile", "pbit"),
    DAT("dataFile", "special-signal"),
    CEGS_XML("backgroundDf", "background-df"),
    CEGS_BINARY("null", "jicd3"),
    ACTIVITY("event", "comint-activity"),
    ALERT("event", "comint-alert"),
    ECMS("dataFile", "ecms"),
    TABI("dataFile", "tabi"),
    HB_REPORT("dataFile", "hb-report"),
    FILE("dataFile", "file");

    private String collectionName;
    private String fileNamePrefix;

    private DistributionDataType(String collectionName, String fileNamePrefix) {
        this.collectionName = collectionName;
        this.fileNamePrefix = fileNamePrefix;
    }

    /**
     * @return the collectionName
     */
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * @return the fileNamePrefix
     */
    public String getFileNamePrefix() {
        return fileNamePrefix;
    }
}
