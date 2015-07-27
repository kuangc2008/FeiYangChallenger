package com.qihoo.feiyang.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qihoo.feiyang.challenger.R;

/**
 * Created by niangang on 2015/7/24.
 */
public class GameIntroFragment extends Fragment implements View.OnClickListener {
    private TextView tvRemind, tvGiftGName;
    private ImageView ivRemind, ivGift;
    private ImageButton ibtnShare, ibtnEnjoy;
    private Button btnDownload;

    private RelativeLayout rlDetail,rlGift;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View gameIntroView = inflater.inflate(R.layout.game_info_paper,
                container, false);

        rlDetail = (RelativeLayout) gameIntroView.findViewById(R.id.simple_introduce_remind_details_RLayout);
        rlGift = (RelativeLayout) gameIntroView.findViewById(R.id.simple_introduce_gift_layout);


        tvRemind = (TextView) gameIntroView.findViewById(R.id.simple_introduce_remain_expend);
        ivRemind = (ImageView) gameIntroView.findViewById(R.id.simple_introduce_remain_expend_imageView);
        ivGift = (ImageView) gameIntroView.findViewById(R.id.simple_introduce_gift_arrow_imageView);
        ibtnShare = (ImageButton) gameIntroView.findViewById(R.id.simple_introduce_share_button);
        btnDownload = (Button) gameIntroView.findViewById(R.id.simple_introduce_download_button);
        ibtnEnjoy = (ImageButton) gameIntroView.findViewById(R.id.simple_introduce_share_button);










        tvRemind.setOnClickListener(this);
        ivGift.setOnClickListener(this);
        ivRemind.setOnClickListener(this);
        rlGift.setOnClickListener(this);
        return gameIntroView;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.simple_introduce_remain_expend:


                if (rlDetail.getVisibility() == View.VISIBLE) {
                    tvRemind.setText("展开");
                    rlDetail.setVisibility(View.GONE);

                } else {
                    tvRemind.setText("收起");
                    rlDetail.setVisibility(View.VISIBLE);
                }


                break;
            case R.id.simple_introduce_remain_expend_imageView:
                if (rlDetail.getVisibility() == View.VISIBLE) {
                    tvRemind.setText("展开");
                    rlDetail.setVisibility(View.GONE);

                } else {
                    tvRemind.setText("收起");
                    rlDetail.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.simple_introduce_gift_layout:


//                Intent intent = new Intent(getActivity(), GameGiftActivity.class);
//                startActivity(intent);



                break;


        }

    }
}
