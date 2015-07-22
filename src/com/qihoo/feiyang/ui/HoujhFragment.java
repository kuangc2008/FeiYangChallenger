package com.qihoo.feiyang.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.qihoo.feiyang.adapter.HoujhFragmentAdapter;
import com.qihoo.feiyang.challenger.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houjianhua on 2015/7/21.
 */
public class HoujhFragment extends FragmentActivity {

    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private ViewPager viewPager;
    private TextView curr_test;
    private TextView comi_test;
    private HoujhCurrentTestFragment currTestFrag;
    private HoujhComingTestFragment comiTestFrag;
    private HoujhFragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.houjh_fragment_activity);
        init();
        initState();
    }

    private  void init(){
        viewPager = (ViewPager) this.findViewById(R.id.id_viewpager);
        curr_test = (TextView) this.findViewById(R.id.curr_test_textview);
        comi_test = (TextView) this.findViewById(R.id.comi_test_textview);
        currTestFrag = new HoujhCurrentTestFragment();
        comiTestFrag = new HoujhComingTestFragment();
        fragmentAdapter = new HoujhFragmentAdapter(getSupportFragmentManager(), fragmentList);
    }

    //initial the FragmentActivity
    private void initState(){
        fragmentList.add(currTestFrag);
        fragmentList.add(comiTestFrag);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new pageChangeListener());
        curr_test.setOnClickListener(new IconClickListener());
        comi_test.setOnClickListener(new IconClickListener());
    }

    class pageChangeListener implements ViewPager.OnPageChangeListener{
        //position :当前页面，及你点击滑动的页面 offset:当前页面偏移的百分比
        // offsetPixels:当前页面偏移的像素位置
        @Override
        public void onPageScrolled(int i, float v, int i1) {}

        @Override
        public void onPageSelected(int i) {}

        //state滑动中的状态 有三种状态（0，1，2） 1：正在滑动 2：滑动完毕 0：什么都没做
        @Override
        public void onPageScrollStateChanged(int i) {
            if (i == 2) {
                int pageNum = viewPager.getCurrentItem();
                viewPager.setCurrentItem(pageNum);
            }
        }
    }

    class IconClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            int viewId = v.getId();
            int viewItem = viewId2Item(viewId);
            if(viewItem == -1){
                return;
            }else{
                viewPager.setCurrentItem(viewItem);
            }

        }
    }
    public int viewId2Item(int viewId){
        int viewItem;
        switch (viewId){
            case R.id.curr_test_textview:
                viewItem = 0;
                break;
            case R.id.comi_test_textview:
                viewItem = 1;
                break;
            default: viewItem = -1;
        }
        return viewItem;
    }
}
