package com.qihoo.feiyang.challenger;

/**
 * Created by caoyu-xy on 2015/7/21.
 */
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.qihoo.feiyang.internet.HttpProcess;

public class LoginActivity extends Activity{
    private SharedPreferences usr_preference;
    private SharedPreferences.Editor editor;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_main);

        usr_preference= this.getSharedPreferences("usr",MODE_PRIVATE);
        editor = usr_preference.edit();

        final EditText usr_name_EditText=(EditText)findViewById(R.id.Login_usr_name_editText);
        final EditText password_EditText=(EditText)findViewById(R.id.Login_password_editText);
        final Button login_btn=(Button)findViewById(R.id.Login_button);
        usr_name_EditText.setText(usr_preference.getString("username", null));

        login_btn.setOnClickListener(new Button.OnClickListener(){
              public void onClick(View v){
                  String username=usr_name_EditText.getText().toString();
                  String password=password_EditText.getText().toString();

                  editor.putString("username", username);
                  editor.commit();
                  //context = getApplicationContext();
                  HttpProcess httpProcess = new HttpProcess(LoginActivity.this, username, password);
                  httpProcess.send();
              }

        });

    }

}
