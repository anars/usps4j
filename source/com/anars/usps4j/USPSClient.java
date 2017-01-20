package com.anars.usps4j;

public class USPSClient {

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
}
