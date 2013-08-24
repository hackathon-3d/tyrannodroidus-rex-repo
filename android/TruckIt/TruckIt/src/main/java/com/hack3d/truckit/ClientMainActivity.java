package com.hack3d.truckit;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class ClientMainActivity extends Activity {

    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING STRING ADAPTER WHICH WILL HANDLE DATA OF LISTVIEW
    ArrayAdapter<String> adapter;

    private TextView jobDetailInput;

    private TextView startInput;

    private TextView endInput;

    private TextView jobDetail;

    private TextView start;

    private TextView end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_main);
        setUpView();
        setUpMocks();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.client_main, menu);
        return true;
    }

    private void setUpView(){

        jobDetail = (TextView) findViewById(R.id.job_detail);
        start = (TextView) findViewById(R.id.start);
        end = (TextView) findViewById(R.id.end);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems);
        ListView listView = (ListView) findViewById(R.id.bids_list_view);
        listView.setAdapter(adapter);
    }

    private void setUpMocks(){
        getJobDetailByJobId();
        getBidsByJobId();
    }

    private void getJobDetailByJobId(){
        //call to service with job id
        jobDetail.setText("This is the job description text. This is the job description text. This is the job description text. This is the job description text. This is the job description text.");
        start.setText("START");
        end.setText("END");
    }

    private void getBidsByJobId(){

        listItems.add("Bid 1");
        listItems.add("Bid 2");
        listItems.add("Bid 3");

    }


    private void getBidDetail(){
        //launch a bid detail view
    }


    private void editDetail(){
        //launch a job detail view
    }

    public void viewCurrentJobs(View view){

    }

    public void viewPastJobs(View view){

        Intent intent = new Intent(this, ClientPastJobsActivity.class);
        startActivity(intent);
    }

}
