package com.hack3d.truckit;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class ClientBidDetail extends Activity {

    public static final String LOAD_ID = "load_id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_bid_detail);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.client_bid_detail, menu);
        return true;
    }

    public void acceptBid(View view){
        //Tell the server we said YES!

        //Return to Job detail screen
        Intent intent = new Intent(this, ClientMainActivity.class);
        startActivity(intent);
    }
    
}
