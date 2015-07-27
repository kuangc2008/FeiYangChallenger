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

    private List<GameBetaInfo> gBetaInfos = null;// �����ڲ⼯��
    private GameBetaInfo gBetaInfo;// �����ڲ�ʵ��
    private String[] gNameStrs;
    private int maxAount = 20;// �������������ֵ
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
        mPullDownView.setMore(true);// ��������true��ʾ���и�����أ�����Ϊfalse�ײ�������ʾ����


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
     * ˢ�£������list������Ȼ�����¼��ظ�������
     */
    @Override
    public void onRefresh() {
        // TODO Auto-generated method stub
        mHandler.postDelayed(new Runnable() {

            public void run() {
                gBetaInfos.clear();

                addGameBetaInfos(7);
                mPullDownView.onRefreshComplete();// �����ʾˢ�´�����ɺ������ļ���ˢ�½�������
                mPullDownView.setMore(true);// ��������true��ʾ���и�����أ�����Ϊfalse�ײ�������ʾ����

                todayAdapter.notifyDataSetChanged();

            }
        }, 1500);

    }

    /**
     * ���ظ��࣬��ԭ�������������������
     */
    @Override
    public void onLoadMore() {
        // TODO Auto-generated method stub
        mHandler.postDelayed(new Runnable() {
            public void run() {
                addMoreGameBetaInfos(5);// ÿ�μ�������������
                mPullDownView.onLoadMoreComplete();// �����ʾ���ظ��ദ����ɺ������ļ��ظ�����棨���ػ��������������ࣩ
                if (gBetaInfos.size() < maxAount)// �жϵ�ǰlist������ӵ������Ƿ�С�����ֵmaxAount������ô����ʾ���������ʾ
                    mPullDownView.setMore(true);// ��������true��ʾ���и�����أ�����Ϊfalse�ײ�������ʾ����
                else
                    mPullDownView.setMore(false);

                todayAdapter.notifyDataSetChanged();

            }
        }, 1500);
    }

    /**
     * ��ʼ��ʾĬ���б�
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
     * �������
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
