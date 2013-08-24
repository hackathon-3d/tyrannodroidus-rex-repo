package com.hack3d.truckit;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ericwood
 * Date: 8/23/13
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Load {
    public int id;

    private String customerId;

    private Location pickupLocation;

    private Location dropoffLocation;

    private String loadDescription;

    private Date pickupBy;

    private Date dropoffBy;

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

    public Date getPickupBy() {
        return pickupBy;
    }

    public void setPickupBy(Date pickupBy) {
        this.pickupBy = pickupBy;
    }

    public Date getDropoffBy() {
        return dropoffBy;
    }

    public void setDropoffBy(Date dropoffBy) {
        this.dropoffBy = dropoffBy;
    }
}
