package com.example.mocha;

import android.content.Intent;
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

        Intent intent =getIntent();
        String[] address_raw = intent.getExtras().getStringArray("address");
        String address = address_raw[2]+" "+address_raw[3]+" "+address_raw[4];
        String[] card0_raw = {address,intent.getExtras().getString("username")};

        recyclerview = findViewById(R.id.main_recycler);
        recyclerview.hasFixedSize();
        layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
        datas.add(new CardModel(card0_raw,0));
        datas.add(new CardModel("test",3));
        datas.add(new CardModel("test",1));
        datas.add(new CardModel("test",2));

        adapter = new ListAdapter(this,datas);
        recyclerview.setAdapter(adapter);


        new MainTask().execute();
}


    }


