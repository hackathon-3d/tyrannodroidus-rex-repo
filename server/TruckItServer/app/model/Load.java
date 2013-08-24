package model;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ericwood
 * Date: 8/23/13
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Load extends Model {
    @Id
    public int id;

    @Column
    private String customerId;

    @Column
    private Location pickupLocation;

    @Column
    private Location dropoffLocation;

    @Column
    private String loadDescription;

    @Column
    private Date pickupBy;

    @Column
    private Date dropoffBy;

    public int getId() {
        return id;
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
