package com.anars.usps4j.exception;

/**
 */
public class USPSException
    extends Exception {

    /**
     */
    private String _code;

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public USPSException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message.trim(), cause, enableSuppression, writableStackTrace);
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
        super(message.trim(), cause);
    }

    /**
     * @param message
     */
    public USPSException(String message) {
        super(message.trim());
    }

    /**
     * @param message
     * @param errorCode
     */
    public USPSException(String message, String code) {
        super(message.trim());
        _code = code;
    }

    /**
     */
    public USPSException() {
        super();
    }

    /**
     * @return
     */
    public String getCode() {
        return (_code);
    }
}
