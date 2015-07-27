package com.qihoo.feiyang.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.widget.PullDownListView;
import com.qihoo.feiyang.adapter.TodayBetaAdapter;
import com.qihoo.feiyang.challenger.R;
import com.qihoo.feiyang.entity.GameBetaInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houjianhua on 2015/7/21.
 */
public class HoujhCurrentTestFragment extends Fragment implements
        PullDownListView.OnRefreshListioner {
    private PullDownListView mPullDownView;
    private ListView mListView;
    private TodayBetaAdapter todayAdapter;

    private List<GameBetaInfo> gBetaInfos = null;// 今日内测集合
    private GameBetaInfo gBetaInfo;// 今日内测实体
    private String[] gNameStrs;
    private int maxAount = 20;// 设置了最大数据值
    private Handler mHandler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View currTestView = inflater.inflate(R.layout.houjh_test_frag,
                container, false);
        gNameStrs = getActivity().getResources().getStringArray(R.array.game_names);
        mPullDownView = (PullDownListView) currTestView
                .findViewById(R.id.sreach_list);
        mPullDownView.setRefreshListioner(this);
        mListView = mPullDownView.mListView;

        gBetaInfos = new ArrayList<GameBetaInfo>();
        addGameBetaInfos(7);
        todayAdapter = new TodayBetaAdapter(getActivity(), gBetaInfos);

        mListView.setAdapter(todayAdapter);
        mPullDownView.setMore(true);// 这里设置true表示还有更多加载，设置为false底部将不显示更多


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent gameIntent = new Intent(getActivity(), GameFragment.class);

                startActivity(gameIntent);
            }
        });
        return currTestView;
    }


    /**
     * 刷新，先清空list中数据然后重新加载更新内容
     */
    @Override
    public void onRefresh() {
        // TODO Auto-generated method stub
        mHandler.postDelayed(new Runnable() {

            public void run() {
                gBetaInfos.clear();

                addGameBetaInfos(7);
                mPullDownView.onRefreshComplete();// 这里表示刷新处理完成后把上面的加载刷新界面隐藏
                mPullDownView.setMore(true);// 这里设置true表示还有更多加载，设置为false底部将不显示更多

                todayAdapter.notifyDataSetChanged();

            }
        }, 1500);

    }

    /**
     * 加载更多，在原来基础上在添加新内容
     */
    @Override
    public void onLoadMore() {
        // TODO Auto-generated method stub
        mHandler.postDelayed(new Runnable() {
            public void run() {
                addMoreGameBetaInfos(5);// 每次加载五项新内容
                mPullDownView.onLoadMoreComplete();// 这里表示加载更多处理完成后把下面的加载更多界面（隐藏或者设置字样更多）
                if (gBetaInfos.size() < maxAount)// 判断当前list中已添加的数据是否小于最大值maxAount，是那么久显示更多否则不显示
                    mPullDownView.setMore(true);// 这里设置true表示还有更多加载，设置为false底部将不显示更多
                else
                    mPullDownView.setMore(false);

                todayAdapter.notifyDataSetChanged();

            }
        }, 1500);
    }

    /**
     * 初始显示默认列表
     *
     * @param n
     */

    private void addGameBetaInfos(int n) {

        n += gBetaInfos.size();

        for (int i = gBetaInfos.size(); i < n; i++) {
            gBetaInfo = new GameBetaInfo();
            gBetaInfo.setgNameStr(gNameStrs[i] + "");
            gBetaInfo.setgNum(8888 + i);
            gBetaInfo.setgSize("20.20M");
            gBetaInfo.setDown(false);
            gBetaInfo.setgIcoUri(i);
            gBetaInfo.setgInfoStr(getString(R.string.brief_intro));
            gBetaInfos.add(gBetaInfo);
            gBetaInfo = null;

        }
    }

    /**
     * 点击更多
     *
     * @param n
     */
    private void addMoreGameBetaInfos(int n) {

        for (int i = 0; i < n; i++) {

            gBetaInfo = new GameBetaInfo();
            gBetaInfo.setgNameStr(gNameStrs[i] + "");
            gBetaInfo.setgNum(8888 + i);
            gBetaInfo.setgSize("20.20M");
            gBetaInfo.setDown(false);
            gBetaInfo.setgIcoUri(i);
            gBetaInfo.setgInfoStr(getString(R.string.brief_intro));
            gBetaInfos.add(gBetaInfo);
            gBetaInfo = null;

        }

    }

}
