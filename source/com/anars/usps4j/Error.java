package com.anars.usps4j;

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
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Source" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HelpFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HelpContext" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "number", "source", "description", "helpFile", "helpContext" })
@XmlRootElement(name = "Error")
public class Error {

    @XmlElement(name = "Number")
    protected String number;
    @XmlElement(name = "Source")
    protected String source;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "HelpFile")
    protected String helpFile;
    @XmlElement(name = "HelpContext")
    protected String helpContext;

    /**
     * Gets the value of the number property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the source property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the helpFile property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHelpFile() {
        return helpFile;
    }

    /**
     * Sets the value of the helpFile property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHelpFile(String value) {
        this.helpFile = value;
    }

    /**
     * Gets the value of the helpContext property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHelpContext() {
        return helpContext;
    }

    /**
     * Sets the value of the helpContext property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHelpContext(String value) {
        this.helpContext = value;
    }
}
