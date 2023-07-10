package eco.market.api.exceptions;



public class NoDbResponseException extends Exception {

    public NoDbResponseException() {
    }

    public NoDbResponseException(String message) {
        super(message);
    }

    public NoDbResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDbResponseException(Throwable cause) {
        super(cause);
    }

    public NoDbResponseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
