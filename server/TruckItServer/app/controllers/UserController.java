package controllers;

import model.User;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created with IntelliJ IDEA.
 * User: ericwood
 * Date: 8/24/13
 * Time: 12:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserController extends Controller {

    @BodyParser.Of(BodyParser.Json.class)
    public static Result createUser() {
        User newUser = Json.fromJson(request().body().asJson(),User.class);
        if (User.exists(newUser.getUserId())) {
            return badRequest("User already exists");
        }
        newUser.save();
        return ok();
    }

    public static Result getUser(String userId) {
        User user = User.findById(userId);
        if (user == null) {
            return notFound();
        }
        return ok(Json.toJson(user));
    }
}
