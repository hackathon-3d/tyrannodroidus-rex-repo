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
}
