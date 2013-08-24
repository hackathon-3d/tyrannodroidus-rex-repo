package com.hack3d.truckit;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateJobActivity extends Activity {

    private EditText description;

    private EditText start;

    private EditText end;

    private EditText pickupAddress;

    private EditText pickupCity;

    private EditText pickupState;

    private EditText pickupZip;

    private EditText dropoffAddress;

    private EditText dropoffCity;

    private EditText dropoffState;

    private EditText dropoffZip;
    
    private CreateLoadTask createLoadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_job_activity_layout);
        setUpView();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_job, menu);
        return true;
    }

    public void createLoad(View view){
        //make REST call
        createLoadTask = new CreateLoadTask();
        createLoadTask.execute((Void) null);
        SharedPreferencesUtil.getInstance().setCurrentLoad(this, "1234");
        Intent intent = new Intent(this, ClientMainActivity.class);
        startActivity(intent);
    }

    public class CreateLoadTask extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

             SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");


            Load load = new Load();
            load.setCustomerId("1234");
            load.setDropoffBy(sdf.format(new Date()));
            load.setPickupBy(sdf.format(new Date()));

            Location pickupLocation = new Location();
            pickupLocation.setStreet(pickupAddress.getText().toString());
            pickupLocation.setCity(pickupCity.getText().toString());
            pickupLocation.setState(pickupState.getText().toString());
            pickupLocation.setZip(Integer.valueOf(pickupZip.getText().toString()));

            load.setPickupLocation(pickupLocation);

            Location dropoffLocation = new Location();
            dropoffLocation.setStreet(dropoffAddress.getText().toString());
            dropoffLocation.setCity(dropoffCity.getText().toString());
            dropoffLocation.setState(dropoffState.getText().toString());
            dropoffLocation.setZip(Integer.valueOf(dropoffZip.getText().toString()));

            load.setDropoffLocation(dropoffLocation);

            TruckItClient.createLoad(load);
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            createLoadTask = null;
            //showProgress(false);
            //showModeSelect();
        }

        @Override
        protected void onCancelled() {
            createLoadTask = null;
            //showProgress(false);
        }
    }

    private void setUpView(){
        description = (EditText) findViewById(R.id.create_job_description);
        start = (EditText) findViewById(R.id.create_job_start_input);
        end = (EditText) findViewById(R.id.create_job_end_input);
        
        pickupAddress = (EditText) findViewById(R.id.create_job_pickup_address);
        pickupCity = (EditText) findViewById(R.id.create_job_pickup_city);
        pickupState = (EditText) findViewById(R.id.create_job_pickup_state);
        pickupZip = (EditText) findViewById(R.id.create_job_pickup_zip);

        dropoffAddress = (EditText) findViewById(R.id.create_job_dropoff_address);
        dropoffCity = (EditText) findViewById(R.id.create_job_dropoff_city);
        dropoffState = (EditText) findViewById(R.id.create_job_dropoff_state);
        dropoffZip = (EditText) findViewById(R.id.create_job_dropoff_zip);

    }
}
