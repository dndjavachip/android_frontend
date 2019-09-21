package com.example.mocha;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    TextView cafe_num_display;

    String cafe_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cafe_num_display = findViewById(R.id.cafenum_display);


        Intent i = getIntent();
        cafe_num = i.getExtras().getString("cafe_num");
        cafe_num_display.setText(cafe_num);
    }
}
