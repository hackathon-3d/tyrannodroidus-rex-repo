package controllers;

import model.Job;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created with IntelliJ IDEA.
 * User: ericwood
 * Date: 8/24/13
 * Time: 8:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class JobController extends Controller {

    public static Result getJobs(String userId)  {
        return ok(Json.toJson(Job.getJobs(userId)));
    }

    public static Result createJob() {
        Job newJob = Json.fromJson(request().body().asJson(), Job.class);
        newJob.save();
        return ok(Json.toJson(newJob));
    }

    public static Result updateJob() {
        Job job = Json.fromJson(request().body().asJson(), Job.class);
        job.update();
        return ok(Json.toJson(job));
    }
}
