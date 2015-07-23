package com.qihoo.feiyang.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import com.qihoo.feiyang.challenger.R;

/**
 * Created by maxiaowei on 2015/7/23.
 * 简介(simple_introduce)页面的activity
 */
public class simple_introduce_test_activity_mxw extends Activity
{
    private boolean is_favorite_button_pressed = false;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maxw_simple_introduce_layout);

        /*提醒详情的展开按钮控制---------------------------------------------*/
        //展开文字textView
        TextView remain_expend_textView = (TextView)findViewById(R.id.simple_introduce_remain_expend);
        //textView单击响应
        remain_expend_textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                //提醒详情布局句柄
                View remind_details = (View) findViewById(R.id.simple_introduce_remind_details_RLayout);
                //箭头图片ImageView
                ImageView remain_expend_imageView = (ImageView) findViewById(R.id.simple_introduce_remain_expend_imageView);
                //页面处于展开状态
                if (remind_details.getVisibility() == View.VISIBLE) {
                    //收起
                    remind_details.setVisibility(View.GONE);
                    //修改textView文字
                    remain_expend_textView.setText(R.string.expend);
                    //修改箭头图标
                    remain_expend_imageView.setImageResource(R.drawable.arrow_downlad);
                    Log.v("debug", "unexpend");
                }
                //页面处于收起状态
                else {
                    //展开
                    remind_details.setVisibility(View.VISIBLE);
                    //修改textView文字
                    remain_expend_textView.setText(R.string.unexpend);
                    //修改箭头图标
                    remain_expend_imageView.setImageResource(R.drawable.arrow_up);
                    Log.v("debug", "expend");
                }
            }
        });
        /*--------------------------------------------------------------------------*/

        /*应用描述的展开按钮控制---------------------------------------------*/
        //展开文字textView
        TextView app_introduce_expend_textView = (TextView)findViewById(R.id.simple_introduce_app_introduce_expend);
        //textView单击响应
        app_introduce_expend_textView.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                //应用介绍详情布局句柄
                View app_introduce_details = (View)findViewById(R.id.simple_introduce_app_introduce_details);
                //箭头图片ImageView
                ImageView app_introduce_expend_imageView = (ImageView)findViewById(R.id.simple_introduce_app_introduce_expend_imageView);
                //页面处于展开状态
                if(app_introduce_details.getVisibility() == View.VISIBLE)
                {
                    //收起
                    app_introduce_details.setVisibility(View.GONE);
                    //修改textView文字
                    app_introduce_expend_textView.setText(R.string.expend);
                    //修改箭头图标
                    app_introduce_expend_imageView.setImageResource(R.drawable.arrow_downlad);
                    Log.v("debug", "unexpend");
                }
                //页面处于收起状态
                else
                {
                    //展开
                    app_introduce_details.setVisibility(View.VISIBLE);
                    //修改textView文字
                    app_introduce_expend_textView.setText(R.string.unexpend);
                    //修改箭头图标
                    app_introduce_expend_imageView.setImageResource(R.drawable.arrow_up);
                    Log.v("debug", "expend");
                }
            }
        });
        /*----------------------------------------------------------------------------*/

        /*举报按钮控制---------------------------------------------------------------*/
        //举报按钮
        Button complain_button = (Button)findViewById(R.id.simple_introduce_complain_button);
        //textView单击响应
        complain_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                Log.v("debug", "comlain_button");
                showString("点击了举报按钮");
            }
        });
        /*----------------------------------------------------------------------------*/

        /*查看更多按钮控制---------------------------------------------------------------*/
        //查看更多textView
        TextView other_like_more_button = (TextView)findViewById(R.id.simple_introduce_other_like_more);
        //textView单击响应
        other_like_more_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                Log.v("debug", "other_like_more");
                showString("查看更多按钮");
            }
        });
        /*----------------------------------------------------------------------------*/

        /*游戏1下载按钮控制---------------------------------------------------------------*/
        //查看更多textView
        Button other_like_game1_button = (Button)findViewById(R.id.simple_introduce_other_like_game1_button);
        //textView单击响应
        other_like_game1_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                Log.v("debug", "game1_download");
                showString("游戏1下载按钮");
            }
        });
        /*----------------------------------------------------------------------------*/


        /*游戏1下载按钮控制---------------------------------------------------------------*/
        //查看更多textView
        Button other_like_game2_button = (Button)findViewById(R.id.simple_introduce_other_like_game2_button);
        //textView单击响应
        other_like_game2_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                Log.v("debug", "game2_download");
                showString("游戏2下载按钮");
            }
        });
        /*----------------------------------------------------------------------------*/


        /*游戏1下载按钮控制---------------------------------------------------------------*/
        //“查看更多”textView
        Button other_like_game3_button = (Button)findViewById(R.id.simple_introduce_other_like_game3_button);
        //textView单击响应
        other_like_game3_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                Log.v("debug", "game3_download");
                showString("游戏3下载按钮");
            }
        });
        /*----------------------------------------------------------------------------*/


        /*游戏礼包框架点击控制---------------------------------------------------------------*/
        //游戏礼包框架View
        View gift_layout = (View)findViewById(R.id.simple_introduce_gift_layout);
        //textView单击响应
        gift_layout.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                Log.v("debug", "gift_layout");
                showString("点击了游戏礼包布局");
            }
        });
        /*----------------------------------------------------------------------------*/


        /*游戏标签按钮1点击控制---------------------------------------------------------------*/
        //游戏标签第一个按钮--动作
        Button app_tag1_button = (Button)findViewById(R.id.simple_introduce_app_tag1_button);
        //textView单击响应
        app_tag1_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                Log.v("debug", "app_tag1_button");
                showString("点击了游戏标签第一个按钮-动作");
            }
        });
        /*----------------------------------------------------------------------------*/


        /*游戏标签按钮2点击控制---------------------------------------------------------------*/
        //游戏标签第二个按钮--动作
        Button app_tag2_button = (Button)findViewById(R.id.simple_introduce_app_tag2_button);
        //textView单击响应
        app_tag2_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                Log.v("debug", "app_tag1_button");
                showString("点击了游戏标签第二个按钮-平台游戏");
            }
        });
        /*----------------------------------------------------------------------------*/

        /*“查看更多版本”点击控制---------------------------------------------------------------*/
        //查看更多版本textV
        TextView vision_more = (TextView)findViewById(R.id.simple_introduce_version_more);
        //textView单击响应
        vision_more.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                Log.v("debug", "vision_more");
                showString("点击了查看更多版本按钮");
            }
        });
        /*----------------------------------------------------------------------------*/



        /*底部栏分享按钮点击控制---------------------------------------------------------------*/
        //分享按钮
        ImageButton share_button = (ImageButton)findViewById(R.id.simple_introduce_share_button);
        //textView单击响应
        share_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                Log.v("debug", "share_button");
                showString("点击了底部栏分享按钮");
            }
        });
        /*----------------------------------------------------------------------------*/


        /*底部栏下载按钮点击控制---------------------------------------------------------------*/
        //下载按钮
        Button download_button = (Button)findViewById(R.id.simple_introduce_download_button);
        //textView单击响应
        download_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                Log.v("debug", "download_button");
                showString("点击了底部栏下载按钮");
            }
        });
        /*----------------------------------------------------------------------------*/



        /*底部栏收藏按钮点击控制---------------------------------------------------------------*/
        //收藏按钮
        ImageButton favorite_button = (ImageButton)findViewById(R.id.simple_introduce_favorite_button);
        //textView单击响应
        favorite_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                //已经被收藏
                if(is_favorite_button_pressed)
                {
                    favorite_button.setImageResource(R.drawable.star_off);
                    is_favorite_button_pressed = false;
                }
                //还未收藏
                else
                {
                    favorite_button.setImageResource(R.drawable.star_on);
                    is_favorite_button_pressed = true;
                }
                Log.v("debug", "favorite_button");
                showString("点击了底部栏收藏按钮");
            }
        });
        /*----------------------------------------------------------------------------*/


    }

    private void showString(String input)
    {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage(input).create();
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);  //此处可以设置dialog显示的位置
        dialog.show();
    }
}
