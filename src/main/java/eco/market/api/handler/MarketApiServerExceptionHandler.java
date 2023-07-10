package eco.market.api.handler;

import eco.market.api.exceptions.NoDbResponseException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MarketApiServerExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarketApiServerExceptionHandler.class);

    public MarketApiServerExceptionHandler() {
    }

    @ExceptionHandler({UnsupportedOperationException.class})
    protected ResponseEntity<Object> UnsupportedOperationException(Exception ex, WebRequest request) {
        LOGGER.error("UnsupportedOperationException: " + request.toString());
        LOGGER.error(ex.getMessage());
        final Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());

        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.NOT_IMPLEMENTED, request);
    }

    @ExceptionHandler({NoDbResponseException.class})
    protected ResponseEntity<Object> NoDbResponseException(Exception ex, WebRequest request) {
        LOGGER.error("InternalError: " + request.toString());
        LOGGER.error(ex.getMessage());
        final Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());

        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({InternalError.class})
    protected ResponseEntity<Object> InternalError(Exception ex, WebRequest request) {
        LOGGER.error("InternalError: " + request.toString());
        LOGGER.error(ex.getMessage());
        final Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());

        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

}
