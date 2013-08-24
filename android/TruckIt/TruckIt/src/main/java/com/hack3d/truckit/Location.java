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

    private String street;

    private String city;

    private String state;

    private int zip;
}
