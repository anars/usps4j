package com.anars.usps4j;

import com.anars.usps4j.enums.State;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for AddressType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AddressType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FirmName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Address1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Address2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="State" type="{}state" minOccurs="0"/&gt;
 *         &lt;element name="Urbanization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Zip5" type="{}zip5" minOccurs="0"/&gt;
 *         &lt;element name="Zip4" type="{}zip4" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType", propOrder = { "_firmName", "_address1", "_address2", "_city", "_state", "_urbanization", "_zip5", "_zip4" })
public class Address {

    @XmlElement(name = "FirmName")
    protected String _firmName;
    @XmlElement(name = "Address1")
    protected String _address1;
    @XmlElement(name = "Address2")
    protected String _address2;
    @XmlElement(name = "City")
    protected String _city;
    @XmlElement(name = "State")
    @XmlSchemaType(name = "string")
    protected State _state;
    @XmlElement(name = "Urbanization")
    protected String _urbanization;
    @XmlElement(name = "Zip5")
    protected String _zip5;
    @XmlElement(name = "Zip4")
    protected String _zip4;
    @XmlAttribute(name = "ID")
    protected int _id;

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
    public State getState() {
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
    public void setState(State state) {
        _state = state;
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
    public void setUrbanization(String value) {
        this._urbanization = value;
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
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public int getID() {
        return (_id);
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setID(int id) {
        _id = id;
    }

    /**
     * @param text
     * @return
     */
    private String trim(String text) {
        return (text.trim().replaceAll("\\s+", " "));
    }
}
