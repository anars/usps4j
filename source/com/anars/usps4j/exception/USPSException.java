package com.anars.usps4j.exception;

public class USPSException
    extends Exception {

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public USPSException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param cause
     */
    public USPSException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public USPSException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public USPSException(String message) {
        super(message);
    }

    /**
     */
    public USPSException() {
        super();
    }
}
