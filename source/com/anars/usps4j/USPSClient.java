package com.anars.usps4j;

import com.anars.usps4j.exception.ConnectionException;
import com.anars.usps4j.request.AddressValidateRequest;
import com.anars.usps4j.response.AddressValidateResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry public class USPSClient {

    private final static String API_URL = "https://production.shippingapis.com/ShippingAPI.dll";
    private final static QName ADDRESS_QNAME = new QName("", "Address");
    private final Logger _logger = Logger.getLogger(getClass().getCanonicalName());
    private String _userID;

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
    public Address createAddress() {
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

    /**
     * @param api
     * @param xml
     * @return
     */
    private String buildURL(String api, String xml) {
        String url = null;
        try {
            url = API_URL + String.format("?API=%s&XML=%s", URLEncoder.encode(api, "UTF-8"), URLEncoder.encode(xml, "UTF-8"));
        }
        catch(UnsupportedEncodingException unsupportedEncodingException) {
            _logger.log(Level.SEVERE, "Unable to build API URL string", unsupportedEncodingException);
        }
        return (url);
    }

    private String sendGet(String url)
        throws ConnectionException {
        StringBuffer response = new StringBuffer();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(url)).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", "USPS4J/1.0 (+https://github.com/anars/usps4j)");
            if(httpURLConnection.getResponseCode() == 200)
                throw new ConnectionException("The remote server returned " + httpURLConnection.getResponseCode());
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String line;
                while((line = bufferedReader.readLine()) != null)
                    response.append(line);
            }
            catch(IOException ioException) {
                throw new ConnectionException("An error occurred while receiving the HTTP response", ioException);
            }
            finally {
                try {
                    if(bufferedReader != null)
                        bufferedReader.close();
                }
                catch(IOException ioException) {
                    // TODO: Add catch code
                    ioe.printStackTrace();
                }
            }
        }
        catch(MalformedURLException malformedURLException) {
            throw new ConnectionException("An error occurred while attempting to contact the server", malformedURLException);
        }
        catch(ProtocolException pe) {
            // TODO: Add catch code
            pe.printStackTrace();
        }
        catch(IOException ioe) {
            // TODO: Add catch code
            ioe.printStackTrace();
        }
        return (response.toString());
    }

    /**
     * @param address
     * @param includeOptionalElements
     * @param returnCarrierRoute
     * @return
     */
    public Address validateAddress(Address address, boolean includeOptionalElements, boolean returnCarrierRoute) {
        return (validateAddresses(new Address[] { address }, includeOptionalElements, returnCarrierRoute)[0]);
    }

    /**
     * @param address
     * @return
     */
    public Address validateAddress(Address address) {
        return (validateAddresses(new Address[] { address }, false, false)[0]);
    }

    /**
     * @param addresses
     * @return
     */
    public Address[] validateAddresses(Address[] addresses) {
        return (validateAddresses(addresses, false, false));
    }

    /**
     * @param addresses
     * @param includeOptionalElements
     * @param returnCarrierRoute
     * @return
     */
    public Address[] validateAddresses(Address[] addresses, boolean includeOptionalElements, boolean returnCarrierRoute) {
        AddressValidateRequest addressValidateRequest = new AddressValidateRequest();
        addressValidateRequest.setUSERID(_userID);
        if(includeOptionalElements)
            addressValidateRequest.setIncludeOptionalElements(includeOptionalElements);
        if(returnCarrierRoute)
            addressValidateRequest.setReturnCarrierRoute(returnCarrierRoute);
        List<Address> addressList = addressValidateRequest.getAddress();
        for(int index = 0; index < addresses.length; index++) {
            addresses[index].setID(index);
            addressList.add(addresses[index]);
        }
        addressValidateRequest.setAddress(addressList);
        System.out.println(addressValidateRequest.toXML());
        System.out.println(buildURL("Verify", addressValidateRequest.toXML()));
        try {
            sendGet(buildURL("Verify", addressValidateRequest.toXML()));
        }
        catch(Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        //String apiURL = buildURL()
        return (addresses);
    }
}
