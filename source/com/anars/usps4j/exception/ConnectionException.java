package com.anars.usps4j.exception;

public class ConnectionException
    extends USPSException {

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public ConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param cause
     */
    public ConnectionException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public ConnectionException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param errorCode
     */
    public ConnectionException(String message, String code) {
        super(message, code);
    }

    /**
     */
    public ConnectionException() {
        super();
    }
}
