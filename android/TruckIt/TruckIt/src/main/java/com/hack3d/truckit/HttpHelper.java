package com.hack3d.truckit;

import android.util.Log;

import org.apache.http.HttpConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ericwood on 8/24/13.
 */
public class HttpHelper {

    public static final String TAG = HttpHelper.class.getName();

    public static Object getJson(String url) {
        // Prevent connection pooling
        System.setProperty("http.keepAlive", "false");
        try {
            URL httpUrl = new URL(url);
            HttpURLConnection httpConnection = (HttpURLConnection) httpUrl.openConnection();

            httpConnection.setRequestMethod("GET");

            httpConnection.connect();

            InputStream inputStream;
            StringBuilder sbJson = new StringBuilder();
            int responseCode=httpConnection.getResponseCode();
            boolean errorResponse = false;
            if ((responseCode>= 200) &&(responseCode<=202) ) {
                inputStream = (httpConnection).getInputStream();


            }
            else {
                inputStream = httpConnection.getErrorStream();
                errorResponse =  true;
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null)  {
                if (errorResponse) {
                    Log.e(TAG, inputLine);
                }
                else {
                    sbJson.append(inputLine+"\n");
                }
            }
            inputStream.close();
            httpConnection.disconnect();
            return sbJson.toString();

        }
        catch (IOException e) {
            Log.e(TAG, "GET Request failed", e);
            return null;
        }

    }

    public static Object postJson(String url, String jsonEntity) {
        // Prevent connection pooling
        System.setProperty("http.keepAlive", "false");
        try {
            URL httpUrl = new URL(url);
            HttpURLConnection httpConnection = (HttpURLConnection) httpUrl.openConnection();

            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type","application/json");

            httpConnection.connect();

            OutputStreamWriter out = new   OutputStreamWriter(httpConnection.getOutputStream());
            out.write(jsonEntity);
            out.close();

            InputStream inputStream;
            StringBuilder sbJson = new StringBuilder();
            int responseCode=httpConnection.getResponseCode();
            boolean errorResponse = false;
            if ((responseCode>= 200) &&(responseCode<=202) ) {
                inputStream = (httpConnection).getInputStream();


            }
            else {
                inputStream = httpConnection.getErrorStream();
                errorResponse =  true;
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null)  {
                if (errorResponse) {
                    Log.e(TAG, inputLine);
                }
                else {
                    sbJson.append(inputLine+"\n");
                }
            }
            inputStream.close();
            httpConnection.disconnect();
            return sbJson.toString();

        }
        catch (IOException e) {
            Log.e(TAG, "POST Request failed", e);
            return null;
        }
    }
}
