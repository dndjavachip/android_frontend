/*package com.example.mocha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}*/

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

        /*usernameInput = (EditText) findViewById(R.id.username);
        passwordInput = (EditText) findViewById(R.id.password);
        remember = (CheckBox) findViewById(R.id.autologin);*/
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                Intent intentMain = new Intent(getApplicationContext(), MainActivity.class);
               /* usernameInput = (EditText) findViewById(R.id.username);
                String name = usernameInput.getText().toString();
                passwordInput = (EditText) findViewById(R.id.password);
                intentMain.putExtra("my_data",name);*/
                startActivity(intentMain);
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
