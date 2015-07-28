package com.qihoo.feiyang.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.qihoo.feiyang.app.MyApplication;
import com.qihoo.feiyang.challenger.R;
import com.qihoo.feiyang.entity.GameBetaInfo;
import com.qihoo.feiyang.ui.LoginActivity;

import java.util.List;

public class GameGiftAdapter extends BaseAdapter {

    private List<GameBetaInfo> mBetaInfos = null;
    private Context mContext;
    private PopupWindow popupWindow;
    private int[] imgIds = {R.drawable.ico_game1, R.drawable.ico_game2,
            R.drawable.ico_game3, R.drawable.ico_game4, R.drawable.ico_game5,
            R.drawable.ico_game6, R.drawable.ico_game7};

    public GameGiftAdapter(Context mContext, List<GameBetaInfo> gBetaInfos) {
        this.mContext = mContext;
        this.mBetaInfos = gBetaInfos;

    }

    public int getCount() {
        return this.mBetaInfos.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup arg2) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(
                    R.layout.game_gift_item, null);
            viewHolder.tvName = (TextView) view
                    .findViewById(R.id.tv_gift_name);

            viewHolder.btnMoreInfo = (Button) view
                    .findViewById(R.id.btn_gift_receive);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tvName.setText(this.mBetaInfos.get(position).getgNameStr());

//
        viewHolder.btnMoreInfo.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                if(MyApplication.isLogin == true) {

            showPopupWindow(v);
            }
             else
            {
            Intent returnToLogin = new Intent(mContext, LoginActivity.class);
            mContext.startActivity(returnToLogin);
         }

         }
      });

        return view;

    }
    public void showPopupWindow(View view){
        final View contentView = LayoutInflater.from(mContext).inflate(
                R.layout.cy_gift_introduct_activity_main, null);

        popupWindow = new PopupWindow(contentView,ViewGroup.LayoutParams.WRAP_CONTENT
                , ViewGroup.LayoutParams.WRAP_CONTENT, true);
        final Button get_gift_btn=(Button)contentView.findViewById(R.id.get_gift_button);
        final Button cancel_btn=(Button)contentView.findViewById(R.id.cancel_button);
        get_gift_btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                giftNumberShowPopupWindow(contentView);
            }
        });

        popupWindow.setTouchable(true);
        cancel_btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                popupWindow.dismiss();
            }
        });
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Log.i("mengdd", "onTouch : ");

                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(mContext.getResources().getDrawable(
                R.drawable.white));
        popupWindow.showAtLocation(contentView, Gravity.CENTER, 0, 0);
        popupWindow.showAsDropDown(view);

    }
    public void giftNumberShowPopupWindow(View view){
        final View contentViewget = LayoutInflater.from(mContext).inflate(
                R.layout.cy_gift_number, null);
        final PopupWindow giftnumberpopupWindow = new PopupWindow(contentViewget,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        final Button giftNumber=(Button)contentViewget.findViewById(R.id.gift_number_button);

        giftnumberpopupWindow.setTouchable(true);
        giftnumberpopupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Log.i("mengdd", "onTouch : ");

                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        giftnumberpopupWindow.setBackgroundDrawable(mContext.getResources().getDrawable(
                R.drawable.white));
        giftnumberpopupWindow.showAtLocation(contentViewget, Gravity.CENTER, 0, 0);
        giftnumberpopupWindow.showAsDropDown(view);
        giftNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (giftnumberpopupWindow != null) {
                    giftnumberpopupWindow.dismiss();
                    popupWindow.dismiss();
                }

            }
        });
    }

    final class ViewHolder {
        TextView tvName;

        Button btnMoreInfo;


    }
}