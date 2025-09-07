package net.acesinc.afco.model.distribution;

public enum DistributionStatus {
    READY,
    SUCCESS,
    FAILURE,
    IN_PROGRESS,
    WAITING,
    // For Distribution that requires additional processing, like TOXICSMOKE
    PREPARING,
    PREPARED,
    FILE_GENERATED,
    NO_FILES_GENERATED,
    TRANSMITTING,
    TRANSMITTED,
    TRANSMIT_FAILED
}
