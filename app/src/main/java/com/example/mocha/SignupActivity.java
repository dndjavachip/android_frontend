package com.example.mocha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;





public class SignupActivity extends AppCompatActivity {

    EditText user_id, password, name, tel, cpassword;
    Button btn_signup;
    String checkid = "", checkall;

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
                try {
                    String result = new Checkid().execute("https://dnd-javachip.appspot.com/users/"+user_id.getText().toString()).get();
                    JSONObject res = new JSONObject(result);
                    checkid = res.getString("user_check");
                }
                catch (ExecutionException e) {
                    e.printStackTrace();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
                if(checkid.equals("true"))
                    Toast.makeText(SignupActivity.this, "이미 있는 아이디 입니다. 다른 아이디를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                else if (checkid.equals("false"))
                    Toast.makeText(SignupActivity.this, "사용가능한 아이디 입니다.", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.summitsignup).setOnClickListener(new Button.OnClickListener(){ //회원가입
                public void onClick(View v) {
                  if (password.getText().toString().equals(cpassword.getText().toString())) { //비밀번호와 비밀번호 확인
                      if(checkid.equals("false")) //아이디 중복검사 통과시
                      {
                          if(user_id.getText().toString().length() !=0 && password.getText().toString().length() !=0 && name.getText().toString().length() !=0 && tel.getText().toString().length() !=0)
                          {
                              new SignupTask().execute(user_id.getText().toString(),password.getText().toString(),name.getText().toString(),tel.getText().toString());
                              Toast.makeText(SignupActivity.this, "MoCA의 회원이 되신걸 축하합니다. 로그인을 진행해 주세요.", Toast.LENGTH_SHORT).show();
                              Intent intentLogin = new Intent(getApplicationContext(), LoginActivity.class);
                              startActivity(intentLogin);
                          }

                          else
                              Toast.makeText(SignupActivity.this, "입력조건이 충분하지 않습니다. 다시 입력해주세요.", Toast.LENGTH_SHORT).show();


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


