package com.qihoo.feiyang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.qihoo.feiyang.challenger.R;
import com.qihoo.feiyang.util.HoujhCurrTestViewHolder;

/**
 * Created by houjianhua on 2015/7/21.
 */
public class HoujhCurrTestAdapter extends BaseAdapter {

    private LayoutInflater minflater;

    public HoujhCurrTestAdapter(Context context) {
        minflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HoujhCurrTestViewHolder holder = null;
        if(convertView == null){
            holder = new HoujhCurrTestViewHolder();
            convertView = (View)minflater.inflate(R.layout.houjh_curr_test_item,null);
            holder.nameView = (TextView) convertView.findViewById(R.id.game_name);
            holder.timesView = (TextView) convertView.findViewById(R.id.game_times);
            holder.introductionView = (TextView) convertView.findViewById(R.id.game_introduction);
            holder.spaceView = (TextView) convertView.findViewById(R.id.game_space);
            holder.downloadButton = (Button) convertView.findViewById(R.id.game_download);
            convertView.setTag(holder);
        }else{
            holder = (HoujhCurrTestViewHolder) convertView.getTag();
        }
        holder.nameView.setText("11111");
        holder.timesView.setText("2222");
        holder.introductionView.setText("333");
        holder.spaceView.setText("444");
        holder.downloadButton.setText("555");

        return convertView;
    }
}
