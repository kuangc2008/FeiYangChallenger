package com.qihoo.feiyang.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.qihoo.feiyang.adapter.GameGiftAdapter;
import com.qihoo.feiyang.challenger.R;
import com.qihoo.feiyang.entity.GameBetaInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niangang on 2015/7/24.
 */
public class GameGiftFragment extends Fragment {


    private ListView listView;
    private GameGiftAdapter gameGiftAdapter;
    private GameBetaInfo gameBetaInfo;
    private List<GameBetaInfo> gameBetaInfoList = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View gameGiftView = inflater.inflate(R.layout.game_gift_paper,
                container, false);
        gameBetaInfoList = new ArrayList<GameBetaInfo>();

        for (int i = 0; i < 2; i++) {

            gameBetaInfo = new GameBetaInfo();
            gameBetaInfo.setgNameStr(getString(R.string.gift_name_tv));
            gameBetaInfoList.add(gameBetaInfo);
        }

        listView = (ListView) gameGiftView.findViewById(R.id.list_gift);
        gameGiftAdapter = new GameGiftAdapter(getActivity(), gameBetaInfoList);
        listView.setAdapter(gameGiftAdapter);
        return gameGiftView;
    }
}