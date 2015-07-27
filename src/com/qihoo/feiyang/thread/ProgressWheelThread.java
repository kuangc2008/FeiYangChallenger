package com.qihoo.feiyang.thread;

import android.app.Activity;
import android.os.Bundle;

import com.example.widget.ProgressWheel;

/**
 * Created by niangang on 2015/7/27.
 */
public class ProgressWheelThread extends Thread {
    private boolean wheelRunning = true;
    private int wheelProgress = 0;
    private ProgressWheel mProWheel;


    public ProgressWheelThread(ProgressWheel progressWheel) {

        this.mProWheel = progressWheel;
    }

    @Override
    public void run() {
        super.run();

        wheelRunning = true;
        wheelProgress = 0;
        while (wheelProgress < 361) {
            mProWheel.incrementProgress();
            wheelProgress++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        wheelRunning = false;
    }
}