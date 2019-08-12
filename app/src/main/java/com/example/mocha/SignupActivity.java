package com.example.mocha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.preference.PreferenceActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;




public class SignupActivity extends AppCompatActivity {

    EditText user_id, password, name, tel, cpassword;
    Button btn_signup;
    public static boolean check = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        user_id = (EditText)findViewById(R.id.signupid);
        password = (EditText)findViewById(R.id.signuppassword);
        cpassword = (EditText)findViewById(R.id.checkpassword);
        name =  (EditText)findViewById(R.id.name);
        tel = (EditText)findViewById(R.id.tel);
        //btn_signup = (Button)findViewById(R.id.summitsignup);


        findViewById(R.id.checkid).setOnClickListener(new Button.OnClickListener(){ // 아이디 중복확인
            public void onClick(View v) {
                new Checkid().execute("https://dnd-javachip.appspot.com/users/"+user_id.getText().toString());
                if(check==true)
                    Toast.makeText(SignupActivity.this, "이미 있는 아이디 입니다. 다른 아이디를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                else if (check == false)
                    Toast.makeText(SignupActivity.this, "사용가능한 아이디 입니다.", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.summitsignup).setOnClickListener(new Button.OnClickListener(){ //회원가입
                public void onClick(View v) {
                  if (password.getText().toString().equals(cpassword.getText().toString())) {
                      if(check == false)
                      {
                          new JSONTask().execute(user_id.getText().toString(),password.getText().toString(),name.getText().toString(),tel.getText().toString());
                          Intent intentLogin = new Intent(getApplicationContext(), LoginActivity.class);
                          startActivity(intentLogin);
                      }
                      else {
                          Toast.makeText(SignupActivity.this, "아이디 중복확인을 해주세요.", Toast.LENGTH_SHORT).show();
                      }
                  }
                  else
                      Toast.makeText(SignupActivity.this, "비밀번호가 일치하지 않습니다. 다시입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


