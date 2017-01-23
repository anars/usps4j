package com.anars.usps4j;

import com.anars.usps4j.exception.USPSException;

public class Test {

    public Test() {
        super();
        USPSClient uspsClient = new USPSClient("475ANARS3122");
        Address a1 = uspsClient.createAddress();
        //a1.setAddress1("115 e 23 st");
        //a1.setZip5("10010");
         a1.setAddress1("700 boulevard east apt 2e");
        a1.setZip5("07086");
        try {
            Address x = uspsClient.validateAddress(a1);
            System.out.println(x);
        }
        catch(USPSException uspse) {
            // TODO: Add catch code
            uspse.printStackTrace();
            System.out.println(uspse.getCode());
        }
    }
    public static void main(String[] args) {
        Test test = new Test();
    }
}
