package com.hack3d.truckit;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class CreateJobActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_job_activity_layout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_job, menu);
        return true;
    }

    public void createLoad(View view){
        //make REST call
        SharedPreferencesUtil.getInstance().setCurrentLoad(this, "1234");
        Intent intent = new Intent(this, ClientMainActivity.class);
        startActivity(intent);
    }
    
}
