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
@XmlType(name = "", propOrder = { "_address" })
@XmlRootElement(name = "CityStateLookupResponse")
public class CityStateLookupResponse {

    @XmlElement(name = "ZipCode", required = true)
    protected Address _address;

    /**
     * Gets the value of the address property.
     */
    public Address getAddress() {
        return (_address);
    }
}