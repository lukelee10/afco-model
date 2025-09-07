package net.acesinc.afco.model.exception;

/**
 * Wrapper for IllegalArgumentException for XML responses
 */
public class IllegalArgumentExceptionXml extends IllegalArgumentException {
    private static final long serialVersionUID = 4693378145743440604L;

    public IllegalArgumentExceptionXml(String msg) {
        super(msg);
    }
}
