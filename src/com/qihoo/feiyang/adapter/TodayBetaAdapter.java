package com.qihoo.feiyang.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.widget.ProgressWheel;
import com.qihoo.feiyang.challenger.R;
import com.qihoo.feiyang.entity.GameBetaInfo;
import com.qihoo.feiyang.internet.DownLoad;
import com.qihoo.feiyang.thread.ProgressWheelThread;

import java.util.ArrayList;
import java.util.List;


public class TodayBetaAdapter extends BaseAdapter {
    boolean wheelRunning;
    int wheelProgress = 0;
    ViewHolder finalViewHolder;
    private List<View> listBtn;
    private List<GameBetaInfo> mGameBetaInfos = null;
    private Context mContext;
    private int[] imgIds = {R.drawable.ico_game1, R.drawable.ico_game2,
            R.drawable.ico_game3, R.drawable.ico_game4, R.drawable.ico_game5,
            R.drawable.ico_game6, R.drawable.ico_game7};

    public TodayBetaAdapter(Context mContext, List<GameBetaInfo> gBetaInfos) {
        this.mContext = mContext;
        this.mGameBetaInfos = gBetaInfos;
        listBtn = new ArrayList<View>();

    }

    public int getCount() {
        return this.mGameBetaInfos.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View view, ViewGroup arg2) {
        final ViewHolder viewHolder;


        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(
                    R.layout.today_beta_item, null);
            viewHolder.tvName = (TextView) view
                    .findViewById(R.id.tv_today_name);
            viewHolder.tvSize = (TextView) view
                    .findViewById(R.id.tv_today_size);
            viewHolder.tvNum = (TextView) view.findViewById(R.id.tv_today_num);
            viewHolder.tvInfo = (TextView) view
                    .findViewById(R.id.tv_today_info);
            viewHolder.ivGameIco = (ImageView) view
                    .findViewById(R.id.iv_today_game);

            viewHolder.btnDownLoad = (Button) view
                    .findViewById(R.id.btn_today_beta);
            viewHolder.progressWheel = (ProgressWheel) view.findViewById(R.id.progress_bar_two);

            listBtn.add(view);
            view.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.tvName.setText(this.mGameBetaInfos.get(position)
                .getgNameStr());
        viewHolder.tvSize.setText("|  " + this.mGameBetaInfos.get(position).getgSize());
        viewHolder.tvNum.setText(this.mGameBetaInfos.get(position).getgNum()
                + mContext.getResources()
                .getString(R.string.download_num));
        viewHolder.tvInfo.setText("《" + this.mGameBetaInfos.get(position)
                .getgNameStr() + "》" + mContext.getString(R.string.luandouxiyou));

        viewHolder.ivGameIco.setImageResource(imgIds[this.mGameBetaInfos.get(
                position).getgIcoUri()]);

        viewHolder.btnDownLoad.setClickable(this.mGameBetaInfos.get(position)
                .isDown());


        viewHolder.btnDownLoad.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                String uri = "http://gdown.baidu.com/data/wisegame/4ae6d2d7378e6cdf/QQ_122.apk";
                DownLoad downLoad = new DownLoad(mContext, uri);
                if (downLoad.checkFileExit()) {
                    Toast.makeText(mContext, "you have already has the APK.", Toast.LENGTH_SHORT).show();
                } else {
                    downLoad.processDownLoad();
                }

            }
        });


        return view;

    }

    static class ViewHolder {
        TextView tvName;
        TextView tvSize;
        TextView tvNum;
        TextView tvInfo;
        Button btnDownLoad;
        ImageView ivGameIco;
        ProgressWheel progressWheel;

    }


}