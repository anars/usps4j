package com.anars.usps4j.response;

import com.anars.usps4j.Address;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for anonymous complex type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "address" })
@XmlRootElement(name = "AddressValidateResponse")
public class AddressValidateResponse {

    @XmlElement(name = "Address", required = true)
    protected Address address;

    /**
     * Gets the value of the address property.
     */
    public Address getAddress() {
        return this.address;
    }
}
