package com.example.pacman;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Wall extends View {
	private int left;
	private int top;
	private int right;
	private int bottom;
	private Paint paint;

	public Wall(Context context, int left, int top, int right, int bottom) {
		super(context);
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		paint = new Paint();
	}

	protected void onDraw(Canvas canvas) {
		paint.setColor(Color.GRAY);
		paint.setAntiAlias(true);
		canvas.drawRect(this.left, this.top, this.right, this.bottom, paint);
	}

	public boolean isExist(int[][] area) {

		for (int i = 0; i <= 3; i++) {
			if ((this.left < area[i][0]) && (area[i][0] < this.right)
					&& (this.top < area[i][1]) && (area[i][1] < this.bottom)) {
				return false;
			}
		}
		return true;
	}
}
