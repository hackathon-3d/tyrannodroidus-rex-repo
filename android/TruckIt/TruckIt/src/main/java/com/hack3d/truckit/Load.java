package com.hack3d.truckit;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ericwood
 * Date: 8/23/13
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Load implements Serializable{

    @Expose
    public int id;

    @Expose
    private String customerId;

    @Expose
    private Location pickupLocation;

    @Expose
    private Location dropoffLocation;

    @Expose
    private String loadDescription;

    @Expose
    private String pickupBy;

    @Expose
    private String dropoffBy;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(Location dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public String getLoadDescription() {
        return loadDescription;
    }

    public void setLoadDescription(String loadDescription) {
        this.loadDescription = loadDescription;
    }

    public String getPickupBy() {
        return pickupBy;
    }

    public void setPickupBy(String pickupBy) {
        this.pickupBy = pickupBy;
    }

    public String getDropoffBy() {
        return dropoffBy;
    }

    public void setDropoffBy(String dropoffBy) {
        this.dropoffBy = dropoffBy;
    }

    @Override
    public String toString(){
        return this.getCustomerId() + " - " + this.getPickupLocation().getStreet() + " " +
                this.getPickupLocation().getCity() + ", " + this.getPickupLocation().getState() + ", " + this.getLoadDescription();
    }
}
