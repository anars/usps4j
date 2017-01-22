package com.anars.usps4j;

import com.anars.usps4j.request.AddressValidateRequest;
import com.anars.usps4j.response.AddressValidateResponse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry public class USPSClient {

    private final static String API_URL = "http://production.shippingapis.com/ShippingAPI.dll";
    private final static QName ADDRESS_QNAME = new QName("", "Address");
    private String _userID;

    /**
     */
    public USPSClient() {
        super();
    }

    /**
     * @param userID
     */
    public USPSClient(String userID) {
        super();
        _userID = userID;
    }

    /**
     * @param userID
     */
    public void setUserID(String userID) {
        _userID = userID;
    }

    /**
     * @return
     */
    public String getUserID() {
        return (_userID);
    }

    /**
     * Create an instance of {@link Address}
     *
     */
    public Address createAddressType() {
        return new Address();
    }

    /**
     * Create an instance of {@link JAXBElement} {@code <} {@link Address} {@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "Address")
    public JAXBElement<Address> createAddress(Address value) {
        return new JAXBElement<Address>(ADDRESS_QNAME, Address.class, null, value);
    }

    /**
     * Create an instance of {@link AddressValidateRequest }
     *
     */
    public AddressValidateRequest createAddressValidateRequest() {
        return new AddressValidateRequest();
    }

    /**
     * Create an instance of {@link AddressValidateResponse }
     *
     */
    public AddressValidateResponse createAddressValidateResponse() {
        return new AddressValidateResponse();
    }

    /**
     * Create an instance of {@link AddressValidateResponse.Address }
     *
     */
    public AddressValidateResponse.Address createAddressValidateResponseAddress() {
        return new AddressValidateResponse.Address();
    }
}
