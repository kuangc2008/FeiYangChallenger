package com.qihoo.feiyang.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.qihoo.feiyang.adapter.GameGiftAdapter;
import com.qihoo.feiyang.adapter.PersonGiftAdapter;
import com.qihoo.feiyang.challenger.R;
import com.qihoo.feiyang.entity.GameBetaInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niangang on 2015/7/27.
 */
public class PersonGiftActivity extends Activity {
    private ListView listView;
    private PersonGiftAdapter gameGiftAdapter;
    private GameBetaInfo gameBetaInfo;
    private List<GameBetaInfo> gameBetaInfoList = null;

    private Button btnGiftBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_gift_activity);


        gameBetaInfoList = new ArrayList<GameBetaInfo>();

        for (int i = 0; i < 2; i++) {

            gameBetaInfo = new GameBetaInfo();
            gameBetaInfo.setgNameStr(getString(R.string.gift_name_tv));
            gameBetaInfoList.add(gameBetaInfo);
        }

        listView = (ListView) findViewById(R.id.ng_list_gif);

        btnGiftBack = (Button) findViewById(R.id.ng_btn_gift_back);

        gameGiftAdapter = new PersonGiftAdapter(this, gameBetaInfoList);
        listView.setAdapter(gameGiftAdapter);
        btnGiftBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}