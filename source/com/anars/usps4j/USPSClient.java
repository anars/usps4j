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
package com.anars.usps4j;

import com.anars.usps4j.exception.APIException;
import com.anars.usps4j.exception.AddressException;
import com.anars.usps4j.exception.ConnectionException;
import com.anars.usps4j.exception.ProtocolException;
import com.anars.usps4j.exception.USPSException;
import com.anars.usps4j.request.AddressValidateRequest;
import com.anars.usps4j.request.CityStateLookupRequest;
import com.anars.usps4j.request.ZipCodeLookupRequest;
import com.anars.usps4j.response.AddressValidateResponse;
import com.anars.usps4j.response.CityStateLookupResponse;
import com.anars.usps4j.response.ZipCodeLookupResponse;

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
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRegistry;

/**
 *
 * @author Kay Anar
 * @version 0.1
 * @since 0.1
 *
 */
@XmlRegistry public class USPSClient {

    /**
     */
    public static final double VERSION = 0;

    /**
     */
    public static final double BUILD = 0;

    /**
     */
    private final static String API_INSECURE_URL = "http://production.shippingapis.com/ShippingAPI.dll";

    /**
     */
    private final static String API_SECURE_URL = "https://secure.shippingapis.com/ShippingAPI.dll";

    /**
     */
    private final Logger _logger = Logger.getLogger(getClass().getCanonicalName());

    /**
     */
    private String _userID;

    /**
     */
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
     * @param secure
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

    /**
     * @param url
     * @return
     * @throws ConnectionException
     */
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

    /**
     * @param firmName
     * @param address1
     * @param address2
     * @param city
     * @param state
     * @param urbanization
     * @param zip5
     * @param zip4
     * @param deliveryPoint
     * @param carrierRoute
     * @return
     * @throws USPSException
     */
    public Address addressValidate(String firmName, String address1, String address2, String city, String state, String urbanization, String zip5, String zip4, boolean deliveryPoint, boolean carrierRoute)
        throws USPSException {
        return (addressValidate(new Address(firmName, address1, address2, city, state, urbanization, zip5, zip4), deliveryPoint, carrierRoute));
    }

    /**
     * @param firmName
     * @param address1
     * @param address2
     * @param city
     * @param state
     * @param urbanization
     * @param zip5
     * @param zip4
     * @return
     * @throws USPSException
     */
    public Address addressValidate(String firmName, String address1, String address2, String city, String state, String urbanization, String zip5, String zip4)
        throws USPSException {
        return (addressValidate(new Address(firmName, address1, address2, city, state, urbanization, zip5, zip4), false, false));
    }

    /**
     * @param address
     * @return
     */
    public Address addressValidate(Address address)
        throws USPSException {
        return (addressValidate(address, false, false));
    }

    /**
     * @param addresses
     * @param includeOptionalElements
     * @param returnCarrierRoute
     * @return
     */
    public Address addressValidate(Address address, boolean includeOptionalElements, boolean returnCarrierRoute)
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
     * @param firmName
     * @param address1
     * @param address2
     * @param city
     * @param state
     * @param urbanization
     * @return
     * @throws USPSException
     */
    public Address zipCodeLookup(String firmName, String address1, String address2, String city, String state, String urbanization)
        throws USPSException {
        return (zipCodeLookup(new Address(firmName, address1, address2, city, state, urbanization, null, null)));
    }

    /**
     * @param address
     * @return
     * @throws USPSException
     */
    public Address zipCodeLookup(Address address)
        throws USPSException {
        ZipCodeLookupRequest zipCodeLookupRequest = new ZipCodeLookupRequest();
        zipCodeLookupRequest.setUSERID(_userID);
        zipCodeLookupRequest.setAddress(address);
        String responseText = sendGet(buildURL("ZipCodeLookup", zipCodeLookupRequest.toXML()));
        hasError(responseText);
        ZipCodeLookupResponse zipCodeLookupResponse = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ZipCodeLookupResponse.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            zipCodeLookupResponse = (ZipCodeLookupResponse)unmarshaller.unmarshal(new StringReader(responseText));
        }
        catch(JAXBException jaxbException) {
            throw new ProtocolException(jaxbException);
        }
        return (zipCodeLookupResponse.getAddress());
    }

    /**
     * @param zip5
     * @return
     * @throws USPSException
     */
    public Address cityStateLookup(String zip5)
        throws USPSException {
        CityStateLookupRequest cityStateLookupRequest = new CityStateLookupRequest();
        cityStateLookupRequest.setUSERID(_userID);
        cityStateLookupRequest.setZipCode(zip5);
        ;
        String responseText = sendGet(buildURL("CityStateLookup", cityStateLookupRequest.toXML()));
        hasError(responseText);
        CityStateLookupResponse cityStateLookupResponse = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CityStateLookupResponse.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            cityStateLookupResponse = (CityStateLookupResponse)unmarshaller.unmarshal(new StringReader(responseText));
        }
        catch(JAXBException jaxbException) {
            throw new ProtocolException(jaxbException);
        }
        return (cityStateLookupResponse.getAddress());
    }
}
