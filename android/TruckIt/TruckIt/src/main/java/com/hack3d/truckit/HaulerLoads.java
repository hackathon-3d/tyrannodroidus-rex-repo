package com.hack3d.truckit;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johngyselinck on 8/24/13.
 */
public class HaulerLoads extends Activity {

    private GetLoadsTask getLoadsTask = null;

    ArrayList<String> stringList = new ArrayList<String>();
    List<Load> loadList = new ArrayList<Load>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.hauler_loads);
        ListView loads = (ListView)findViewById(R.id.hauler_loads);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, stringList);
        getLoadsTask = new GetLoadsTask();
        getLoadsTask.execute((Void) null);
//        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, getArrayListOfLoads(loadList));
        loads.setAdapter(adapter);
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
                stringList.add(load.toString());
            }
            adapter.notifyDataSetChanged();
        }

        @Override
        protected void onCancelled() {
            getLoadsTask = null;
//            showProgress(false);
        }


    }

    public static ArrayList<String> getArrayListOfLoads(List<Load> listOfLoads){
        String[] values = new String[]{"Hello", "World", "This", "IS", "Sample", "Data"};
//        List<Load> loadList = TruckItClient.getLoads("CHARLESTON", "SC");
        ArrayList<String> theList = new ArrayList<String>();
        for(int i = 0; i < values.length; i++){
            theList.add(values[i]);
        }
//        if(listOfLoads == null){
//            return theList;
//        }
//        for(Load loadItem:listOfLoads){
//            theList.add(loadItem.getLoadDescription());
//        }
        return theList;
    }
}
