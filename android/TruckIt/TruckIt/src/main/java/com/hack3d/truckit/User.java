package com.hack3d.truckit;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ericwood
 * Date: 8/23/13
 * Time: 11:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {

    @Expose
    private String userId;

    @Expose
    private String customerDisplayName;

    @Expose
    private String haulerDisplayName;

    @Expose
    private String haulerState;

    @Expose
    private List<Integer> haulerZipCodes;

    @Expose
    private int haulerRating;

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

    public int getHaulerRating() {
        return haulerRating;
    }

    public void setHaulerRating(int haulerRating) {
        this.haulerRating = haulerRating;
    }

}
