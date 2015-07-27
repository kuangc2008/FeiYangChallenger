package com.qihoo.feiyang.ui;

/**
 * Created by caoyu-xy on 2015/7/23.
 * modify by maxiaowei on 2015/7/26
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.qihoo.feiyang.challenger.*;
import com.qihoo.feiyang.util.LoginInterface;

public class SignupActivity extends Activity {
    private LoginInterface m_interface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity_main);
        m_interface = new LoginInterface(this);

        final Button SignupButton = (Button) findViewById(R.id.sign_up_button);
        final EditText userName_edit = (EditText) findViewById(R.id.sign_up_usr_name_editText);
        final EditText password_edit = (EditText) findViewById(R.id.sign_up_password_editText);
        final EditText password_again_edit = (EditText) findViewById(R.id.sign_up_password_again_editText);
        final EditText nick_name=(EditText)findViewById(R.id.usr_nick_name_editText);

        SignupButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String user_name = userName_edit.getText().toString();
                String password = password_edit.getText().toString();
                String password_again = password_again_edit.getText().toString();
                String nickname = nick_name.getText().toString();
                //?§Ø???????????????
                if (m_interface.isUserExist(user_name)) {
                    Toast.makeText(SignupActivity.this, R.string.user_name_has_existed, Toast.LENGTH_SHORT).show();
                    return;
                }
                //?§Ø????????????????????
                if (!password.equals(password_again))
                    if (!password.equals(password_again)) {
                        Toast.makeText(SignupActivity.this, R.string.password_not_same, Toast.LENGTH_SHORT).show();
                        return;
                    }
                //?????
                if (m_interface.userRegist(user_name, password,nickname)) {
                    //???????????????????....
                    Toast.makeText(SignupActivity.this, R.string.signup_success, Toast.LENGTH_SHORT).show();
                    Intent returntologin = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(returntologin);
                    finish();
                }
                //?????????????????
                else {
                    Toast.makeText(SignupActivity.this, m_interface.getErrorString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}