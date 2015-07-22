package com.qihoo.feiyang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.qihoo.feiyang.challenger.R;
import com.qihoo.feiyang.util.HoujhComiTestViewHolder;

/**
 * Created by houjianhua on 2015/7/21.
 */
public class HoujhComiTestAdapter extends BaseAdapter {

    private LayoutInflater minflater;

    public HoujhComiTestAdapter(Context context) {
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
        HoujhComiTestViewHolder holder = null;
        if(convertView == null){
            holder = new HoujhComiTestViewHolder();
            convertView = (View)minflater.inflate(R.layout.houjh_comi_test_item,null);
            holder.nameView = (TextView) convertView.findViewById(R.id.game_name);
            holder.timesView = (TextView) convertView.findViewById(R.id.game_times);
            holder.introductionView = (TextView) convertView.findViewById(R.id.game_introduction);
            holder.spaceView = (TextView) convertView.findViewById(R.id.game_space);
            holder.detailsButton = (Button) convertView.findViewById(R.id.game_details);
            holder.remindButton = (Button) convertView.findViewById(R.id.game_remind);
            convertView.setTag(holder);
        }else{
            holder = (HoujhComiTestViewHolder) convertView.getTag();
        }
        holder.nameView.setText("1111122");
        holder.timesView.setText("222222");
        holder.introductionView.setText("33322");
        holder.spaceView.setText("44422");
        holder.detailsButton.setText("55522");
        holder.remindButton.setText("66622");
        return convertView;
    }
}
