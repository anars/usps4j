package com.anars.usps4j;

import com.anars.usps4j.enums;

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
@XmlType(name = "AddressType", propOrder = { "firmName", "address1", "address2", "city", "state", "urbanization", "zip5", "zip4" })
public class Address {

    @XmlElement(name = "FirmName")
    protected String firmName;
    @XmlElement(name = "Address1")
    protected String address1;
    @XmlElement(name = "Address2")
    protected String address2;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "State")
    @XmlSchemaType(name = "string")
    protected State state;
    @XmlElement(name = "Urbanization")
    protected String urbanization;
    @XmlElement(name = "Zip5")
    protected String zip5;
    @XmlElement(name = "Zip4")
    protected String zip4;
    @XmlAttribute(name = "ID")
    protected BigInteger id;

    /**
     * Gets the value of the firmName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFirmName() {
        return firmName;
    }

    /**
     * Sets the value of the firmName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFirmName(String value) {
        this.firmName = value;
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
        return address1;
    }

    /**
     * Sets the value of the address1 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAddress1(String value) {
        this.address1 = value;
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
        return address2;
    }

    /**
     * Sets the value of the address2 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAddress2(String value) {
        this.address2 = value;
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
        return city;
    }

    /**
     * Sets the value of the city property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCity(String value) {
        this.city = value;
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
        return state;
    }

    /**
     * Sets the value of the state property.
     *
     * @param value
     *     allowed object is
     *     {@link State }
     *
     */
    public void setState(State value) {
        this.state = value;
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
        return urbanization;
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
        this.urbanization = value;
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
        return zip5;
    }

    /**
     * Sets the value of the zip5 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setZip5(String value) {
        this.zip5 = value;
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
        return zip4;
    }

    /**
     * Sets the value of the zip4 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setZip4(String value) {
        this.zip4 = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setID(BigInteger value) {
        this.id = value;
    }
}
