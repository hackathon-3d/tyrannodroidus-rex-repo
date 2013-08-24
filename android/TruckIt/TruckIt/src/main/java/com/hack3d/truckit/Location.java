package com.hack3d.truckit;

import com.google.gson.annotations.Expose;

/**
 * Created with IntelliJ IDEA.
 * User: ericwood
 * Date: 8/24/13
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class Location {

    @Expose
    public int id;

    @Expose
    private String street;

    @Expose
    private String city;

    @Expose
    private String state;

    @Expose
    private int zip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
