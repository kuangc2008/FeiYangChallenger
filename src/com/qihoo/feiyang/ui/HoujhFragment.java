package com.qihoo.feiyang.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;

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
    private TextView curr_test;
    private TextView comi_test;
    private HoujhCurrentTestFragment currTestFrag;
    private HoujhComingTestFragment comiTestFrag;
    private HoujhFragmentAdapter fragmentAdapter;

    private ViewPager adViewPager; // android-support-v4中的滑动组件
    private List<ImageView> imageViews; // 滑动的图片集合
    private int[] imageResId; // 图片ID
    private List<View> dots; // 图片标题正文的那些点

    private int currentItem = 0; // 当前图片的索引号
    // An ExecutorService that can schedule commands to run after a given delay,
    // or to execute periodically.
    private ScheduledExecutorService scheduledExecutorService;
    // 切换当前显示的图片
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            adViewPager.setCurrentItem(currentItem);// 切换当前显示的图片
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.houjh_fragment_activity);
        imageResId = new int[]{R.drawable.title_paper1,
                R.drawable.title_paper2, R.drawable.title_paper3};

        imageViews = new ArrayList<ImageView>();
        // 初始化图片资源
        for (int i = 0; i < imageResId.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imageResId[i]);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageViews.add(imageView);
        }

        // 点
        dots = new ArrayList<View>();
        dots.add(findViewById(R.id.v_dot0));
        dots.add(findViewById(R.id.v_dot1));
        dots.add(findViewById(R.id.v_dot2));

        adViewPager = (ViewPager) findViewById(R.id.vp);
        adViewPager.setAdapter(new MyAdapter());// 设置填充ViewPager页面的适配器
        // 设置一个监听器，当ViewPager中的页面改变时调用
        adViewPager.setOnPageChangeListener(new MyPageChangeListener());
        init();
        initState();
    }

    @Override
    protected void onStart() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // 当Activity显示出来后，每两秒钟切换一次图片显示
        scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 2,
                TimeUnit.SECONDS);
        super.onStart();
    }

    @Override
    protected void onStop() {
        // 当Activity不可见的时候停止切换
        scheduledExecutorService.shutdown();
        super.onStop();
    }

    /**
     * 换行切换任务
     *
     * @author Administrator
     */
    private class ScrollTask implements Runnable {

        public void run() {
            synchronized (viewPager) {
                System.out.println("currentItem: " + currentItem);
                currentItem = (currentItem + 1) % imageViews.size();
                handler.obtainMessage().sendToTarget(); // 通过Handler切换图片
            }
        }

    }

    /**
     * 当ViewPager中页面的状态发生改变时调用
     *
     * @author Administrator
     */
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

    /**
     * 填充ViewPager页面的适配器
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


                    Toast.makeText(getApplicationContext(), position+"  ", Toast.LENGTH_SHORT).show();

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
        curr_test = (TextView) this.findViewById(R.id.curr_test_textview);
        comi_test = (TextView) this.findViewById(R.id.comi_test_textview);
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
        viewPager.setOnPageChangeListener(new pageChangeListener());
        curr_test.setOnClickListener(new IconClickListener());
        comi_test.setOnClickListener(new IconClickListener());
    }

    class pageChangeListener implements ViewPager.OnPageChangeListener {
        // position :当前页面，及你点击滑动的页面 offset:当前页面偏移的百分比
        // offsetPixels:当前页面偏移的像素位置
        @Override
        public void onPageScrolled(int i, float v, int i1) {
        }

        @Override
        public void onPageSelected(int i) {
        }

        // state滑动中的状态 有三种状态（0，1，2） 1：正在滑动 2：滑动完毕 0：什么都没做
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
                break;
            case R.id.comi_test_textview:
                viewItem = 1;
                break;
            default:
                viewItem = -1;
        }
        return viewItem;
    }
}
