package com.anars.usps4j;

import java.math.BigInteger;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ZipCode" maxOccurs="5"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Zip5" type="{}zip5"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="USERID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "zipCode" })
@XmlRootElement(name = "CityStateLookupRequest")
public class CityStateLookupRequest {

    @XmlElement(name = "ZipCode", required = true)
    protected List<CityStateLookupRequest.ZipCode> zipCode;
    @XmlAttribute(name = "USERID")
    protected String userid;

    /**
     * Gets the value of the zipCode property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zipCode property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZipCode().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CityStateLookupRequest.ZipCode }
     *
     *
     */
    public List<CityStateLookupRequest.ZipCode> getZipCode() {
        if(zipCode == null) {
            zipCode = new ArrayList<CityStateLookupRequest.ZipCode>();
        }
        return this.zipCode;
    }

    /**
     * Gets the value of the userid property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUSERID() {
        return userid;
    }

    /**
     * Sets the value of the userid property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUSERID(String value) {
        this.userid = value;
    }

    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Zip5" type="{}zip5"/&gt;
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
    @XmlType(name = "", propOrder = { "zip5" })
    public static class ZipCode {

        @XmlElement(name = "Zip5", required = true)
        protected String zip5;
        @XmlAttribute(name = "ID")
        protected BigInteger id;

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
}
