package com.example.pacman;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class GameController extends View {

	public int touchPositionX;
	public int touchPositionY;

	Pacman pacman;

	public GameController(Context context) {
		super(context);
	}

	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		String touchPosition = "タッチしたポジション: " + String.valueOf(this.touchPositionX) + ", "
				+ String.valueOf(this.touchPositionY);
		canvas.drawText(touchPosition, 10, 10, paint);
	}

	/**
	 * タッチしたポジションに更新する
	 */
	public void disp(MotionEvent event) {
		this.touchPositionX = (int) event.getX();
		this.touchPositionY = (int) event.getY();
		this.invalidate();
	}

}