package com.hack3d.truckit;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateJobActivity extends Activity implements TextWatcher{

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
        if (validate()){
            createLoadTask = new CreateLoadTask();
            createLoadTask.execute((Void) null);
            SharedPreferencesUtil.getInstance().setCurrentLoad(this, "1234");
            Intent intent = new Intent(this, ClientMainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    final public void afterTextChanged(Editable s) {
        //String text = textView.getText().toString();
        validate();
    }

    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) { /* Don't care */ }

    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) { /* Don't care */ }

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

    private boolean validate(){
        boolean result = true;
        if (description.getText().toString().length() == 0){
            description.setError("This field is required");
            result = false;
        }else {description.setError(null);}
        if (start.getText().toString().length() == 0){
            start.setError("This field is required");
            result = false;
        }else {start.setError(null);}
//        if (!start.getText().toString().matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\\\d\\\\d)")){
//            start.setError("This field must be in MM/DD/YYYY format");
//            result = false;
//        }else {start.setError(null);}
        if (end.getText().toString().length() == 0){
            end.setError("This field is required");
            result = false;
        }else {end.setError(null);}
//        if (!end.getText().toString().matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\\\d\\\\d)")){
//            end.setError("This field must be in MM/DD/YYYY format");
//            result = false;
//        }else {end.setError(null);}
        if (pickupAddress.getText().toString().length() == 0){
            pickupAddress.setError("This field is required");
            result = false;
        }else {pickupAddress.setError(null);}
        if (pickupCity.getText().toString().length() == 0){
            pickupCity.setError("This field is required");
            result = false;
        } else {pickupCity.setError(null);}
        if (pickupState.getText().toString().length() == 0){
            pickupState.setError("This field is required");
            result = false;
        } else {pickupState.setError(null);}
        if (pickupZip.getText().toString().length() == 0){
            pickupZip.setError("This field is required");
            result = false;
        } else {pickupZip.setError(null);}

        if (dropoffAddress.getText().toString().length() == 0){
            dropoffAddress.setError("This field is required");
            result = false;
        } else {dropoffAddress.setError(null);}
        if (dropoffCity.getText().toString().length() == 0){
            dropoffCity.setError("This field is required");
            result = false;
        } else {dropoffCity.setError(null);}
        if (dropoffState.getText().toString().length() == 0){
            dropoffState.setError("This field is required");
            result = false;
        } else {dropoffState.setError(null);}
        if (dropoffZip.getText().toString().length() == 0){
            dropoffZip.setError("This field is required");
            result = false;
        } else {dropoffZip.setError(null);}
        return result;
    }
    private void setUpView(){
        description = (EditText) findViewById(R.id.create_job_description);
        dropoffZip = (EditText) findViewById(R.id.create_job_dropoff_zip);
        dropoffState = (EditText) findViewById(R.id.create_job_dropoff_state);
        dropoffCity = (EditText) findViewById(R.id.create_job_dropoff_city);
        dropoffAddress = (EditText) findViewById(R.id.create_job_dropoff_address);
        pickupZip = (EditText) findViewById(R.id.create_job_pickup_zip);
        pickupState = (EditText) findViewById(R.id.create_job_pickup_state);
        pickupCity = (EditText) findViewById(R.id.create_job_pickup_city);
        pickupAddress = (EditText) findViewById(R.id.create_job_pickup_address);
        end = (EditText) findViewById(R.id.create_job_end_input);
        start = (EditText) findViewById(R.id.create_job_start_input);


    }
}
