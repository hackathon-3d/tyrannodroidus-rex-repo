package model;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: ericwood
 * Date: 8/24/13
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Location extends Model {
    @Id
    public int id;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private int zip;
}
