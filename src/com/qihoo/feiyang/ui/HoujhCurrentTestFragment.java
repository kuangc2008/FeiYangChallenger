package com.qihoo.feiyang.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.qihoo.feiyang.adapter.HoujhCurrTestAdapter;
import com.qihoo.feiyang.challenger.R;

/**
 * Created by houjianhua on 2015/7/21.
 */
public class HoujhCurrentTestFragment extends Fragment {

    private ListView currTestListview;
    private HoujhCurrTestAdapter currTestAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View currTestView = inflater.inflate(R.layout.houjh_test_frag, container, false);
        currTestListview = (ListView) currTestView.findViewById(R.id.listview_in_fragment);
        currTestAdapter = new HoujhCurrTestAdapter(getActivity());
        currTestListview.setAdapter(currTestAdapter);

        return currTestView;
    }
}
