package com.hack3d.truckit;

import com.google.gson.Gson;

/**
 * Created by ericwood on 8/24/13.
 */
public class TruckItClient {

    private static final String BASE_URL = "http://192.168.8.72:9000";
    private static final String CREATE_USER_URL = "/user";
    private static final String CREATE_LOAD_URL = "/load";


    public static void createUser(User user) {
        String jsonEntity = new Gson().toJson(user,User.class);
        HttpHelper.postJson(getUrl(CREATE_USER_URL),jsonEntity);
    }

    public static void createLoad(Load load) {
        String jsonEntity = new Gson().toJson(load,Load.class);
        HttpHelper.postJson(getUrl(CREATE_LOAD_URL),jsonEntity);
    }

    private static String getUrl(String subUrl) {
        return BASE_URL + subUrl;
    }
}
