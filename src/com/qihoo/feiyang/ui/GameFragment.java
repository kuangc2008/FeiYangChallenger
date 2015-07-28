package com.qihoo.feiyang.ui;

import java.util.ArrayList;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.qihoo.feiyang.adapter.GameFragmentAdapter;
import com.qihoo.feiyang.challenger.R;


public class GameFragment extends FragmentActivity {
    //定义四个Fragment
    private GameIntroFragment gIntroFrag;
    private GameCommFragment gCommFrag;
    private GameBBSFragment gBBSFrag;
    private GameGiftFragment gGiftFrag;
    //定义一个ViewPager容器
    private ViewPager mPager;
    private ArrayList<Fragment> fragmentsList;
    private GameFragmentAdapter mAdapter;

    private TextView tvIntro;
    private TextView tvComm;
    private TextView tvBBS;
    private TextView tvGift;
    //定义FragmentManager对象
    public FragmentManager fManager;
    private ImageButton iBtnBack;
    //定义一个Onclick全局对象
    private MyOnClick myclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_info_title_activity);


        fManager = getSupportFragmentManager();

        initViewPager();
        initViews();
        mPager.setCurrentItem(0);


    }


    private void initViewPager() {
        fragmentsList = new ArrayList<Fragment>();
        gIntroFrag = new GameIntroFragment();
        gCommFrag = new GameCommFragment();
        gBBSFrag = new GameBBSFragment();
        gGiftFrag = new GameGiftFragment();
        fragmentsList.add(gIntroFrag);
        fragmentsList.add(gCommFrag);
        fragmentsList.add(gBBSFrag);
        fragmentsList.add(gGiftFrag);
        mAdapter = new GameFragmentAdapter(fManager, fragmentsList);
        mPager = (ViewPager) this.findViewById(R.id.vPager);
        mPager.setAdapter(mAdapter);
        mPager.setOnPageChangeListener(new MyPageChangeListener());
        mPager.setCurrentItem(0);


    }

    private void initViews() {
        myclick = new MyOnClick();

        tvIntro = (TextView) this.findViewById(R.id.tv_intro_game);
        tvComm = (TextView) findViewById(R.id.tv_comment_game);
        tvBBS = (TextView) findViewById(R.id.tv_bbs_game);
        tvGift = (TextView) findViewById(R.id.tv_gift_game);
        iBtnBack = (ImageButton) this.findViewById(R.id.btn_game_info_back);

        iBtnBack.setOnClickListener(myclick);
        tvIntro.setOnClickListener(myclick);
        tvComm.setOnClickListener(myclick);
        tvBBS.setOnClickListener(myclick);
        tvGift.setOnClickListener(myclick);
        tvIntro.setTextColor(getApplicationContext().getResources().getColor(R.color.backgroud));
        tvComm.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
        tvBBS.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
        tvGift.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));

    }

    public class MyOnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {


            switch (v.getId()) {
                case R.id.btn_game_info_back:
                    finish();
                    break;
                case R.id.tv_intro_game:

                    tvIntro.setTextColor(getApplicationContext().getResources().getColor(R.color.backgroud));
                    tvComm.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvBBS.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvGift.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));


                    mPager.setCurrentItem(0);
                    break;

                case R.id.tv_comment_game:


                    tvIntro.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvComm.setTextColor(getApplicationContext().getResources().getColor(R.color.backgroud));
                    tvBBS.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvGift.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));


//
                    mPager.setCurrentItem(1);
                    break;
                case R.id.tv_bbs_game:
                    tvIntro.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvComm.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvBBS.setTextColor(getApplicationContext().getResources().getColor(R.color.backgroud));
                    tvGift.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));


                    mPager.setCurrentItem(2);
                    break;
                case R.id.tv_gift_game:
                    mPager.setCurrentItem(3);
                    tvIntro.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvComm.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvBBS.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvGift.setTextColor(getApplicationContext().getResources().getColor(R.color.backgroud));
                    break;

            }

        }
    }

    public class MyPageChangeListener implements OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
            if (arg0 == 2) {
                int i = mPager.getCurrentItem();
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {


        }

        @Override
        public void onPageSelected(int index) {

            // 有4个 viewPaper 0 简介  1评论 2 专区 3 礼包活动


            switch (index) {
                case 0:


                    tvIntro.setTextColor(getApplicationContext().getResources().getColor(R.color.backgroud));
                    tvComm.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvBBS.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvGift.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    break;
                case 1:


                    tvIntro.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvComm.setTextColor(getApplicationContext().getResources().getColor(R.color.backgroud));
                    tvBBS.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvGift.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));

                    break;

                case 2:

                    tvIntro.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvComm.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvBBS.setTextColor(getApplicationContext().getResources().getColor(R.color.backgroud));
                    tvGift.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    break;
                case 3:

                    mPager.setCurrentItem(3);
                    tvIntro.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvComm.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvBBS.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_low));
                    tvGift.setTextColor(getApplicationContext().getResources().getColor(R.color.backgroud));
                    break;


            }


        }

    }


}