package com.hack3d.truckit;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

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
    
}
