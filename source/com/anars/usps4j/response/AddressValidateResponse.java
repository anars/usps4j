package com.anars.usps4j.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="Address" maxOccurs="5"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{}AddressType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="DeliveryPoint" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="CarrierRoute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="ReturnText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "address" })
@XmlRootElement(name = "AddressValidateResponse")
public class AddressValidateResponse {

    @XmlElement(name = "Address", required = true)
    protected List<AddressValidateResponse.Address> address;

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
     * {@link AddressValidateResponse.Address }
     *
     *
     */
    public List<AddressValidateResponse.Address> getAddress() {
        if(address == null) {
            address = new ArrayList<AddressValidateResponse.Address>();
        }
        return this.address;
    }

    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{}AddressType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="DeliveryPoint" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="CarrierRoute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="ReturnText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "deliveryPoint", "carrierRoute", "returnText" })
    public static class Address
        extends com.anars.usps4j.Address {

        @XmlElement(name = "DeliveryPoint")
        protected String deliveryPoint;
        @XmlElement(name = "CarrierRoute")
        protected String carrierRoute;
        @XmlElement(name = "ReturnText")
        protected String returnText;

        /**
         * Gets the value of the deliveryPoint property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getDeliveryPoint() {
            return deliveryPoint;
        }

        /**
         * Sets the value of the deliveryPoint property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setDeliveryPoint(String value) {
            this.deliveryPoint = value;
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
            return carrierRoute;
        }

        /**
         * Sets the value of the carrierRoute property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setCarrierRoute(String value) {
            this.carrierRoute = value;
        }

        /**
         * Gets the value of the returnText property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getReturnText() {
            return returnText;
        }

        /**
         * Sets the value of the returnText property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setReturnText(String value) {
            this.returnText = value;
        }
    }
}
