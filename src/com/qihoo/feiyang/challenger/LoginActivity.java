package com.qihoo.feiyang.challenger;

/**
 * Created by caoyu-xy on 2015/7/21.
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity{
    private SharedPreferences usr_preference;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_main);

        usr_preference= this.getSharedPreferences("usr",MODE_PRIVATE);
        editor = usr_preference.edit();

        final EditText usr_name_EditText=(EditText)findViewById(R.id.Login_usr_name_editText);
        final EditText password_EditText=(EditText)findViewById(R.id.Login_password_editText);
        final Button login_btn=(Button)findViewById(R.id.Login_button);
        final Button sign_up_btn=(Button)findViewById(R.id.Login_sign_up_button);
        editor.putString("usr_name","caoyu");
        editor.putString("password", "caoyu");
        editor.commit();

        login_btn.setOnClickListener(new Button.OnClickListener() {
                                         public void onClick(View v) {
                                             String usr_name = usr_name_EditText.getText().toString();
                                             String password = password_EditText.getText().toString();

                                             String name_preference = usr_preference.getString("usr_name", null);
                                             String password_preference = usr_preference.getString("password", null);


                                             if ((usr_name.equals(name_preference)) && (password.equals(password_preference))) {
                                                 Toast.makeText(LoginActivity.this, R.string.Login_in_success, Toast.LENGTH_LONG).show();
                                             } else {
                                                 Toast.makeText(LoginActivity.this, R.string.Login_in_fail, Toast.LENGTH_LONG).show();
                                             }

                                         }
                                     }
        );
        sign_up_btn.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v) {
                        Intent signIntent = new Intent(LoginActivity.this, SignupActivity.class);
                        startActivity(signIntent);
                    }
                    }
        );
    }

}
