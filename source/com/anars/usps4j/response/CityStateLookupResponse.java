package com.anars.usps4j.response;

import com.anars.usps4j.Address;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "_address" })
@XmlRootElement(name = "CityStateLookupResponse")
public class CityStateLookupResponse {

    /**
     */
    @XmlElement(name = "ZipCode", required = true)
    protected Address _address;

    /**
     * @return
     */
    public Address getAddress() {
        return (_address);
    }
}