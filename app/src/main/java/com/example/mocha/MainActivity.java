package com.example.mocha;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<CardModel> datas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.main_recycler);
        recyclerview.hasFixedSize();
        layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
        datas.add(new CardModel("test",0));
        datas.add(new CardModel("test",3));
        datas.add(new CardModel("test",1));
        datas.add(new CardModel("test",1));



        adapter = new ListAdapter(this,datas);
        recyclerview.setAdapter(adapter);





        new MainTask().execute();
}}

