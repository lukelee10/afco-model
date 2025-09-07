package net.acesinc.afco.model.query;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UnitType {
    DAYS("days", "%Y-%m-%d", "yyyy-MM-dd", "yyyy/MM/dd"),
    DECIBELS("dB"),
    DEGREES("degrees"),
    HOURS("h", "%Y-%m-%d %H:00", "yyyy-MM-dd HH:00", "yyyy/MM/dd/HH"),
    HZ("MHz"),
    METERS("m"),
    MHZ("MHz"),
    MICROSECONDS("μsec"),
    MINUTES("min", "%Y-%m-%d %H:%M", "yyyy-MM-dd HH:mm", "yyyy/MM/dd/HH/mm"),
    MONTHS("months", "%Y-%m", "yyyy-MM", "yyyy/MM"),
    NAUTICAL_MILES("nm"),
    SECONDS("min", "%Y-%m-%d %H:%M:%S"),
    WEEKS("weeks", "%Y,%V"),
    YEARS("years", "%Y", "yyyy", "yyyy");

    /**
     * The symbol for this unit that will be used for the JSON value when returned in a service.
     */
    private String symbol;

    /**
     * The mongo date format string for the trimming a date to the given resolution. Used in the getGroupByCounts service if a groupByTimeUnit is specified.
     */
    private String resolutionDateFormatMongo;

    /**
     * The java date format string for the trimming a date to the given resolution. Used in the file system service for grouping by date.
     */
    private String resolutionDateFormatJava;

    /**
     * The java date format string used to parse a date from a date based file system directory structure.
     */
    private String fileSystemDateFormatJava;

    private UnitType(String symbol) {
        this.symbol = symbol;
    }

    private UnitType(String symbol, String resolutionDateFormatMongo) {
        this.symbol = symbol;
        this.resolutionDateFormatMongo = resolutionDateFormatMongo;
    }

    private UnitType(
            String symbol,
            String resolutionDateFormatMongo,
            String resolutionDateFormatJava,
            String fileSystemDateFormatJava) {
        this.symbol = symbol;
        this.resolutionDateFormatMongo = resolutionDateFormatMongo;
        this.resolutionDateFormatJava = resolutionDateFormatJava;
        this.fileSystemDateFormatJava = fileSystemDateFormatJava;
    }

    @JsonValue
    public String getSymbol() {
        return symbol;
    }

    public String getResolutionDateFormatMongo() {
        return resolutionDateFormatMongo;
    }

    public String getResolutionDateFormatJava() {
        return resolutionDateFormatJava;
    }

    public String getFileSystemDateFormatJava() {
        return fileSystemDateFormatJava;
    }
}
