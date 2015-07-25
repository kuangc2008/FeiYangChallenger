package com.qihoo.feiyang.challenger;

import java.util.ArrayList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.qihoo.feiyang.adapter.GameFragmentPagerAdapter;


public class GameActivity extends FragmentActivity {

    //定义四个Fragment  
    private GameIntroductActivity Introduct;
    private GameCommentActivity Comment;
    private GameBBSActivity bbs;
    private GameGiftActivity gift;
    //定义一个ViewPager容器  
    private ViewPager mPager;
    private ArrayList<Fragment> fragmentsList;
    private GameFragmentPagerAdapter mAdapter;

    //依次获得ImageView与TextView  
    private Button  introduct_btn;
    private Button comment_btn;
    private Button bbs_btn;
    private Button gift_btn;

    //定义FragmentManager对象  
    public FragmentManager fManager;
    //定义一个Onclick全局对象  
    public MyOnClick myclick;
    public MyPageChangeListener myPageChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_activity_main);
//        getActionBar().hide();
        fManager = getSupportFragmentManager();
        initViewPager();
        initViews();
        initState();
    }




    private void initViews() {
        myclick = new MyOnClick();
        myPageChange = new MyPageChangeListener();
        mPager = (ViewPager) findViewById(R.id.vPager);
        introduct_btn = (Button) findViewById(R.id.introduct_game);
        comment_btn = (Button) findViewById(R.id.comment_game);
        bbs_btn = (Button) findViewById(R.id.bbs_game);
        gift_btn = (Button) findViewById(R.id.gift_game);
        mPager.setAdapter(mAdapter);
        mPager.setOnPageChangeListener(myPageChange);
        introduct_btn.setOnClickListener(myclick);
        comment_btn.setOnClickListener(myclick);
        bbs_btn.setOnClickListener(myclick);
        gift_btn.setOnClickListener(myclick);
    }

    private void initViewPager()
    {
        fragmentsList = new ArrayList<Fragment>();
        Introduct= new GameIntroductActivity();
        Comment = new GameCommentActivity();
        bbs = new GameBBSActivity();
        gift = new GameGiftActivity();
        fragmentsList.add(Introduct);
        fragmentsList.add(Comment);
        fragmentsList.add(bbs);
        fragmentsList.add(gift);
        mAdapter = new GameFragmentPagerAdapter(fManager,fragmentsList);
    }

    //定义一个设置初始状态的方法  
    private void initState()
    {
        introduct_btn.setBackgroundResource(R.drawable.icon_pressed);
        mPager.setCurrentItem(0);
    }




    public class MyOnClick implements OnClickListener
    {
        @Override
        public void onClick(View view) {
            clearChioce();
            iconChange(view.getId());
        }
    }

    public class MyPageChangeListener implements OnPageChangeListener
    {

        @Override
        public void onPageScrollStateChanged(int arg0)
        {
            if(arg0 == 2)
            {
                int i = mPager.getCurrentItem();
                clearChioce();
                iconChange(i);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {}

        @Override
        public void onPageSelected(int index){}

    }



    //建立一个清空选中状态的方法  
    public void clearChioce()
    {
        introduct_btn.setBackgroundResource(R.drawable.icon_no_pressed);
        comment_btn.setBackgroundResource(R.drawable.icon_no_pressed);
        bbs_btn.setBackgroundResource(R.drawable.icon_no_pressed);
        gift_btn.setBackgroundResource(R.drawable.icon_no_pressed);

    }

    //定义一个导航栏图标变化的方法
    public void iconChange(int num)
    {
        switch (num) {
            case R.id.introduct_game:case 0:
                introduct_btn.setBackgroundResource(R.drawable.icon_pressed);
                mPager.setCurrentItem(0);
                break;
            case R.id.comment_game:case 1:
                comment_btn.setBackgroundResource(R.drawable.icon_pressed);
                mPager.setCurrentItem(1);
                break;
            case R.id.bbs_game:case 2:
                bbs_btn.setBackgroundResource(R.drawable.icon_pressed);
                mPager.setCurrentItem(2);
                break;
            case R.id.gift_game:case 3:
                gift_btn.setBackgroundResource(R.drawable.icon_pressed);
                mPager.setCurrentItem(3);
                break;
        }
    }
}  