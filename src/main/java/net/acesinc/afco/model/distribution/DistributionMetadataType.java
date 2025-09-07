package net.acesinc.afco.model.distribution;

/**
 * This enum helps describe whether a distribution's related metadata will be in JSON or XML form.  Typically, this metadata will be dropped to the destination inside the form of a TAR or other archive.
 */
public enum DistributionMetadataType {
    JSON("json"),
    XML("xml");

    private String fileExtension;

    private DistributionMetadataType(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    /**
     * @return the fileExtension
     */
    public String getFileExtension() {
        return fileExtension;
    }
}
