package model;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Query;
import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ericwood
 * Date: 8/23/13
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Load extends Model {

    public static Finder<String,Load> find = new Finder<String,Load>(
            String.class, Load.class
    );

    @Id
    public int id;

    @Column
    private String customerId;

    @OneToOne
    private Location pickupLocation;

    @OneToOne
    private Location dropoffLocation;

    @Column
    private String loadDescription;

    @Column
    private Date pickupBy;

    @Column
    private Date dropoffBy;

    public static List<Load> getAllLoads() {
        return find.all();
    }

    public static List<Load> getLoadsByCityAndState(String city, String state) {
        ExpressionList<Load> el = find
                .where()
                    .disjunction()
                        .conjunction()
                            .eq("pickupLocation.city", city)
                            .eq("pickupLocation.state", state)
                            .endJunction()
                       .conjunction()
                            .eq("pickupLocation.city", city)
                            .eq("pickupLocation.state", state)
                            .endJunction();
        return el.findList();
    }

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
