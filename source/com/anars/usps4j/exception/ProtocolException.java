package com.anars.usps4j.exception;

public class ProtocolException
    extends USPSException {

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public ProtocolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param cause
     */
    public ProtocolException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ProtocolException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public ProtocolException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param errorCode
     */
    public ProtocolException(String message, String code) {
        super(message, code);
    }

    /**
     */
    public ProtocolException() {
        super();
    }
}
