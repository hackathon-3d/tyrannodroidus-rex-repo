package com.hack3d.truckit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by johngyselinck on 8/24/13.
 */
public class HaulerHome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.hauler_main);
        TextView t = (TextView)findViewById(R.id.hauler_user_name);
        t.setText(SharedPreferencesUtil.getUserId(this));
    }

    //When clicking on the Profile button
    public void haulerProfile(View view){
        Intent intent = new Intent(this, HaulerProfile.class);
        startActivity(intent);
    }

    //When clicking on the Loads Button
    public void haulerLoads(View view){
        Intent intent = new Intent(this, HaulerLoads.class);
        startActivity(intent);
    }
}
