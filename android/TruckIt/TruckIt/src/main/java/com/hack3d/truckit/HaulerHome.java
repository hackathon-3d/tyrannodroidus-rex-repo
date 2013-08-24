package com.hack3d.truckit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by johngyselinck on 8/24/13.
 */
public class HaulerHome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.hauler_main);
    }

    //When clicking on the Haul a Load button
    public void haulerProfile(View view){
        Intent intent = new Intent(this, HaulerProfile.class);
        startActivity(intent);
    }
}
