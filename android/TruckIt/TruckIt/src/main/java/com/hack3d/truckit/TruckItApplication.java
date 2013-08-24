package com.hack3d.truckit;

import android.app.Application;
import android.content.Context;

/**
 * Created by ericwood on 8/24/13.
 */
public class TruckItApplication extends Application {
    private static Context context;

    public void onCreate(){

        context = getApplicationContext();

        // Instantiate the SharedPreferencesUtil Singleton
        SharedPreferencesUtil.getInstance();
    }

    public static Context getAppContext() {
        return TruckItApplication.context;
    }

}
