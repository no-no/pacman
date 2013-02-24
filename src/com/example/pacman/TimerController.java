package com.example.pacman;

import java.util.TimerTask;

import android.os.Handler;
import android.widget.RelativeLayout;

public class TimerController extends TimerTask {
	private Enemy enemy;
	private Handler mHandler;

	public TimerController(Enemy enemy) {
		super();
		this.enemy = enemy;
		this.mHandler = new Handler();
	}

	@Override
	public void run() {
		mHandler.post(new Runnable() {
			@Override
			public void run() {
				enemy.move();
			}
		});
	}

}