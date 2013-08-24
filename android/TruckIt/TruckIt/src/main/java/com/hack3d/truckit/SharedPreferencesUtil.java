package com.hack3d.truckit;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.TextView;

import com.google.gson.Gson;

/**
 * Created by rexcrews on 8/24/13.
 */
public class SharedPreferencesUtil {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferencesUtil instance = null;

//    protected SharedPreferencesUtil() {
//        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences();
//    }

    public static SharedPreferencesUtil getInstance() {
        if(instance == null) {
            instance = new SharedPreferencesUtil();
        }

        return instance;
    }


    private String getUserId(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
        String the_name = sharedPreferences.getString(context.getString(R.string.name_pref), "no name");
        return the_name;
    }



}
