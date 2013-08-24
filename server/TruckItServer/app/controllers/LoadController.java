package controllers;

import model.Load;
import model.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
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
        return ok();
    }

    public static Result getLoads(String haulerUserId) {
        List<Load> lstLoads = new ArrayList<Load>();
        return ok(Json.toJson(lstLoads));
    }
}
