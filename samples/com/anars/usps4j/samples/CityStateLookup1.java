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
package com.anars.usps4j.samples;

import com.anars.usps4j.Address;
import com.anars.usps4j.USPSClient;
import com.anars.usps4j.exception.USPSException;

public class CityStateLookup1 {

    public CityStateLookup1() {
        USPSClient uspsClient = new USPSClient("123XXX321");
        //
        try {
            Address addressResponse = uspsClient.cityStateLookup("10118");
            //
            System.out.println("City, State :");
            System.out.println("-------------");
            System.out.print(addressResponse.getCity());
            System.out.print(", ");
            System.out.println(addressResponse.getState());
            System.out.println(addressResponse.getZip5());
        }
        catch(USPSException uspsException) {
            uspsException.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new CityStateLookup1();
    }
}
