package com.qihoo.feiyang.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qihoo.feiyang.challenger.R;

/**
 * Created by niangang on 2015/7/24.
 */
public class GameCommFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View currTestView = inflater.inflate(R.layout.game_comm_paper,
                container, false);
        return currTestView;
    }
}