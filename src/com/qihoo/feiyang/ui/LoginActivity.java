package com.qihoo.feiyang.ui;

/**
 * Created by caoyu-xy on 2015/7/21.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.qihoo.feiyang.app.MyApplication;
import com.qihoo.feiyang.challenger.R;
import com.qihoo.feiyang.util.LoginInterface;

public class LoginActivity extends Activity {
    private SharedPreferences usr_preference;
    private SharedPreferences.Editor editor;
    private Context context;
    private LoginInterface m_interface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_main);

        m_interface = new LoginInterface(this);

        usr_preference = this.getSharedPreferences("usr", MODE_PRIVATE);
        editor = usr_preference.edit();

        final EditText usr_name_EditText = (EditText) findViewById(R.id.Login_usr_name_editText);
        final EditText password_EditText = (EditText) findViewById(R.id.Login_password_editText);
        final Button login_btn = (Button) findViewById(R.id.Login_button);
        final Button login_sign_btn = (Button) findViewById(R.id.Login_sign_up_button);
        usr_name_EditText.setText(usr_preference.getString("username", null));

        login_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String usr_name = usr_name_EditText.getText().toString();
                String password = password_EditText.getText().toString();

                if (m_interface.isRightPassword(usr_name, password)) {
                    Toast.makeText(LoginActivity.this, R.string.Login_in_success, Toast.LENGTH_SHORT).show();

                    Intent returntohome = new Intent(LoginActivity.this, HoujhFragment.class);
                    MyApplication.isLogin = true;
                    returntohome.putExtra("isSuccess", true);
                    startActivity(returntohome);


                } else {
                    Toast.makeText(LoginActivity.this, R.string.Login_in_fail, Toast.LENGTH_SHORT).show();
                }
//                editor.putString("username", username);
//                editor.commit();
//                context = getApplicationContext();
//                HttpProcess httpProcess = new HttpProcess(context, username, password);
//                httpProcess.send();
            }

        });
        login_sign_btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent signupintent = new Intent(LoginActivity.this, SignupActivity.class);
                signupintent.putExtra("isSuccess", false);
                MyApplication.isLogin = false;
                startActivity(signupintent);
                finish();

            }
        });

    }

}
