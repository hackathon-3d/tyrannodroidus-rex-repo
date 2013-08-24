package model;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.RawSql;
import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ericwood
 * Date: 8/24/13
 * Time: 6:54 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Bid extends Model {

    public static Finder<String,Bid> find = new Finder<String,Bid>(
            String.class, Bid.class
    );

    @Id
    private int id;

    @OneToOne
    private User biddingUser;

    @OneToOne
    private Load load;

    @Column
    private double price;

    @Column
    String notes;

    public static List<Bid> getBids(String userId) {
        ExpressionList<Bid> el = find
                .where()
                    .eq("load.customerId",userId);
        return el.findList();
    }

    public int getId() {
        return id;
    }

    public User getBiddingUser() {
        return biddingUser;
    }

    public void setBiddingUser(User biddingUser) {
        this.biddingUser = biddingUser;
    }

    public Load getLoad() {
        return load;
    }

    public void setLoad(Load load) {
        this.load = load;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
