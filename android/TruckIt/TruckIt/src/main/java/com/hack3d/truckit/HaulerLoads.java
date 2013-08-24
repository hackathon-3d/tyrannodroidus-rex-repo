package com.hack3d.truckit;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johngyselinck on 8/24/13.
 */
public class HaulerLoads extends Activity {

    public static String LOAD_EXTRA = "com.hack3d.truckit.LOAD_EXTRA";
    private GetLoadsTask getLoadsTask = null;

    ArrayList<Load> stringList = new ArrayList<Load>();
    List<Load> loadList = new ArrayList<Load>();
    ArrayAdapter<Load> adapter;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.hauler_loads);
        final ListView loads = (ListView)findViewById(R.id.hauler_loads);
        adapter = new ArrayAdapter<Load>(this,android.R.layout.simple_list_item_1, stringList);
        getLoadsTask = new GetLoadsTask();
        getLoadsTask.execute((Void) null);
        loads.setAdapter(adapter);
        loads.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Load selected = (Load) loads.getItemAtPosition(i);
                Intent intent = new Intent(HaulerLoads.this, SubmitBidActivity.class);
                intent.putExtra(HaulerLoads.LOAD_EXTRA, selected);
                HaulerLoads.this.startActivity(intent);
            }
        });
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class GetLoadsTask extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... params) {
            loadList = TruckItClient.getLoads("CHARLESTON", "SC");
            return Boolean.TRUE;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            getLoadsTask = null;
            for(Load load:loadList){
                stringList.add(load);
            }
            adapter.notifyDataSetChanged();
        }

        @Override
        protected void onCancelled() {
            getLoadsTask = null;
        }


    }

    public static ArrayList<String> getArrayListOfLoads(List<Load> listOfLoads){
        String[] values = new String[]{"Hello", "World", "This", "IS", "Sample", "Data"};
        ArrayList<String> theList = new ArrayList<String>();
        for(int i = 0; i < values.length; i++){
            theList.add(values[i]);
        }
        return theList;
    }
}
