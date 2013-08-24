package com.hack3d.truckit;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ClientPastJobsActivity extends Activity {

    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<Job> listItems=new ArrayList<Job>();

    //DEFINING STRING ADAPTER WHICH WILL HANDLE DATA OF LISTVIEW
    ArrayAdapter<Job> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_past_jobs);
        setUpView();
        setUpMocks();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.client_past_jobs, menu);
        return true;
    }

    private void setUpView(){

        adapter = new ArrayAdapter<Job>(this,
                android.R.layout.simple_list_item_1, listItems);
        ListView listView = (ListView) findViewById(R.id.client_past_jobs_list_view);
        listView.setAdapter(adapter);
    }

    private void setUpMocks(){

        for (int i = 0; i<5; i++){
            listItems.add(getRandJob());
        }




//        listItems.add("Bid 1");
//        listItems.add("Bid 2");
//        listItems.add("Bid 3");
    }

    int min = 0;
    int maxStar = 5;
    int maxZip = 99999;
    int maxPrice = 1000;

    public int getRandZip(){
        return getRand(min, maxZip);
    };

    public int getRandStar(){
        return getRand(min, maxStar);
    };

    public int getRandFloat(){
        return getRand(min, maxPrice);
    };


    public int getRand(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    public Job getRandJob(){
        Job job = new Job();
        job.setId(1);
        job.setHaulerId("Haulerid");

        SimpleDateFormat sdf = new SimpleDateFormat("mm DD yyyy");

        Load load = new Load();
        load.setCustomerId("1234");
        load.setDropoffBy(sdf.format(new Date()));
        load.setPickupBy(sdf.format(new Date()));



        Location pickupLocation = new Location();
        pickupLocation.setStreet("123 main");
        pickupLocation.setCity("city");
        pickupLocation.setState("SC");
        pickupLocation.setZip(getRandZip());

        job.setLoad(load);

        job.setPrice(getRandFloat());
        job.setRating(getRandStar());

        return job;
    }
}
