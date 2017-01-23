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
 *         &lt;element name="Address" type="{}AddressType" maxOccurs="5"/&gt;
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
@XmlType(name = "", propOrder = { "_includeOptionalElements", "_returnCarrierRoute", "_address" })
@XmlRootElement(name = "AddressValidateRequest")
public class AddressValidateRequest {

    private final transient Logger _logger = Logger.getLogger(getClass().getCanonicalName());
    @XmlElement(name = "IncludeOptionalElements")
    protected Boolean _includeOptionalElements;
    @XmlElement(name = "ReturnCarrierRoute")
    protected Boolean _returnCarrierRoute;
    @XmlElement(name = "Address", required = true)
    protected Address _address;
    @XmlAttribute(name = "USERID")
    protected String _userid;

    /**
     * Gets the value of the includeOptionalElements property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isIncludeOptionalElements() {
        return (_includeOptionalElements);
    }

    /**
     * Sets the value of the includeOptionalElements property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setIncludeOptionalElements(Boolean includeOptionalElements) {
        _includeOptionalElements = includeOptionalElements;
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
        return (_returnCarrierRoute);
    }

    /**
     * Sets the value of the returnCarrierRoute property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setReturnCarrierRoute(Boolean returnCarrierRoute) {
        _returnCarrierRoute = returnCarrierRoute;
    }

    /**
     *
     */
    public Address getAddress() {
        return (_address);
    }

    /**
     *
     */
    public void setAddress(Address address) {
        _address = address;
    }

    /**
     *
     */
    public String getUSERID() {
        return (_userid);
    }

    /**
     *
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
