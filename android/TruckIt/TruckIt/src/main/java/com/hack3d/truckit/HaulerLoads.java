package com.hack3d.truckit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by johngyselinck on 8/24/13.
 */
public class HaulerLoads extends Activity {

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.hauler_loads);

        final ListView loads = (ListView)findViewById(R.id.hauler_loads);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, getListOfLoads());
        loads.setAdapter(adapter);
    }

    private ArrayList<String> getListOfLoads(){
        String[] values = new String[]{"Hello", "World", "This", "IS", "Sample", "Data"};
        ArrayList<String> theList = new ArrayList<String>();
        for(int i = 0; i < values.length; i++){
            theList.add(values[i]);
        }
        return theList;
    }
}
