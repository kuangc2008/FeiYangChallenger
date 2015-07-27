package com.qihoo.feiyang.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.qihoo.feiyang.challenger.R;

/**
 * Created by niangang on 2015/7/27.
 */
public class PersonActivity extends Activity implements OnClickListener {

    private Button btnGiftBack, btnGift, btnCollect, btnInstall, btnExpect;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_activity);

        btnGiftBack = (Button) findViewById(R.id.ng_btn_person_back);
        btnGift = (Button) findViewById(R.id.ng_btn_gift);
        btnCollect = (Button) findViewById(R.id.ng_btn_collection);
        btnInstall = (Button) findViewById(R.id.ng_btn_instal_his);
        btnExpect = (Button) findViewById(R.id.ng_btn_expect_more);

        btnGiftBack.setOnClickListener(this);
        btnGift.setOnClickListener(this);
        btnCollect.setOnClickListener(this);
        btnInstall.setOnClickListener(this);
        btnExpect.setOnClickListener(this);


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