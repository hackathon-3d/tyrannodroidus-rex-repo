package com.hack3d.truckit;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class ModeSelectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode_select);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mode_select, menu);
        return true;
    }

    //When clicking on the Haul a Load button
    public void haulerHome(View view){
        Intent intent = new Intent(this, HaulerHome.class);
        startActivity(intent);
    }

    public void clientMain(View view){
        Intent intent = new Intent(this, ClientMainActivity.class);
        startActivity(intent);
    }

    public void viewPastJobs(View view){
        Intent intent = new Intent(this, ClientPastJobsActivity.class);
        startActivity(intent);
    }

    public void createLoad(View view){
        Intent intent = new Intent(this, CreateJobActivity.class);
        startActivity(intent);
    }
    
}
