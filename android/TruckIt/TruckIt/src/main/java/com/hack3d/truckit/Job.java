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

}
