package com.hack3d.truckit;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ericwood
 * Date: 8/23/13
 * Time: 11:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {

    private String userId;

    private String customerDisplayName;

    private String haulerDisplayName;

    private String haulerState;

    private List<Integer> haulerZipCodes;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustomerDisplayName() {
        return customerDisplayName;
    }

    public void setCustomerDisplayName(String customerDisplayName) {
        this.customerDisplayName = customerDisplayName;
    }

    public String getHaulerDisplayName() {
        return haulerDisplayName;
    }

    public void setHaulerDisplayName(String haulerDisplayName) {
        this.haulerDisplayName = haulerDisplayName;
    }

    public String getHaulerState() {
        return haulerState;
    }

    public void setHaulerState(String haulerState) {
        this.haulerState = haulerState;
    }

    public List<Integer> getHaulerZipCodes() {
        return haulerZipCodes;
    }

    public void setHaulerZipCodes(List<Integer> haulerZipCodes) {
        this.haulerZipCodes = haulerZipCodes;
    }

}
