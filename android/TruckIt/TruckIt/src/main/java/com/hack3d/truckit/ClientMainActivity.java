package com.hack3d.truckit;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class ClientMainActivity extends Activity {

    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING STRING ADAPTER WHICH WILL HANDLE DATA OF LISTVIEW
    ArrayAdapter<String> adapter;

    private EditText jobDetailInput;

    private EditText startInput;

    private EditText endInput;

    private String jobDetail;

    private Date start;

    private Date end;

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

        jobDetailInput = (EditText) findViewById(R.id.job_detail_input);
        startInput = (EditText) findViewById(R.id.start_input);
        endInput = (EditText) findViewById(R.id.end_input);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems);
        ListView listView = (ListView) findViewById(R.id.bids_list_view);
        listView.setAdapter(adapter);
    }

    private void setUpMocks(){
        listItems.add("Bid 1");
        listItems.add("Bid 2");
        listItems.add("Bid 3");

        //startInput.setText();
        jobDetailInput.setText("This is the job description text. This is the job description text. This is the job description text. This is the job description text. This is the job description text.");
    }

    private void getJobDetailByJobId(){
        //call to service with job id
    }

    private void getBidsByJobId(){

    }

    private void getListItem(){
        //launch a bid detail view
    }

    private void editDetail(){
        //launch a job detail view
    }

    public void viewCurrentJobs(View view){

    }

    public void viewPastJobs(View view){

        //intent.putExtra(CreateTeamActivity.TEAM_ID_KEY, teamId);
        //playerDatabase.closeDatabase();
        Intent intent = new Intent(this, ClientPastJobsActivity.class);
        startActivity(intent);
    }





}
