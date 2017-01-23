package com.anars.usps4j.exception;

/**
 */
public class AddressException
    extends USPSException {

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public AddressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param cause
     */
    public AddressException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public AddressException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public AddressException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param errorCode
     */
    public AddressException(String message, String code) {
        super(message, code);
    }

    /**
     */
    public AddressException() {
        super();
    }
}
