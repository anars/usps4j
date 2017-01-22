package com.anars.usps4j.request;

import com.anars.usps4j.Address;

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
 *         &lt;element name="IncludeOptionalElements" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ReturnCarrierRoute" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="Address" type="{}Address" maxOccurs="5"/&gt;
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
@XmlType(name = "", propOrder = { "includeOptionalElements", "returnCarrierRoute", "address" })
@XmlRootElement(name = "AddressValidateRequest")
public class AddressValidateRequest {

    @XmlElement(name = "IncludeOptionalElements")
    protected Boolean includeOptionalElements;
    @XmlElement(name = "ReturnCarrierRoute")
    protected Boolean returnCarrierRoute;
    @XmlElement(name = "Address", required = true)
    protected List<Address> address;
    @XmlAttribute(name = "USERID")
    protected String userid;

    /**
     * Gets the value of the includeOptionalElements property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isIncludeOptionalElements() {
        return includeOptionalElements;
    }

    /**
     * Sets the value of the includeOptionalElements property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setIncludeOptionalElements(Boolean value) {
        this.includeOptionalElements = value;
    }

    /**
     * Gets the value of the returnCarrierRoute property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isReturnCarrierRoute() {
        return returnCarrierRoute;
    }

    /**
     * Sets the value of the returnCarrierRoute property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setReturnCarrierRoute(Boolean value) {
        this.returnCarrierRoute = value;
    }

    /**
     * Gets the value of the address property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the address property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddress().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Address }
     *
     *
     */
    public List<Address> getAddress() {
        if(address == null) {
            address = new ArrayList<Address>();
        }
        return this.address;
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
}
