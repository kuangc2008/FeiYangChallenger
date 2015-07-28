package com.qihoo.feiyang.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.qihoo.feiyang.app.MyApplication;
import com.qihoo.feiyang.challenger.R;

/**
 * Created by niangang on 2015/7/27.
 */
public class PersonActivity extends Activity implements OnClickListener {

    private Button btnGiftBack;
    private ImageButton btnGift, btnCollect, btnInstall, btnExpect;
    private TextView tvName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_activity);

        btnGiftBack = (Button) findViewById(R.id.ng_btn_person_back);
        btnGift = (ImageButton) findViewById(R.id.ng_btn_gift);
        btnCollect = (ImageButton) findViewById(R.id.ng_btn_collection);
        btnInstall = (ImageButton) findViewById(R.id.ng_btn_instal_his);
        btnExpect = (ImageButton) findViewById(R.id.ng_btn_expect_more);
        tvName = (TextView) findViewById(R.id.ng_iv_name);
        btnGiftBack.setOnClickListener(this);
        btnGift.setOnClickListener(this);
        btnCollect.setOnClickListener(this);
        btnInstall.setOnClickListener(this);
        btnExpect.setOnClickListener(this);

        tvName.setText(MyApplication.nickStr);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ng_btn_person_back:
                finish();
                break;
            case R.id.ng_btn_gift:
                Intent intent = new Intent(PersonActivity.this, PersonGiftActivity.class);
                startActivity(intent);


                break;
            case R.id.ng_btn_collection:
                break;
            case R.id.ng_btn_instal_his:
                break;
            case R.id.ng_btn_expect_more:
                break;


        }

    }
}