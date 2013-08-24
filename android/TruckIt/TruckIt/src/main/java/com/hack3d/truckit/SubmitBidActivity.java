package com.hack3d.truckit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by johngyselinck on 8/24/13.
 */
public class SubmitBidActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_bid);
        Load myLoad = (Load) getIntent().getSerializableExtra(HaulerLoads.LOAD_EXTRA);
        TextView customer = (TextView)findViewById(R.id.submit_bid_customer);
        customer.setText(myLoad.getCustomerId());
        TextView pickup = (TextView)findViewById(R.id.submi_bid_pickup_location);
        pickup.setText(myLoad.getPickupLocation().getStreet());
    }
}
