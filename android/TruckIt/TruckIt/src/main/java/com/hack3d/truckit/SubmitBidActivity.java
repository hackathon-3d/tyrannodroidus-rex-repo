package com.hack3d.truckit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
//        TextView load_id = (TextView)findViewById(R.id.submit_load_id2);
//        load_id.setText(myLoad.getId());
        setupPickupLocation(myLoad);
        setupDestinationLocation(myLoad);
    }

    private void setupPickupLocation(Load myLoad){
        TextView pickupDate = (TextView)findViewById(R.id.submit_bid_pickup_date);
        pickupDate.setText(myLoad.getPickupBy());
        TextView pickup = (TextView)findViewById(R.id.submit_bid_pickup_street);
        pickup.setText(myLoad.getPickupLocation().getStreet());
        TextView pickupCity = (TextView)findViewById(R.id.submit_bid_pickup_city);
        pickupCity.setText(myLoad.getPickupLocation().getCity());
        TextView pickupState = (TextView)findViewById(R.id.submit_bid_pickup_state);
        pickupState.setText(myLoad.getPickupLocation().getState());
//        TextView pickupZip = (TextView)findViewById(R.id.pickup_zip);
//        pickupZip.setText(myLoad.getPickupLocation().getZip());
    }

    private void setupDestinationLocation(Load myLoad){
        TextView destDate = (TextView)findViewById(R.id.submit_bid_dest_date);
        destDate.setText(myLoad.getDropoffBy());
        TextView dest = (TextView)findViewById(R.id.submit_bid_dest_street);
        dest.setText(myLoad.getPickupLocation().getStreet());
        TextView destCity = (TextView)findViewById(R.id.submit_bid_dest_city);
        destCity.setText(myLoad.getDropoffLocation().getCity());
        TextView destState = (TextView)findViewById(R.id.submit_bid_dest_state);
        destState.setText(myLoad.getDropoffLocation().getState());
//        TextView destZip = (TextView)findViewById(R.id.dest_zip);
//        destZip.setText(myLoad.getDropoffLocation().getZip());
    }

    public void createBid(View view){
        EditText data = (EditText)findViewById(R.id.submit_bid_price);
        String price = data.getText().toString();
        Bid bid = new Bid();
        User user = new User();
        user.setUserId(SharedPreferencesUtil.getUserId(view.getContext()));
        user.setCustomerDisplayName(SharedPreferencesUtil.getDisplayName(view.getContext()));
        bid.setBiddingUser(user);
        bid.setPrice(Double.parseDouble(price));
        TruckItClient.createBid(bid);
    }
}
