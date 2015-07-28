package com.qihoo.feiyang.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qihoo.feiyang.challenger.R;
import com.qihoo.feiyang.entity.GameBetaInfo;
import com.qihoo.feiyang.internet.DownLoad;

import java.util.List;

public class ComingBetaAdapter extends BaseAdapter {

    private List<GameBetaInfo> mBetaInfos = null;
    private Context mContext;
    private int[] imgIds = {R.drawable.ico_game1, R.drawable.ico_game2,
            R.drawable.ico_game3, R.drawable.ico_game4, R.drawable.ico_game5,
            R.drawable.ico_game6, R.drawable.ico_game7};

    public ComingBetaAdapter(Context mContext, List<GameBetaInfo> gBetaInfos) {
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
                    R.layout.coming_beta_item, null);
            viewHolder.tvName = (TextView) view
                    .findViewById(R.id.tv_coming_name);
            viewHolder.tvSize = (TextView) view
                    .findViewById(R.id.tv_coming_size);
            viewHolder.tvNum = (TextView) view.findViewById(R.id.tv_coming_num);
            viewHolder.tvInfo = (TextView) view
                    .findViewById(R.id.tv_coming_info);
            viewHolder.ivGameIco = (ImageView) view
                    .findViewById(R.id.iv_coming_game);


            viewHolder.btnRemind = (Button) view
                    .findViewById(R.id.btn_coming_remind);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tvName.setText(this.mBetaInfos.get(position).getgNameStr());
        viewHolder.tvSize.setText("");
        viewHolder.tvNum.setText(mContext.getResources().getString(R.string.open_download));
        viewHolder.tvNum.setTextColor(Color.RED);
        viewHolder.tvInfo.setText("《" + this.mBetaInfos.get(position)
                .getgNameStr() + "》" + mContext.getString(R.string.luandouxiyou));

        viewHolder.ivGameIco.setImageResource(imgIds[this.mBetaInfos.get(
                        position).getgIcoUri()]

        );


        viewHolder.btnRemind.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub


            }
        });
        return view;

    }

    final static class ViewHolder {
        TextView tvName;
        TextView tvSize;
        TextView tvNum;
        TextView tvInfo;
        Button btnRemind;
        ImageView ivGameIco;

    }
}