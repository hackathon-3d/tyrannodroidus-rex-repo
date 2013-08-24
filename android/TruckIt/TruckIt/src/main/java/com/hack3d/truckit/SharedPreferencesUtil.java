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
<<<<<<< HEAD
    private static String secret = "SECRET";
//    protected SharedPreferencesUtil() {
//        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences();
//    }
=======

    protected SharedPreferencesUtil() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(TruckItApplication.getAppContext());
    }
>>>>>>> dec28e18f8a95599e0ed17fe36e43321c79ec70d

    public static SharedPreferencesUtil getInstance() {
        if(instance == null) {
            instance = new SharedPreferencesUtil();
        }

        return instance;
    }

    public String getCurrentLoad(Context context){
        //SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
<<<<<<< HEAD
         sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
=======
//        SharedPreferences sharedPreferences = getSharedPreferences(context, R.string.load_pref);
>>>>>>> dec28e18f8a95599e0ed17fe36e43321c79ec70d
        String the_name = sharedPreferences.getString(context.getString(R.string.load_pref), null);
        return the_name;
    }

    public void setCurrentLoad(Context context, String load_id){
        //SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
        //long load_id = 0L;
<<<<<<< HEAD
          sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
=======
//        SharedPreferences  sharedPreferences = getSharedPreferences(context, R.string.load_pref);
>>>>>>> dec28e18f8a95599e0ed17fe36e43321c79ec70d
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putString(context.getString(R.string.load_pref), String.valueOf(load_id));
        editor.apply();
    }

//    private SharedPreferences getSharedPreferences(Context context, int r){
//        return context.getSharedPreferences(context.getString(r), Context.MODE_PRIVATE);
//    }

    public static String getUserId(Context context){
<<<<<<< HEAD
         sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
=======
//        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
>>>>>>> dec28e18f8a95599e0ed17fe36e43321c79ec70d
        String the_name = sharedPreferences.getString(context.getString(R.string.name_pref), "");
        return the_name;
    }

    public static void setUserId(Context context, String user_id){
<<<<<<< HEAD
         sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
=======
//        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
>>>>>>> dec28e18f8a95599e0ed17fe36e43321c79ec70d
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.name_pref), user_id);
        editor.apply();
    }

    public static String getDisplayName(Context context){
<<<<<<< HEAD
         sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
=======
//        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
>>>>>>> dec28e18f8a95599e0ed17fe36e43321c79ec70d
        String the_name = sharedPreferences.getString(context.getString(R.string.display_name_pref), "");
        return the_name;
    }

    public static void setDisplayName(Context context, String display_name){
<<<<<<< HEAD
         sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
=======
//        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
>>>>>>> dec28e18f8a95599e0ed17fe36e43321c79ec70d
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putString(context.getString(R.string.display_name_pref), display_name);
        editor.apply();
    }

<<<<<<< HEAD
    public static void clearPreferences(Context context){
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.apply();
    }
=======
//    public static void clearPreferences(Context context){
//        SharedPreferences prefs = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
//        SharedPreferences.Editor edit = prefs.edit();
//        edit.clear();
//        edit.commit();
//    }
>>>>>>> dec28e18f8a95599e0ed17fe36e43321c79ec70d

}
