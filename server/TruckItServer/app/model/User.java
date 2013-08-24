package model;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ericwood
 * Date: 8/23/13
 * Time: 11:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class User extends Model {

    public static Finder<String,User> find = new Finder<String,User>(
            String.class, User.class
    );

    @Id
    private String userId;

    @Column
    private String customerDisplayName;

    @Column
    private String haulerDisplayName;

    @Column
    private String haulerState;

    @Column
    private List<Integer> haulerZipCodes;

    public static User findById(String id)
    {
        return find.byId(id);
    }

    public static boolean exists(String userId) {
        return find
                .where()
                .eq("userId", userId)
                .findRowCount() > 0;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustomerDisplayName() {
        return customerDisplayName;
    }

    public void setCustomerDisplayName(String customerDisplayName) {
        this.customerDisplayName = customerDisplayName;
    }

    public String getHaulerDisplayName() {
        return haulerDisplayName;
    }

    public void setHaulerDisplayName(String haulerDisplayName) {
        this.haulerDisplayName = haulerDisplayName;
    }

    public String getHaulerState() {
        return haulerState;
    }

    public void setHaulerState(String haulerState) {
        this.haulerState = haulerState;
    }

    public List<Integer> getHaulerZipCodes() {
        return haulerZipCodes;
    }

    public void setHaulerZipCodes(List<Integer> haulerZipCodes) {
        this.haulerZipCodes = haulerZipCodes;
    }

}
