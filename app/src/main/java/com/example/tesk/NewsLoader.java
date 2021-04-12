package com.example.tesk;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewsLoader extends AsyncTask <Void,Void, Void> {

    String jsonStrNews;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Void doInBackground(Void... voids) {
        HTTPHandler sh = new HTTPHandler();
        jsonStrNews = sh.makeServiceCall("https://guidebook.com/service/v2/upcomingGuides/");
        if (jsonStrNews == null) {
            jsonStrNews = "";
        }
        try {
            JSONArray jsonArray = new JSONArray(jsonStrNews);
            for (Integer i = 0; i < jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);


    }
}

