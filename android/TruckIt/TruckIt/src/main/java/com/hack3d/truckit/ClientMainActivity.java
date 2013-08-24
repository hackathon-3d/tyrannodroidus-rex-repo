package com.hack3d.truckit;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientMainActivity extends Activity {

    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
//    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING STRING ADAPTER WHICH WILL HANDLE DATA OF LISTVIEW
    BidAdapter adapter;

    private TextView jobDetailInput;

    private TextView startInput;

    private TextView endInput;

    private TextView jobDetail;

    private TextView start;

    private TextView end;

//    private GetLoadTask getLoadTask;

    List<Bid> bidList=new ArrayList<Bid>();



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

//        adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, listItems);
        ListView listView = (ListView) findViewById(R.id.bids_list_view);
//        listView.setAdapter(adapter);
        adapter = new BidAdapter(this, R.layout.bid_row, new ArrayList<Bid>(),"foo");
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listener);

    }

    private void setUpMocks(){
        getJobDetailByJobId();
//        getBidsByJobId();
    }

    private void getJobDetailByJobId(){
        //call to service with job id

        jobDetail.setText("This is the job description text. This is the job description text. This is the job description text. This is the job description text. This is the job description text.");
        start.setText("START");
        end.setText("END");
    }

//    private void getBidsByJobId(){
//
//        getLoadTask = new GetLoadTask();
//        getLoadTask.execute((Void) null);
//
//    }


    public void getBidDetail(long load_id){
        //launch a bid detail view

        //SharedPreferencesUtil.getInstance().setCurrentLoad(this, "1234");
        Intent intent = new Intent(this, ClientBidDetail.class);
        intent.putExtra(ClientBidDetail.LOAD_ID, load_id);
        startActivity(intent);
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



//    public class GetLoadTask extends AsyncTask<Void, Void, Boolean> {
//        @Override
//        protected Boolean doInBackground(Void... params) {
//            // TODO: attempt authentication against a network service.
//            bidList = TruckItClient.getBids("TEST");
//            return true;
//        }
//
//        @Override
//        protected void onPostExecute(final Boolean success) {
//            for (Bid bid: bidList){
//                listItems.add(bid.toString());
//            }
//            adapter.notifyDataSetChanged();
//            getLoadTask = null;
//        }
//
//        @Override
//        protected void onCancelled() {
//            getLoadTask = null;
//            //showProgress(false);
//        }
//    }

    private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            Bid bidItem = (Bid) parent.getItemAtPosition(position);
            getBidDetail(bidItem.getId());

        }
    };



}
