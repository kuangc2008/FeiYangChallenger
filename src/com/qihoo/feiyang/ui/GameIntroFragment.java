package com.qihoo.feiyang.ui;


import android.support.v4.app.Fragment;
import android.os.Bundle;

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


/**
 * Created by niangang on 2015/7/24.
 */
public class GameIntroFragment extends Fragment implements View.OnClickListener {
    private TextView tvRemind, tvGiftGName;
    private ImageView ivRemind, ivGift;
    private ImageButton ibtnShare, ibtnEnjoy;
    private Button btnDownload;
    //收藏按钮状态
    private boolean is_Enjoy_button_pressed;
    //分享弹出窗口
    private PopupWindow share_popupWindow;
    //弹出窗口的view
    private View popupWindow_view;
    //弹出窗口的表格布局
    private TableLayout popupWindow_tableLayout;

    private View  gameIntroView;

    private RelativeLayout rlDetail,rlGift;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        gameIntroView = inflater.inflate(R.layout.game_info_paper,
                container, false);


        rlDetail = (RelativeLayout) gameIntroView.findViewById(R.id.simple_introduce_remind_details_RLayout);
        rlGift = (RelativeLayout) gameIntroView.findViewById(R.id.simple_introduce_gift_layout);



        tvRemind = (TextView) gameIntroView.findViewById(R.id.simple_introduce_remain_expend);
        ivRemind = (ImageView) gameIntroView.findViewById(R.id.simple_introduce_remain_expend_imageView);
        ivGift = (ImageView) gameIntroView.findViewById(R.id.simple_introduce_gift_arrow_imageView);
        ibtnShare = (ImageButton) gameIntroView.findViewById(R.id.simple_introduce_share_button);
        btnDownload = (Button) gameIntroView.findViewById(R.id.simple_introduce_download_button);
        //收藏按钮
        ibtnEnjoy = (ImageButton) gameIntroView.findViewById(R.id.simple_introduce_favorite_button);
        //分享按钮
        ibtnShare = (ImageButton) gameIntroView.findViewById(R.id.simple_introduce_share_button);


        popupWindow_view = inflater.inflate(R.layout.share_popup_window, container, false);
        popupWindow_tableLayout = (TableLayout)popupWindow_view.findViewById(R.id.share_popup_tablelayout);
        //分享弹出窗口各个图标ImageView
        ImageView weixin_friends_circle_imageView = (ImageView)popupWindow_view.findViewById(R.id.share_popup_weixin_friends_circle_imageView);
        ImageView weixin_imageView = (ImageView)popupWindow_view.findViewById(R.id.share_popup_weixin_imageView);
        ImageView qq_imageView = (ImageView)popupWindow_view.findViewById(R.id.share_popup_qq_imageView);
        ImageView qq_zone_imageView = (ImageView)popupWindow_view.findViewById(R.id.share_popup_qq_zone_imageView);
        ImageView weibo_circle_imageView = (ImageView)popupWindow_view.findViewById(R.id.share_popup_weibo_circle_imageView);
        ImageView copy_links_imageView = (ImageView)popupWindow_view.findViewById(R.id.share_popup_copy_links_imageView);
        ImageView qr_code_imageView = (ImageView)popupWindow_view.findViewById(R.id.share_popup_qr_code_imageView);
        ImageView more_imageView = (ImageView)popupWindow_view.findViewById(R.id.share_popup_more_imageView);


        share_popupWindow = new PopupWindow(popupWindow_view, ViewGroup.LayoutParams.MATCH_PARENT,
               2000);



        is_Enjoy_button_pressed = false;







        tvRemind.setOnClickListener(this);
        ivGift.setOnClickListener(this);
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

        return gameIntroView;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.simple_introduce_remain_expend:


                if (rlDetail.getVisibility() == View.VISIBLE) {
                    tvRemind.setText("展开");
                    ivRemind.setImageResource(R.drawable.arrow_downlad);
                    rlDetail.setVisibility(View.GONE);

                } else {
                    tvRemind.setText("收起");
                    ivRemind.setImageResource(R.drawable.ic_arrow_up);
                    rlDetail.setVisibility(View.VISIBLE);
                }


                break;
            case R.id.simple_introduce_remain_expend_imageView:
                if (rlDetail.getVisibility() == View.VISIBLE) {
                    tvRemind.setText("展开");
                    ivRemind.setImageResource(R.drawable.arrow_downlad);
                    rlDetail.setVisibility(View.GONE);

                } else {
                    tvRemind.setText("收起");
                    ivRemind.setImageResource(R.drawable.ic_arrow_up);
                    rlDetail.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.simple_introduce_gift_layout:


//                Intent intent = new Intent(getActivity(), GameGiftActivity.class);
//                startActivity(intent);



                break;

            case R.id.simple_introduce_favorite_button:
                //已经被收藏
                if (is_Enjoy_button_pressed) {
                    ibtnEnjoy.setImageResource(R.drawable.star_off);
                    is_Enjoy_button_pressed = false;
                }
                //还未收藏
                else {
                    ibtnEnjoy.setImageResource(R.drawable.star_on);
                    is_Enjoy_button_pressed = true;
                }
                break;

            case R.id.simple_introduce_share_button:
                share_popupWindow.showAsDropDown(v);
                share_popupWindow.showAtLocation(gameIntroView,Gravity.BOTTOM,0,0);
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
                Toast.makeText(getActivity(), "分享成功", Toast.LENGTH_SHORT).show();
                share_popupWindow.dismiss();
                break;
        }

    }
}
