package com.anars.usps4j;

import java.util.logging.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for AddressType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType", propOrder = { "_firmName", "_address1", "_address2", "_city", "_state", "_urbanization", "_zip5", "_zip4", "_deliveryPoint", "_carrierRoute" })
public class Address {

    private final transient Logger _logger = Logger.getLogger(getClass().getCanonicalName());
    @XmlElement(name = "FirmName")
    protected String _firmName;
    @XmlElement(name = "Address1")
    protected String _address1 = "";
    @XmlElement(name = "Address2")
    protected String _address2 = "";
    @XmlElement(name = "City")
    protected String _city = "";
    @XmlElement(name = "State")
    @XmlSchemaType(name = "string")
    protected String _state = "";
    @XmlElement(name = "Urbanization")
    protected String _urbanization;
    @XmlElement(name = "Zip5")
    protected String _zip5 = "";
    @XmlElement(name = "Zip4")
    protected String _zip4 = "";
    @XmlElement(name = "DeliveryPoint")
    protected String _deliveryPoint;
    @XmlElement(name = "CarrierRoute")
    protected String _carrierRoute;

    /**
     * Gets the value of the firmName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFirmName() {
        return (_firmName);
    }

    /**
     * Sets the value of the firmName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFirmName(String firmName) {
        _firmName = trim(firmName);
    }

    /**
     * Gets the value of the address1 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAddress1() {
        return (_address1);
    }

    /**
     * Sets the value of the address1 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAddress1(String address1) {
        _address1 = trim(address1);
    }

    /**
     * Gets the value of the address2 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAddress2() {
        return (_address2);
    }

    /**
     * Sets the value of the address2 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAddress2(String address2) {
        _address2 = trim(address2);
    }

    /**
     * Gets the value of the city property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCity() {
        return (_city);
    }

    /**
     * Sets the value of the city property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCity(String city) {
        _city = trim(city);
    }

    /**
     * Gets the value of the state property.
     *
     * @return
     *     possible object is
     *     {@link State }
     *
     */
    public String getState() {
        return (_state);
    }

    /**
     * Sets the value of the state property.
     *
     * @param value
     *     allowed object is
     *     {@link State }
     *
     */
    public void setState(String state) {
        _state = trim(state);
    }

    /**
     * Gets the value of the urbanization property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUrbanization() {
        return (_urbanization);
    }

    /**
     * Sets the value of the urbanization property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUrbanization(String urbanization) {
        _urbanization = trim(urbanization);
    }

    /**
     * Gets the value of the zip5 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getZip5() {
        return (_zip5);
    }

    /**
     * Sets the value of the zip5 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setZip5(String zip5) {
        _zip5 = trim(zip5);
    }

    /**
     * Gets the value of the zip4 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getZip4() {
        return (_zip4);
    }

    /**
     * Sets the value of the zip4 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setZip4(String zip4) {
        _zip4 = trim(zip4);
    }

    /**
     * Gets the value of the deliveryPoint property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDeliveryPoint() {
        return (_deliveryPoint);
    }

    /**
     * Gets the value of the carrierRoute property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCarrierRoute() {
        return (_carrierRoute);
    }

    /**
     * @param text
     * @return
     */
    private String trim(String text) {
        return (text.trim().replaceAll("\\s+", " "));
    }

    public String toString(){
        String text = "[" + getClass().getCanonicalName();
        text += "[firmName=" + _firmName + "],";
        text += "[address1=" + _address1 + "],";
        text += "[address2=" + _address2 + "],";
        text += "[city=" + _city + "],";
        text += "[state=" + _state + "],";
        text += "[urbanization=" + _urbanization + "],";
        text += "[zip5=" + _zip5 + "],";
        text += "[zip4=" + _zip4 + "]]";
        return(text);
    }
}
