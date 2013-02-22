package com.example.pacman;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Coin extends View {
	private int size = 10;
	private int positionX;
	private int positionY;

	public Coin(Context context, int x, int y) {
		super(context);
		this.positionX = x;
		this.positionY = y;
	}

	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.GRAY);
		paint.setAntiAlias(true);
		canvas.drawCircle(this.positionX, this.positionY, this.size,
				paint);
}

	public int getPositionX(){
		return this.positionX;
	}

	public int getPositionY(){
		return this.positionY;
	}
}
