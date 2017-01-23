package com.anars.usps4j.exception;

/**
 */
public class APIException
    extends USPSException {

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public APIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param cause
     */
    public APIException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public APIException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public APIException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param errorCode
     */
    public APIException(String message, String code) {
        super(message, code);
    }

    /**
     */
    public APIException() {
        super();
    }
}
