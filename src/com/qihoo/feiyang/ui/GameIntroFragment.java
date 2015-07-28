package com.qihoo.feiyang.ui;


import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qihoo.feiyang.challenger.R;
import com.qihoo.feiyang.internet.DownLoad;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * Created by niangang on 2015/7/24.
 */
public class GameIntroFragment extends Fragment implements View.OnClickListener {
    private TextView tvRemind, tvGiftGName, tv_app_introduce_expend, tv_introduce_details;
    private ImageView ivRemind, ivGift, iv_app_introduce_expend;
    private ImageButton ibtnShare, ibtnEnjoy;
    private Button btnDownload;
    //???????
    private boolean is_Enjoy_button_pressed;
    private PopupWindow share_popupWindow;
    //?????????view
    private View popupWindow_view;
    //????????????
    private TableLayout popupWindow_tableLayout;

    private View gameIntroView;

    private RelativeLayout rlDetail, rlGift;
    private int[] imageResId; // ??ID

    private List<ImageView> imageViews; // ????????????


    private ViewPager viewPager;

    private int currentItem = 0; // ?????????????
    // An ExecutorService that can schedule commands to run after a given delay,
    // or to execute periodically.
    private ScheduledExecutorService scheduledExecutorService;
    // ??????????????
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            viewPager.setCurrentItem(currentItem);

        }

    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        gameIntroView = inflater.inflate(R.layout.game_info_paper,
                container, false);


        rlDetail = (RelativeLayout) gameIntroView.findViewById(R.id.simple_introduce_remind_details_RLayout);
        rlGift = (RelativeLayout) gameIntroView.findViewById(R.id.simple_introduce_gift_layout);


        tvRemind = (TextView) gameIntroView.findViewById(R.id.simple_introduce_remain_expend);
        ivRemind = (ImageView) gameIntroView.findViewById(R.id.simple_introduce_remain_expend_imageView);
        ibtnShare = (ImageButton) gameIntroView.findViewById(R.id.simple_introduce_share_button);
        btnDownload = (Button) gameIntroView.findViewById(R.id.simple_introduce_download_button);
        //?????
        ibtnEnjoy = (ImageButton) gameIntroView.findViewById(R.id.simple_introduce_favorite_button);
        //?????
        ibtnShare = (ImageButton) gameIntroView.findViewById(R.id.simple_introduce_share_button);


        popupWindow_view = inflater.inflate(R.layout.share_popup_window, container, false);
        popupWindow_tableLayout = (TableLayout) popupWindow_view.findViewById(R.id.share_popup_tablelayout);

        //????????????????ImageView
        ImageView weixin_friends_circle_imageView = (ImageView) popupWindow_view.findViewById(R.id.share_popup_weixin_friends_circle_imageView);
        ImageView weixin_imageView = (ImageView) popupWindow_view.findViewById(R.id.share_popup_weixin_imageView);
        ImageView qq_imageView = (ImageView) popupWindow_view.findViewById(R.id.share_popup_qq_imageView);
        ImageView qq_zone_imageView = (ImageView) popupWindow_view.findViewById(R.id.share_popup_qq_zone_imageView);
        ImageView weibo_circle_imageView = (ImageView) popupWindow_view.findViewById(R.id.share_popup_weibo_circle_imageView);
        ImageView copy_links_imageView = (ImageView) popupWindow_view.findViewById(R.id.share_popup_copy_links_imageView);
        ImageView qr_code_imageView = (ImageView) popupWindow_view.findViewById(R.id.share_popup_qr_code_imageView);
        ImageView more_imageView = (ImageView) popupWindow_view.findViewById(R.id.share_popup_more_imageView);


        share_popupWindow = new PopupWindow(popupWindow_view, ViewGroup.LayoutParams.MATCH_PARENT,
                2000);


        is_Enjoy_button_pressed = false;


        tvRemind.setOnClickListener(this);
        ivRemind.setOnClickListener(this);
        rlGift.setOnClickListener(this);
        ibtnShare.setOnClickListener(this);
        ibtnEnjoy.setOnClickListener(this);
        popupWindow_tableLayout.setOnClickListener(this);

        weixin_friends_circle_imageView.setOnClickListener(this);
        weixin_imageView.setOnClickListener(this);
        qq_imageView.setOnClickListener(this);
        qq_zone_imageView.setOnClickListener(this);
        weibo_circle_imageView.setOnClickListener(this);
        copy_links_imageView.setOnClickListener(this);
        qr_code_imageView.setOnClickListener(this);
        more_imageView.setOnClickListener(this);
        btnDownload.setOnClickListener(this);


        imageResId = new int[]{R.drawable.title_paper1,
                R.drawable.title_paper2, R.drawable.title_paper3};

        imageViews = new ArrayList<ImageView>();
        for (int i = 0; i < imageResId.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(imageResId[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViews.add(imageView);
        }


        viewPager = (ViewPager) gameIntroView.findViewById(R.id.id_viewpager1);
        viewPager.setAdapter(new MyAdapter());// ???????ViewPager??????????
        // ?????????????????ViewPager??????????????
//        viewPager.setOnPageChangeListener(new MyPageChangeListener());
        return gameIntroView;
    }


    @Override
    public void onStart() {
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 2,
                TimeUnit.SECONDS);
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

    @Override
    public void onStop() {
        scheduledExecutorService.shutdown();
        super.onStop();
    }


    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageResId.length;
        }

        @Override
        public Object instantiateItem(View arg0, int position) {


            ((ViewPager) arg0).addView(imageViews.get(position));


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

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.simple_introduce_remain_expend:


                if (rlDetail.getVisibility() == View.VISIBLE) {
                    tvRemind.setText(getString(R.string.expend));
                    ivRemind.setImageResource(R.drawable.arrow_downlad);
                    rlDetail.setVisibility(View.GONE);

                } else {
                    tvRemind.setText(getString(R.string.unexpend));
                    ivRemind.setImageResource(R.drawable.ic_arrow_up);
                    rlDetail.setVisibility(View.VISIBLE);
                }


                break;
            case R.id.simple_introduce_remain_expend_imageView:
                if (rlDetail.getVisibility() == View.VISIBLE) {
                    tvRemind.setText(getString(R.string.expend));
                    ivRemind.setImageResource(R.drawable.arrow_downlad);
                    rlDetail.setVisibility(View.GONE);

                } else {
                    tvRemind.setText(getString(R.string.unexpend));
                    ivRemind.setImageResource(R.drawable.ic_arrow_up);
                    rlDetail.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.simple_introduce_gift_layout:


                break;


            case R.id.simple_introduce_favorite_button:
                //????????
                if (is_Enjoy_button_pressed) {
                    ibtnEnjoy.setImageResource(R.drawable.star_off);
                    is_Enjoy_button_pressed = false;
                }
                //??¦Ä???
                else {
                    ibtnEnjoy.setImageResource(R.drawable.star_on);
                    is_Enjoy_button_pressed = true;
                }
                break;

            case R.id.simple_introduce_share_button:
                share_popupWindow.showAsDropDown(v);
                share_popupWindow.showAtLocation(gameIntroView, Gravity.BOTTOM, 0, 0);
                break;

            case R.id.share_popup_tablelayout:
                share_popupWindow.dismiss();
                break;

            case R.id.share_popup_weixin_friends_circle_imageView:
            case R.id.share_popup_weixin_imageView:
            case R.id.share_popup_qq_imageView:
            case R.id.share_popup_qq_zone_imageView:
            case R.id.share_popup_weibo_circle_imageView:
            case R.id.share_popup_copy_links_imageView:
            case R.id.share_popup_qr_code_imageView:
            case R.id.share_popup_more_imageView:
                Toast.makeText(getActivity(), R.string.ng_share_more, Toast.LENGTH_SHORT).show();
                share_popupWindow.dismiss();
                break;
            case R.id.simple_introduce_download_button:
                String uri = "http://gdown.baidu.com/data/wisegame/4ae6d2d7378e6cdf/QQ_122.apk ";

                try {
                    DownLoad downLoad = new DownLoad(getActivity(), uri);
                    if (downLoad.checkFileExit()) {
                        Toast.makeText(getActivity(), "you have already has the APK.", Toast.LENGTH_SHORT).show();
                    } else {
                        downLoad.processDownLoad();
                    }
                } catch (Exception e) {

                    Toast.makeText(getActivity(), "download Error", Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }
}
