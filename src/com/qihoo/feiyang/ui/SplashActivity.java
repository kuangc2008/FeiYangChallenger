package com.qihoo.feiyang.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.qihoo.feiyang.challenger.R;

/**
 * Created by niangang on 2015/7/20.
 */
public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.splash_activity);

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
						MainActivity.class);
				startActivity(intent);
			}
		}.start();

	}
}