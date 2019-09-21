package com.example.mocha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class SearchActivity extends AppCompatActivity implements View.OnClickListener{{




}@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);
    Button search_btn;

    search_btn =  findViewById(R.id.search_btn);

    search_btn.setOnClickListener(this);

}

    @Override
    public void onClick(View view) {
        EditText search_cafenum;

        search_cafenum = findViewById(R.id.search_cafenum);

        switch(view.getId()) {
        case R.id.search_btn:
            Intent intentSearch = new Intent(getApplicationContext(), Main2Activity.class);

            intentSearch.putExtra("cafe_num",search_cafenum.getText().toString());
            System.out.println("TESTLOG:"+search_cafenum.getText().toString());
            startActivity(intentSearch);

            break;
    }

    }
}
