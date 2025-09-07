package net.acesinc.afco.model.exception;

/**
 * Wrapper for IllegalStateException for XML responses
 */
public class IllegalStateExceptionXml extends IllegalStateException {
    private static final long serialVersionUID = 1876384765790042903L;

    public IllegalStateExceptionXml(String msg) {
        super(msg);
    }
}
