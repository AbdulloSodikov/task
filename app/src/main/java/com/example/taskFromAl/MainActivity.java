package com.example.taskFromAl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public ArrayList<AmazonNews> news;
    public RecyclerView list;
    public NewsDataBase db;
    ConstraintLayout loadData;
    MainActivity mainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.rv_list);
        loadData = findViewById(R.id.cl_loadData);
        db = new NewsDataBase(this);



        NewsLoader newsloader = new NewsLoader();
        newsloader.mainActivity = this;
        newsloader.execute();


    }

}