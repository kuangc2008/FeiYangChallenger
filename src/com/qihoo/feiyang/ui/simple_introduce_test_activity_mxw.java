package com.qihoo.feiyang.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import com.qihoo.feiyang.challenger.R;

/**
 * Created by maxiaowei on 2015/7/23.
 * ���(simple_introduce)ҳ���activity
 */
public class simple_introduce_test_activity_mxw extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maxw_simple_introduce_layout);

        /*���������չ����ť����---------------------------------------------*/
        //չ������textView
        TextView remain_expend_textView = (TextView)findViewById(R.id.simple_introduce_remain_expend);
        //textView������Ӧ
        remain_expend_textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                //�������鲼�־��
                View remind_details = (View) findViewById(R.id.simple_introduce_remind_details_RLayout);
                //��ͷͼƬImageView
                ImageView remain_expend_imageView = (ImageView) findViewById(R.id.simple_introduce_remain_expend_imageView);
                //ҳ�洦��չ��״̬
                if (remind_details.getVisibility() == View.VISIBLE) {
                    //����
                    remind_details.setVisibility(View.GONE);
                    //�޸�textView����
                    remain_expend_textView.setText(R.string.expend);
                    //�޸ļ�ͷͼ��
                    remain_expend_imageView.setImageResource(R.drawable.arrow_downlad);
                    Log.v("debug", "unexpend");
                }
                //ҳ�洦������״̬
                else {
                    //չ��
                    remind_details.setVisibility(View.VISIBLE);
                    //�޸�textView����
                    remain_expend_textView.setText(R.string.unexpend);
                    //�޸ļ�ͷͼ��
                    remain_expend_imageView.setImageResource(R.drawable.arrow_up);
                    Log.v("debug", "expend");
                }
            }
        });
        /*--------------------------------------------------------------------------*/

        /*Ӧ��������չ����ť����---------------------------------------------*/
        //չ������textView
        TextView app_introduce_expend_textView = (TextView)findViewById(R.id.simple_introduce_app_introduce_expend);
        //textView������Ӧ
        app_introduce_expend_textView.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                //Ӧ�ý������鲼�־��
                View app_introduce_details = (View)findViewById(R.id.simple_introduce_app_introduce_details);
                //��ͷͼƬImageView
                ImageView app_introduce_expend_imageView = (ImageView)findViewById(R.id.simple_introduce_app_introduce_expend_imageView);
                //ҳ�洦��չ��״̬
                if(app_introduce_details.getVisibility() == View.VISIBLE)
                {
                    //����
                    app_introduce_details.setVisibility(View.GONE);
                    //�޸�textView����
                    app_introduce_expend_textView.setText(R.string.expend);
                    //�޸ļ�ͷͼ��
                    app_introduce_expend_imageView.setImageResource(R.drawable.arrow_downlad);
                    Log.v("debug", "unexpend");
                }
                //ҳ�洦������״̬
                else
                {
                    //չ��
                    app_introduce_details.setVisibility(View.VISIBLE);
                    //�޸�textView����
                    app_introduce_expend_textView.setText(R.string.unexpend);
                    //�޸ļ�ͷͼ��
                    app_introduce_expend_imageView.setImageResource(R.drawable.arrow_up);
                    Log.v("debug", "expend");
                }
            }
        });
        /*----------------------------------------------------------------------------*/

        /*�ٱ���ť����---------------------------------------------------------------*/
        //�ٱ���ť
        Button complain_button = (Button)findViewById(R.id.simple_introduce_complain_button);
        //textView������Ӧ
        complain_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                //Ӧ�ý������鲼�־��
                Log.v("debug", "comlain_button");
                showString("����˾ٱ���ť");
            }
        });
        /*----------------------------------------------------------------------------*/

        /*�鿴���ఴť����---------------------------------------------------------------*/
        //�鿴����textView
        TextView other_like_more_button = (TextView)findViewById(R.id.simple_introduce_other_like_more);
        //textView������Ӧ
        other_like_more_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                //Ӧ�ý������鲼�־��
                Log.v("debug", "other_like_more");
                showString("�鿴���ఴť");
            }
        });
        /*----------------------------------------------------------------------------*/

        /*��Ϸ1���ذ�ť����---------------------------------------------------------------*/
        //�鿴����textView
        Button other_like_game1_button = (Button)findViewById(R.id.simple_introduce_other_like_game1_button);
        //textView������Ӧ
        other_like_game1_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                //Ӧ�ý������鲼�־��
                Log.v("debug", "game1_download");
                showString("��Ϸ1���ذ�ť");
            }
        });
        /*----------------------------------------------------------------------------*/


        /*��Ϸ1���ذ�ť����---------------------------------------------------------------*/
        //�鿴����textView
        Button other_like_game2_button = (Button)findViewById(R.id.simple_introduce_other_like_game2_button);
        //textView������Ӧ
        other_like_game2_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                //Ӧ�ý������鲼�־��
                Log.v("debug", "game2_download");
                showString("��Ϸ2���ذ�ť");
            }
        });
        /*----------------------------------------------------------------------------*/


        /*��Ϸ1���ذ�ť����---------------------------------------------------------------*/
        //���鿴���ࡱtextView
        Button other_like_game3_button = (Button)findViewById(R.id.simple_introduce_other_like_game3_button);
        //textView������Ӧ
        other_like_game3_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                //Ӧ�ý������鲼�־��
                Log.v("debug", "game3_download");
                showString("��Ϸ3���ذ�ť");
            }
        });
        /*----------------------------------------------------------------------------*/


        /*��Ϸ�����ܵ������---------------------------------------------------------------*/
        //��Ϸ������View
        View gift_layout = (View)findViewById(R.id.simple_introduce_gift_layout);
        //textView������Ӧ
        gift_layout.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                //Ӧ�ý������鲼�־��
                Log.v("debug", "gift_layout");
                showString("�������Ϸ�������");
            }
        });
        /*----------------------------------------------------------------------------*/



    }

    private void showString(String input)
    {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage(input).create();
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);  //�˴���������dialog��ʾ��λ��
        dialog.show();
    }
}
