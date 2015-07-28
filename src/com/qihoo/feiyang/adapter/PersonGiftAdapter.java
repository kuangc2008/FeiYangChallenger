package com.qihoo.feiyang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.qihoo.feiyang.challenger.R;
import com.qihoo.feiyang.entity.GameBetaInfo;

import java.util.List;

public class PersonGiftAdapter extends BaseAdapter {

    private List<GameBetaInfo> mBetaInfos = null;
    private Context mContext;
    private int[] imgIds = {R.drawable.ico_game1, R.drawable.ico_game2,
            R.drawable.ico_game3, R.drawable.ico_game4, R.drawable.ico_game5,
            R.drawable.ico_game6, R.drawable.ico_game7};

    public PersonGiftAdapter(Context mContext, List<GameBetaInfo> gBetaInfos) {
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
        viewHolder.btnMoreInfo.setVisibility(View.GONE);

        return view;

    }

    final static class ViewHolder {
        TextView tvName;

        Button btnMoreInfo;


    }
}