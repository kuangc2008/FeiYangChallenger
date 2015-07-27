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

    }

    public class MyOnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {


            switch (v.getId()) {
                case R.id.btn_game_info_back:
                    finish();
                    break;
                case R.id.tv_intro_game:
                    tvIntro.setTextColor(android.graphics.Color.BLUE);

                    tvComm.setTextColor(Color.BLACK);
                    tvBBS.setTextColor(Color.BLACK);
                    tvGift.setTextColor(Color.BLACK);
                    mPager.setCurrentItem(0);
                    break;

                case R.id.tv_comment_game:
                    tvComm.setTextColor(android.graphics.Color.BLUE);

                    tvIntro.setTextColor(Color.BLACK);
                    tvBBS.setTextColor(Color.BLACK);
                    tvGift.setTextColor(Color.BLACK);
                    mPager.setCurrentItem(1);
                    break;
                case R.id.tv_bbs_game:
                    tvBBS.setTextColor(android.graphics.Color.BLUE);

                    tvIntro.setTextColor(Color.BLACK);
                    tvComm.setTextColor(Color.BLACK);
                    tvGift.setTextColor(Color.BLACK);

                    mPager.setCurrentItem(2);
                    break;
                case R.id.tv_gift_game:
                    mPager.setCurrentItem(3);
                    tvGift.setTextColor(android.graphics.Color.BLUE);
                    tvBBS.setTextColor(Color.BLACK);
                    tvIntro.setTextColor(Color.BLACK);
                    tvComm.setTextColor(Color.BLACK);
                    break;

            }

        }
    }

    public class MyPageChangeListener implements OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
            if (arg0 == 2) {
                int i = mPager.getCurrentItem();
//                clearChioce();
//                iconChange(i);
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

                    tvIntro.setTextColor(android.graphics.Color.BLUE);

                    tvComm.setTextColor(Color.BLACK);
                    tvBBS.setTextColor(Color.BLACK);
                    tvGift.setTextColor(Color.BLACK);
                    break;
                case 1:

                    tvComm.setTextColor(android.graphics.Color.BLUE);

                    tvIntro.setTextColor(Color.BLACK);
                    tvBBS.setTextColor(Color.BLACK);
                    tvGift.setTextColor(Color.BLACK);

                    break;

                case 2:

                    tvBBS.setTextColor(android.graphics.Color.BLUE);

                    tvIntro.setTextColor(Color.BLACK);
                    tvComm.setTextColor(Color.BLACK);
                    tvGift.setTextColor(Color.BLACK);
                    break;
                case 3:

                    tvGift.setTextColor(android.graphics.Color.BLUE);
                    tvBBS.setTextColor(Color.BLACK);
                    tvIntro.setTextColor(Color.BLACK);
                    tvComm.setTextColor(Color.BLACK);
                    break;


            }


        }

    }


    public void clearChioce() {
        tvIntro.setBackgroundResource(R.drawable.icon_no_pressed);
        tvComm.setBackgroundResource(R.drawable.icon_no_pressed);
        tvBBS.setBackgroundResource(R.drawable.icon_no_pressed);
        tvGift.setBackgroundResource(R.drawable.icon_no_pressed);

    }

    public void iconChange(int num) {
        switch (num) {
            case R.id.introduct_game:
            case 0:
                tvIntro.setBackgroundResource(R.drawable.icon_pressed);
                mPager.setCurrentItem(0);
                break;
            case R.id.comment_game:
                tvComm.setBackgroundResource(R.drawable.icon_pressed);
                mPager.setCurrentItem(1);
                break;
            case R.id.bbs_game:
            case 2:
                tvBBS.setBackgroundResource(R.drawable.icon_pressed);
                mPager.setCurrentItem(2);
                break;
            case R.id.gift_game:
            case 3:
                tvGift.setBackgroundResource(R.drawable.icon_pressed);
                mPager.setCurrentItem(3);

                break;
        }
    }
}  