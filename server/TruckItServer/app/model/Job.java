package model;

import com.avaje.ebean.ExpressionList;
import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ericwood
 * Date: 8/23/13
 * Time: 11:43 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Job extends Model {

    public static Finder<String,Job> find = new Finder<String,Job>(
            String.class, Job.class
    );

    @Id
    private int id;

    @Column
    private Load load;

    @Column
    private User hauler;

    @Column
    private double price;

    @Column
    private int rating;

    public static List<Job> getJobs(String userId) {
        ExpressionList<Job> el = find
                .where()
                .eq("load.customerId",userId);
        return el.findList();
    }

    public int getId() {
        return id;
    }

    public Load getLoad() {
        return load;
    }

    public void setLoad(Load load) {
        this.load = load;
    }

    public User getHauler() {
        return hauler;
    }

    public void setHauler(User hauler) {
        this.hauler = hauler;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
