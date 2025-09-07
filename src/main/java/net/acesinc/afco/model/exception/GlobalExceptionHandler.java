package net.acesinc.afco.model.exception;

import java.util.Date;
import net.acesinc.afco.model.config.DisableComponentCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Conditional(DisableComponentCondition.class)
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handle IllegalStateException
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponse> handleIllegalStateException(IllegalStateException e) {
        ErrorResponse response =
                new ErrorResponse("Malformed Request: " + e.getMessage(), HttpStatus.BAD_REQUEST.value(), new Date());
        log.debug("IllegalStateException occurred - sending back response {}", response.toString());

        return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle IllegalArgumentException
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        ErrorResponse response = new ErrorResponse(
                "Required Field Missing or Invalid: " + e.getMessage(), HttpStatus.BAD_REQUEST.value(), new Date());
        log.debug("IllegalArgumentException occurred - sending back response {}", response.toString());

        return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle Exception
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse response = new ErrorResponse(
                "Processing Exception Occurred: " + e.getMessage(), HttpStatus.BAD_REQUEST.value(), new Date());
        log.debug("Exception occurred - sending back response {}", response.toString());

        return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle Throwable
     * @param t
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> handleThrowable(Throwable t) {
        ErrorResponse response = new ErrorResponse(
                "Processing Error Occurred: " + t.getClass() + t.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date());
        log.debug("Throwable occurred - sending back response {}", response.toString());

        return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Allowing for produces = json and xml will cause a HttpMediaTypeNotAcceptableException error
    // which appears to not get caught with the @ExceptionHandler
    // HttpMediaTypeNotAcceptableException.class can't be handled here
    // Mitigate with an XML wrapper
    /**
     * Handle IllegalStateExceptionXml
     * @param e
     * @return
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(IllegalStateExceptionXml.class)
    public ResponseEntity handleIllegalStateExceptionXml(IllegalStateExceptionXml e) {
        StringBuilder body = new StringBuilder()
                .append("<xml>Malformed Request: ")
                .append(e.getMessage())
                .append("</xml>");
        ResponseEntity response = ResponseEntity.badRequest()
                .contentType(MediaType.APPLICATION_XML)
                .body(body.toString());
        log.trace("IllegalStateExceptionXml occurred - sending back response {}", response.toString());
        return response;
    }
    /**
     * Handle IllegalArgumentExceptionXml
     * @param e
     * @return
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(IllegalArgumentExceptionXml.class)
    public ResponseEntity handleIllegalArgumentException(IllegalArgumentExceptionXml e) {
        StringBuilder body = new StringBuilder()
                .append("<xml>Required Field Missing or Invalid: ")
                .append(e.getMessage())
                .append("</xml>");
        ResponseEntity response = ResponseEntity.badRequest()
                .contentType(MediaType.APPLICATION_XML)
                .body(body.toString());
        log.trace("IllegalArgumentExceptionXml occurred - sending back response {}", response.toString());
        return response;
    }
}
