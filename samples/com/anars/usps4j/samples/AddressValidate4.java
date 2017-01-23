package com.anars.usps4j.samples;

import com.anars.usps4j.Address;
import com.anars.usps4j.USPSClient;
import com.anars.usps4j.exception.USPSException;

public class AddressValidate4 {

    public AddressValidate4() {
        //
        Address address = new Address();
        address.setAddress1("350 5th Ave");
        address.setAddress2("Suite 4400");
        // address.setCity("New York");
        address.setState("NY");
        // address.setZip5("10118");
        //
        USPSClient uspsClient = new USPSClient("475ANARS3122");
        //
        try {
            Address addressResponse = uspsClient.addressValidate(address);
            //
            System.out.println("Verified Address :");
            System.out.println("------------------");
            System.out.println(addressResponse.getAddress2());
            System.out.println(addressResponse.getAddress1());
            System.out.print(addressResponse.getCity());
            System.out.print(", ");
            System.out.println(addressResponse.getState());
            System.out.print(addressResponse.getZip5());
            System.out.print("-");
            System.out.println(addressResponse.getZip4());
        }
        catch(USPSException uspsException) {
            uspsException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddressValidate4();
    }
}
