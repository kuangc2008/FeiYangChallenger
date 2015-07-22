package com.qihoo.feiyang.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.qihoo.feiyang.adapter.HoujhComiTestAdapter;
import com.qihoo.feiyang.challenger.R;

/**
 * Created by houjianhua on 2015/7/21.
 */
public class HoujhComingTestFragment extends Fragment {

    private ListView comiTestListview;
    private HoujhComiTestAdapter comiTestAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View comiTestView = inflater.inflate(R.layout.houjh_test_frag, container, false);
        comiTestListview = (ListView) comiTestView.findViewById(R.id.listview_in_fragment);
        comiTestAdapter = new HoujhComiTestAdapter(getActivity());
        comiTestListview.setAdapter(comiTestAdapter);
        return comiTestView;
    }
}
