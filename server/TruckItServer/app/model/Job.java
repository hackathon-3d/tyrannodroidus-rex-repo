package model;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: ericwood
 * Date: 8/23/13
 * Time: 11:43 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Job extends Model {

    @Id
    private int id;

    @Column
    private Load load;

    @Column
    private String haulerId;

    @Column
    private double price;

    @Column
    private int rating;


}
