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
package com.anars.usps4j.request;

import com.anars.usps4j.Address;

import java.io.StringWriter;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Kay Anar
 * @version 0.1
 * @since 0.1
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "_includeOptionalElements", "_returnCarrierRoute", "_address" })
@XmlRootElement(name = "AddressValidateRequest")
public class AddressValidateRequest {

    /**
     */
    private final transient Logger _logger = Logger.getLogger(getClass().getCanonicalName());

    /**
     */
    @XmlElement(name = "IncludeOptionalElements")
    protected Boolean _includeOptionalElements;

    /**
     */
    @XmlElement(name = "ReturnCarrierRoute")
    protected Boolean _returnCarrierRoute;

    /**
     */
    @XmlElement(name = "Address", required = true)
    protected Address _address;

    /**
     */
    @XmlAttribute(name = "USERID")
    protected String _userid;

    /**
     * @return
     */
    public Boolean isIncludeOptionalElements() {
        return (_includeOptionalElements);
    }

    /**
     * @param includeOptionalElements
     */
    public void setIncludeOptionalElements(Boolean includeOptionalElements) {
        _includeOptionalElements = includeOptionalElements;
    }

    /**
     * @return
     */
    public Boolean isReturnCarrierRoute() {
        return (_returnCarrierRoute);
    }

    /**
     * @param returnCarrierRoute
     */
    public void setReturnCarrierRoute(Boolean returnCarrierRoute) {
        _returnCarrierRoute = returnCarrierRoute;
    }

    /**
     * @return
     */
    public Address getAddress() {
        return (_address);
    }

    /**
     * @param address
     */
    public void setAddress(Address address) {
        _address = address;
    }

    /**
     * @return
     */
    public String getUSERID() {
        return (_userid);
    }

    /**
     * @param userid
     */
    public void setUSERID(String userid) {
        _userid = userid;
    }

    /**
     * @return
     */
    public String toXML() {
        String xml = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AddressValidateRequest.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(this, stringWriter);
            xml = stringWriter.toString();
        }
        catch(PropertyException propertyException) {
            _logger.log(Level.SEVERE, "Unable to convert to XML string", propertyException);
        }
        catch(JAXBException jaxbException) {
            _logger.log(Level.SEVERE, "Unable to convert to XML string", jaxbException);
        }
        return (xml);
    }
}
