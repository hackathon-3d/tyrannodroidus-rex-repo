package com.hack3d.truckit;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
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

    public String getCurrentLoad(Context context){
        //SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = getSharedPreferences(context, R.string.load_pref);
        String the_name = sharedPreferences.getString(context.getString(R.string.load_pref), null);
        return the_name;
    }

    public void setCurrentLoad(Context context, String load_id){
        //SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
        //long load_id = 0L;
        SharedPreferences  sharedPreferences = getSharedPreferences(context, R.string.load_pref);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.load_pref), String.valueOf(load_id));
        editor.commit();
    }

    private SharedPreferences getSharedPreferences(Context context, int r){
        return context.getSharedPreferences(context.getString(r), Context.MODE_PRIVATE);
    }

    public static String getUserId(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
        String the_name = sharedPreferences.getString(context.getString(R.string.name_pref), "no name");
        return the_name;
    }

    public static void setUserId(Context context, String user_id){
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.name_pref), user_id);
        editor.commit();
    }

}
