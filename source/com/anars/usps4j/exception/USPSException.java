/**
 * usps4j - USPS API Java Client
 * Copyright (c) 2017 Anar Software LLC <http://anars.com>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy 
 * of this software and associated documentation files (the "Software"), to deal 
 * in the Software without restriction, including without limitation the rights 
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 * copies of the Software, and to permit persons to whom the Software is 
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all 
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE 
 * SOFTWARE.
 */
package com.anars.usps4j.exception;

/**
 *
 * @author Kay Anar
 * @version 0.1
 * @since 0.1
 *
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
     * @param code
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
