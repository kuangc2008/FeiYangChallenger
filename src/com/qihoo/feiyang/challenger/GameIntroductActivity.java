package com.qihoo.feiyang.challenger;

/**
 * Created by caoyu-xy on 2015/7/23.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GameIntroductActivity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_info_paper, container,false);
        return view;
    }
}