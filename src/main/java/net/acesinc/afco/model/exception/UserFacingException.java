package net.acesinc.afco.model.exception;

/**
 * Exception that should contain a user facing message.
 */
public class UserFacingException extends RuntimeException {

    private static final long serialVersionUID = -1492602447912835734L;

    public UserFacingException(String message) {
        super(message);
    }
}
