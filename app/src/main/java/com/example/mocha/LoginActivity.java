

package com.example.mocha;

import android.content.Intent;

import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.EditText;

import android.widget.CheckBox;

import android.widget.Button;

import android.view.View;

import android.widget.CompoundButton;

import android.widget.Toast;

import org.json.JSONException;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Boolean loginChecked;
    private EditText usernameInput, passwordInput;
    CheckBox remember;
    Button login, signup;
    SharedPreferences pref;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = (EditText) findViewById(R.id.username);
        passwordInput = (EditText) findViewById(R.id.password);
        remember = (CheckBox) findViewById(R.id.autologin);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        String checkresult ="";
        switch (v.getId()) {
            case R.id.login:
                try {
                    String result = new LoginTask().execute(usernameInput.getText().toString(),passwordInput.getText().toString()).get();
                    JSONObject res = new JSONObject(result);
                    checkresult = res.getString("status");
                    //System.out.println(checkresult);

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(checkresult.equals("success")) {
                    Intent intentMain = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intentMain);

                }
                else {
                    Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호가 올바르지 않습니다.", Toast.LENGTH_SHORT).show();

                }




               /* usernameInput = (EditText) findViewById(R.id.username);
                String name = usernameInput.getText().toString();
                passwordInput = (EditText) findViewById(R.id.password);
                intentMain.putExtra("my_data",name);*/
                //Toast.makeText(getApplicationContext(), "break직전", Toast.LENGTH_LONG).show();
                break; //엑티비티 전환후 break문이 실행되는지.

            case R.id.signup:
                Intent intentSignUp = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intentSignUp);
                //Toast.makeText(getApplicationContext(), "break직전", Toast.LENGTH_LONG).show();
                break; //엑티비티 전환후 break문이 실행되는지.

        }

    }
}
