package com.example.taskFromAl;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewsLoader extends AsyncTask <Void,Void, Void> {


    public MainActivity mainActivity;
    String jsonStrNews;


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mainActivity.news = new ArrayList<>();
        mainActivity.loadData.setVisibility(View.VISIBLE);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        HTTPHandler sh = new HTTPHandler();
        jsonStrNews = sh.makeServiceCall("https://guidebook.com/service/v2/upcomingGuides/");
        if (jsonStrNews == null) {
            jsonStrNews = "";
        }
        try {
            JSONObject jsonObject = new JSONObject(jsonStrNews);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            mainActivity.db.wipeNews();


            for (Integer i = 0; i < jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                AmazonNews amazonNews = new AmazonNews();
                amazonNews.setUrl(json.getString("url"));
                amazonNews.setStartDate(json.getString("startDate"));
                amazonNews.setAndDate(json.getString("endDate"));
                amazonNews.setName(json.getString("name"));
                amazonNews.setIconUrl(json.getString("icon"));
                amazonNews.setObjType(json.getString("objType"));
                mainActivity.db.insertNews(amazonNews.getUrl(), amazonNews.getStartDate(), amazonNews.getAndDate(),
                        amazonNews.getName(), amazonNews.getIcon(), amazonNews.getObjType());
                mainActivity.news.add(amazonNews);
               // Log.e("News", amazonNews.getName() + amazonNews.getAndDate() + amazonNews.getUrl());
            }
        } catch (JSONException error) {
            Log.e("Parsing error", error.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mainActivity.getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        mainActivity.list.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(mainActivity, layoutManager.getOrientation());

        if (jsonStrNews.equals("")){
            mainActivity.news = mainActivity.db.getNews();
        }

        NewsAdapter adapter = new NewsAdapter();
        adapter.mainActivity = mainActivity;
        mainActivity.list.setAdapter(adapter);
        //mainActivity.loadData.setVisibility(View.INVISIBLE);

    }
}

