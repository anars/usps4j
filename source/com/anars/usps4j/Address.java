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
package com.anars.usps4j;

import java.util.logging.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Kay Anar
 * @version 0.1
 * @since 0.1
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType", propOrder = { "_firmName", "_address1", "_address2", "_city", "_state", "_urbanization", "_zip5", "_zip4", "_deliveryPoint", "_carrierRoute" })
public class Address {

    /**
     */
    private final transient Logger _logger = Logger.getLogger(getClass().getCanonicalName());

    /**
     */
    @XmlElement(name = "FirmName")
    protected String _firmName;

    /**
     */
    @XmlElement(name = "Address1")
    protected String _address1 = "";

    /**
     */
    @XmlElement(name = "Address2")
    protected String _address2 = "";

    /**
     */
    @XmlElement(name = "City")
    protected String _city = "";

    /**
     */
    @XmlElement(name = "State")
    protected String _state = "";

    /**
     */
    @XmlElement(name = "Urbanization")
    protected String _urbanization;

    /**
     */
    @XmlElement(name = "Zip5")
    protected String _zip5 = "";

    /**
     */
    @XmlElement(name = "Zip4")
    protected String _zip4 = "";

    /**
     */
    @XmlElement(name = "DeliveryPoint")
    protected String _deliveryPoint;

    /**
     */
    @XmlElement(name = "CarrierRoute")
    protected String _carrierRoute;

    /**
     */
    public Address() {}

    /**
     * @param firmName
     * @param address1
     * @param address2
     * @param city
     * @param state
     * @param urbanization
     * @param zip5
     * @param zip4
     */
    public Address(String firmName, String address1, String address2, String city, String state, String urbanization, String zip5, String zip4) {
        _firmName = firmName;
        _address1 = address1;
        _address2 = address2;
        _city = city;
        _state = state;
        if(urbanization != null)
            _urbanization = urbanization;
        _zip5 = zip5;
        _zip4 = zip4;
    }

    /**
     * @return
     */
    public String getFirmName() {
        return (_firmName);
    }

    /**
     * @param firmName
     */
    public void setFirmName(String firmName) {
        _firmName = trim(firmName);
    }

    /**
     * @return
     */
    public String getAddress1() {
        return (_address1);
    }

    /**
     * @param address1
     */
    public void setAddress1(String address1) {
        _address1 = trim(address1);
    }

    /**
     * @return
     */
    public String getAddress2() {
        return (_address2);
    }

    /**
     * @param address2
     */
    public void setAddress2(String address2) {
        _address2 = trim(address2);
    }

    /**
     * @return
     */
    public String getCity() {
        return (_city);
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        _city = trim(city);
    }

    /**
     * @return
     */
    public String getState() {
        return (_state);
    }

    /**
     * @param state
     */
    public void setState(String state) {
        _state = trim(state);
    }

    /**
     * @return
     */
    public String getUrbanization() {
        return (_urbanization);
    }

    /**
     * @param urbanization
     */
    public void setUrbanization(String urbanization) {
        _urbanization = trim(urbanization);
    }

    /**
     * @return
     */
    public String getZip5() {
        return (_zip5);
    }

    /**
     * @param zip5
     */
    public void setZip5(String zip5) {
        _zip5 = trim(zip5);
    }

    /**
     * @return
     */
    public String getZip4() {
        return (_zip4);
    }

    /**
     * @param zip4
     */
    public void setZip4(String zip4) {
        _zip4 = trim(zip4);
    }

    /**
     * @return
     */
    public String getDeliveryPoint() {
        return (_deliveryPoint);
    }

    /**
     * @return
     */
    public String getCarrierRoute() {
        return (_carrierRoute);
    }

    /**
     * @param text
     * @return
     */
    private String trim(String text) {
        if(text == null)
            return ("");
        return (text.trim().replaceAll("\\s+", " "));
    }

    /**
     * @return
     */
    @Override public String toString() {
        String text = "[" + getClass().getCanonicalName();
        text += "[firmName=" + _firmName + "],";
        text += "[address1=" + _address1 + "],";
        text += "[address2=" + _address2 + "],";
        text += "[city=" + _city + "],";
        text += "[state=" + _state + "],";
        text += "[urbanization=" + _urbanization + "],";
        text += "[zip5=" + _zip5 + "],";
        text += "[zip4=" + _zip4 + "],";
        text += "[deliveryPoint=" + _deliveryPoint + "],";
        text += "[carrierRoute=" + _carrierRoute + "]]";
        return (text);
    }
}
