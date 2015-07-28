package com.qihoo.feiyang.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;

import com.qihoo.feiyang.app.MyApplication;
import com.qihoo.feiyang.adapter.HoujhFragmentAdapter;
import com.qihoo.feiyang.challenger.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by houjianhua on 2015/7/21.
 */
public class HoujhFragment extends FragmentActivity {

    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private ViewPager viewPager;
    private TextView tvCurr;
    private View viewCurr, viewComing;
    private TextView tvComing;
    private Button btnLogin, btnSearch;
    private HoujhCurrentTestFragment currTestFrag;
    private HoujhComingTestFragment comiTestFrag;
    private HoujhFragmentAdapter fragmentAdapter;
    private boolean isLogin = false;
    private ViewPager adViewPager; // android-support-v4??????????
    private List<ImageView> imageViews; // ????????????
    private int[] imageResId; // ??ID
    private List<View> dots; // ?????????????????

    private int currentItem = 0; // ?????????????
    // An ExecutorService that can schedule commands to run after a given delay,
    // or to execute periodically.
    private ScheduledExecutorService scheduledExecutorService;
    // ??????????????
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            adViewPager.setCurrentItem(currentItem);

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.houjh_fragment_activity);


        Intent intent = getIntent();
        isLogin = intent.getBooleanExtra("isSuccess", false);


        imageResId = new int[]{R.drawable.title_paper1,
                R.drawable.title_paper2, R.drawable.title_paper3};


        imageViews = new ArrayList<ImageView>();
        for (int i = 0; i < imageResId.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imageResId[i]);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageViews.add(imageView);
        }

        dots = new ArrayList<View>();
        dots.add(findViewById(R.id.v_dot0));
        dots.add(findViewById(R.id.v_dot1));
        dots.add(findViewById(R.id.v_dot2));

        adViewPager = (ViewPager) findViewById(R.id.vp);
        adViewPager.setAdapter(new MyAdapter());// ???????ViewPager??????????
        // ?????????????????ViewPager??????????????
        adViewPager.setOnPageChangeListener(new MyPageChangeListener());
        init();
        initState();
    }

    @Override
    protected void onStart() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 2,
                TimeUnit.SECONDS);
        super.onStart();
    }

    @Override
    protected void onStop() {
        scheduledExecutorService.shutdown();
        super.onStop();
    }

    /**
     * ????????????
     *
     * @author Administrator
     */
    private class ScrollTask implements Runnable {

        public void run() {
            synchronized (viewPager) {
                System.out.println("currentItem: " + currentItem);
                currentItem = (currentItem + 1) % imageViews.size();
                handler.obtainMessage().sendToTarget(); // ???Handler??????
            }
        }

    }


    private class MyPageChangeListener implements
            ViewPager.OnPageChangeListener {
        private int oldPosition = 0;

        /**
         * This method will be invoked when a new page becomes selected.
         * position: Position index of the new selected page.
         */
        public void onPageSelected(int position) {
            currentItem = position;
            dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
            dots.get(position).setBackgroundResource(R.drawable.dot_focused);
            oldPosition = position;
        }

        public void onPageScrollStateChanged(int arg0) {

        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }
    }

    @Override
    protected void onResume() {
        super.onResume();


        if (MyApplication.isLogin) {
            btnLogin.setText(" ");
            btnLogin.setBackgroundResource(R.drawable.hyreader_icon);

        }
    }

    /**
     * ???ViewPager??????????
     *
     * @author Administrator
     */
    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageResId.length;
        }

        @Override
        public Object instantiateItem(View arg0, int position) {


            ((ViewPager) arg0).addView(imageViews.get(position));


            imageViews.get(position).setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {

                    Intent gameIntent = new Intent(HoujhFragment.this, GameFragment.class);
                    startActivity(gameIntent);
                }
            });


            return imageViews.get(position);
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {

        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {

        }

        @Override
        public void finishUpdate(View arg0) {

        }
    }

    private void init() {
        viewPager = (ViewPager) this.findViewById(R.id.id_viewpager);
        tvCurr = (TextView) findViewById(R.id.curr_test_textview);
        tvComing = (TextView) findViewById(R.id.comi_test_textview);

        btnLogin = (Button) findViewById(R.id.btn_login);

        viewCurr = findViewById(R.id.view_curr);
        viewComing = findViewById(R.id.view_coming);
        if (MyApplication.isLogin) {
            btnLogin.setText(" ");
            btnLogin.setBackgroundResource(R.drawable.hyreader_icon);

        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MyApplication.isLogin) {

                    Intent pIntent = new Intent(HoujhFragment.this, PersonActivity.class);
                    startActivity(pIntent);

                } else {
                    Intent intent = new Intent(HoujhFragment.this, LoginActivity.class);
                    startActivity(intent);

                }
            }
        });

        currTestFrag = new HoujhCurrentTestFragment();
        comiTestFrag = new HoujhComingTestFragment();
        fragmentAdapter = new HoujhFragmentAdapter(getSupportFragmentManager(),
                fragmentList);
    }

    // initial the FragmentActivity
    private void initState() {
        fragmentList.add(currTestFrag);
        fragmentList.add(comiTestFrag);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setCurrentItem(0);
        tvCurr.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_press));
        tvComing.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_normal));
        viewCurr.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.tab_txt_press));
        viewComing.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.tab_txt_normal));


        viewPager.setOnPageChangeListener(new pageChangeListener());
        tvCurr.setOnClickListener(new IconClickListener());
        tvComing.setOnClickListener(new IconClickListener());

    }

    class pageChangeListener implements ViewPager.OnPageChangeListener {
        // position :?????????????????????? offset:?????????????
        // offsetPixels:??????????????????
        @Override
        public void onPageScrolled(int i, float v, int i1) {
        }

        @Override
        public void onPageSelected(int i) {
            if (0 == i) {
                tvCurr.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_press));
                tvComing.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_normal));
                viewCurr.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.tab_txt_press));
                viewComing.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.tab_txt_normal));


            } else {
                tvComing.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_press));
                tvCurr.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_normal));


                viewComing.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.tab_txt_press));
                viewCurr.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.tab_txt_normal));

            }


        }

        // state?????????? ??????????0??1??2?? 1????????? 2????????? 0?????????
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
            if (viewItem == -1) {
                return;
            } else {
                viewPager.setCurrentItem(viewItem);

            }

        }
    }

    public int viewId2Item(int viewId) {
        int viewItem;
        switch (viewId) {
            case R.id.curr_test_textview:
                viewItem = 0;

                tvCurr.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_press));
                tvComing.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_normal));
                viewCurr.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.tab_txt_press));
                viewComing.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.tab_txt_normal));

                break;
            case R.id.comi_test_textview:

                tvComing.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_press));
                tvCurr.setTextColor(getApplicationContext().getResources().getColor(R.color.tab_txt_normal));


                viewComing.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.tab_txt_press));
                viewCurr.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.tab_txt_normal));


                viewItem = 1;
                break;
            default:
                viewItem = -1;
        }
        return viewItem;
    }
}
