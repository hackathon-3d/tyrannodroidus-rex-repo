package com.hack3d.truckit;

import com.google.gson.annotations.Expose;

/**
 * Created by ericwood on 8/24/13.
 */
public class Bid {
    @Expose
    private int id;

    @Expose
    private User biddingUser;

    @Expose
    private Load load;

    @Expose
    private double price;

    @Expose
    String notes;

    public int getId() {
        return id;
    }

    public User getBiddingUser() {
        return biddingUser;
    }

    public void setBiddingUser(User biddingUser) {
        this.biddingUser = biddingUser;
    }

    public Load getLoad() {
        return load;
    }

    public void setLoad(Load load) {
        this.load = load;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String toString(){
        return biddingUser.getHaulerDisplayName() + " - $" + price;
    }
}
