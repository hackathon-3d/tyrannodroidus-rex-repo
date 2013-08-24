package controllers;

import model.Load;
import model.Location;
import model.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ericwood
 * Date: 8/24/13
 * Time: 12:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoadController extends Controller {

    public static Result createLoad() {
        Load newLoad = Json.fromJson(request().body().asJson(),Load.class);
        Location pickupLocation = newLoad.getPickupLocation();
        pickupLocation.save();
        newLoad.setPickupLocation(pickupLocation);
        Location dropoffLocation = newLoad.getDropoffLocation();
        dropoffLocation.save();
        newLoad.setDropoffLocation(dropoffLocation);
        newLoad.save();
        return ok(Json.toJson(newLoad));
    }

    public static Result getLoads() {
        String city = request().getQueryString("city");
        String state = request().getQueryString("state");
        List<Load> lstLoads;
        // TODO for debug only
        if (city == null || state == null) {
            lstLoads =  Load.getAllLoads();
        }
        else {
            lstLoads = Load.getLoadsByCityAndState(city, state);
        }
        return ok(Json.toJson(lstLoads));
    }

    public static Result createTestLoad() {
        Load load = new Load();
        load.setCustomerId("customerId");
        load.setDropoffBy("today");
        Location pickupLocation = new Location();
        pickupLocation.setStreet("pickup st.");
        pickupLocation.setCity("Charleston");
        pickupLocation.setState("SC");
        pickupLocation.setZip(29495);
        pickupLocation.save();
        Location dropoffLocation = new Location();
        dropoffLocation.setStreet("dropoff st.");
        dropoffLocation.setCity("Charleston");
        dropoffLocation.setState("SC");
        dropoffLocation.setZip(29485);
        dropoffLocation.save();
        load.setPickupLocation(pickupLocation);
        load.setDropoffLocation(dropoffLocation);
        load.setLoadDescription("really big load");
        load.save();
        return ok(Json.toJson(load));
    }
}
