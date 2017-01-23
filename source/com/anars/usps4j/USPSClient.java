package com.anars.usps4j;

import com.anars.usps4j.exception.APIException;
import com.anars.usps4j.exception.AddressException;
import com.anars.usps4j.exception.ConnectionException;
import com.anars.usps4j.exception.ProtocolException;
import com.anars.usps4j.exception.USPSException;
import com.anars.usps4j.request.AddressValidateRequest;
import com.anars.usps4j.response.AddressValidateResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry public class USPSClient {

    private final static String API_INSECURE_URL = "http://production.shippingapis.com/ShippingAPI.dll";
    private final static String API_SECURE_URL = "https://secure.shippingapis.com/ShippingAPI.dll";
    private final static QName ADDRESS_QNAME = new QName("", "Address");
    private final Logger _logger = Logger.getLogger(getClass().getCanonicalName());
    private String _userID;
    private boolean _secure;

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
    public USPSClient(String userID, boolean secure) {
        super();
        _userID = userID;
        _secure = secure;
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
     * @param secure
     */
    public void setSecure(boolean secure) {
        _secure = secure;
    }

    /**
     * @return
     */
    public boolean isSecure() {
        return (_secure);
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
     * Create an instance of {@link Address }
     *
     */
    public Address createAddressValidateResponseAddress() {
        return new Address();
    }

    /**
     * @param api
     * @param xml
     * @return
     */
    private String buildURL(String api, String xml) {
        String url = null;
        try {
            url = (_secure ? API_SECURE_URL : API_INSECURE_URL) + String.format("?API=%s&XML=%s", URLEncoder.encode(api, "UTF-8"), URLEncoder.encode(xml, "UTF-8"));
        }
        catch(UnsupportedEncodingException unsupportedEncodingException) {
            _logger.log(Level.SEVERE, "Unable to build API URL string", unsupportedEncodingException);
        }
        return (url);
    }
    private String sendGet(String url)
        throws ConnectionException {
        _logger.log(Level.FINEST, url);
        StringBuffer response = new StringBuffer();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(url)).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", "USPS4J/1.0 (+https://github.com/anars/usps4j)");
            if(httpURLConnection.getResponseCode() != 200) {
                _logger.log(Level.SEVERE, "The remote server returned " + httpURLConnection.getResponseCode(), "HTTP" + httpURLConnection.getResponseCode());
                throw new ConnectionException("The remote server returned " + httpURLConnection.getResponseCode());
            }
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String line;
                while((line = bufferedReader.readLine()) != null)
                    response.append(line);
            }
            catch(IOException ioException) {
                _logger.log(Level.SEVERE, "An error occurred while receiving the HTTP response", ioException);
                throw new ConnectionException("An error occurred while receiving the HTTP response", ioException);
            }
            finally {
                try {
                    if(bufferedReader != null)
                        bufferedReader.close();
                }
                catch(IOException ioException) {
                    _logger.log(Level.SEVERE, "An error occurred while closing response", ioException);
                    _logger.log(Level.WARNING, "An error occurred while closing response", ioException);
                }
            }
        }
        catch(Exception exception) {
            _logger.log(Level.SEVERE, "An error occurred while attempting to contact the server", exception);
            throw new ConnectionException(exception);
        }
        _logger.log(Level.FINEST, response.toString());
        return (response.toString());
    }

    /**
     * @param address
     * @return
     */
    public Address validateAddress(Address address)
        throws USPSException {
        return (validateAddress(address, false, false));
    }

    /**
     * @param addresses
     * @param includeOptionalElements
     * @param returnCarrierRoute
     * @return
     */
    public Address validateAddress(Address address, boolean includeOptionalElements, boolean returnCarrierRoute)
        throws USPSException {
        AddressValidateRequest addressValidateRequest = new AddressValidateRequest();
        addressValidateRequest.setUSERID(_userID);
        if(includeOptionalElements)
            addressValidateRequest.setIncludeOptionalElements(includeOptionalElements);
        if(returnCarrierRoute)
            addressValidateRequest.setReturnCarrierRoute(returnCarrierRoute);
        addressValidateRequest.setAddress(address);
        String responseText = sendGet(buildURL("Verify", addressValidateRequest.toXML()));
        hasError(responseText);
        AddressValidateResponse addressValidateResponse = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AddressValidateResponse.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            addressValidateResponse = (AddressValidateResponse)unmarshaller.unmarshal(new StringReader(responseText));
        }
        catch(JAXBException jaxbException) {
            throw new ProtocolException(jaxbException);
        }
        return (addressValidateResponse.getAddress());
    }

    /**
     * @param text
     * @throws APIException
     */
    private void hasError(String text)
        throws USPSException {
        if(text.indexOf("<Error>") != -1) {
            int beginIndex;
            int endIndex;
            beginIndex = text.indexOf("<Number>");
            endIndex = text.indexOf("</Number>");
            String code = null;
            if(beginIndex != -1 && endIndex != -1)
                code = text.substring(beginIndex + 8, endIndex);
            beginIndex = text.indexOf("<Description>");
            endIndex = text.indexOf("</Description>");
            String message = null;
            if(beginIndex != -1 && endIndex != -1)
                message = text.substring(beginIndex + 13, endIndex);
            throw new APIException(message, code);
        }
        else if(text.indexOf("<ReturnText>") != -1) {
            int beginIndex;
            int endIndex;
            beginIndex = text.indexOf("<ReturnText>");
            endIndex = text.indexOf("</ReturnText>");
            String message = null;
            if(beginIndex != -1 && endIndex != -1)
                message = text.substring(beginIndex + 12, endIndex);
            throw new AddressException(message);
        }
    }
}
