package com.hack3d.truckit;

import com.google.gson.annotations.Expose;

/**
 * Created with IntelliJ IDEA.
 * User: ericwood
 * Date: 8/23/13
 * Time: 11:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Job {

    @Expose
    private int id;

    @Expose
    private Load load;

    @Expose
    private String haulerId;

    @Expose
    private double price;

    @Expose
    private int rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Load getLoad() {
        return load;
    }

    public void setLoad(Load load) {
        this.load = load;
    }

    public String getHaulerId() {
        return haulerId;
    }

    public void setHaulerId(String haulerId) {
        this.haulerId = haulerId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String toString(){
        return "HaulerId:" + haulerId + " - $" + price + "   Rating: " + rating;
    }
}
