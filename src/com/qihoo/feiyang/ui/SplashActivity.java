package com.qihoo.feiyang.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.widget.ProgressWheel;
import com.qihoo.feiyang.challenger.R;

/**
 * Created by niangang on 2015/7/20.
 */
public class SplashActivity extends Activity {
    private ProgressWheel pwTwo;
    boolean wheelRunning;
    int wheelProgress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_activity);


//        pwTwo = (ProgressWheel) findViewById(R.id.progress_bar_two);
//        new Thread(r).start();


        new Thread() {

            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(SplashActivity.this,
                        HoujhFragment.class);
                intent.putExtra("isSuccess", false);
                startActivity(intent);
                finish();
            }
        }.start();


    }

    final Runnable r = new Runnable() {
        public void run() {
            wheelRunning = true;
            while (wheelProgress < 361) {
                pwTwo.incrementProgress();
                wheelProgress++;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            wheelRunning = false;
        }
    };
}