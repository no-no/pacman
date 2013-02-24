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
	private Paint paint;

	public Coin(Context context, int x, int y) {
		super(context);
		this.positionX = x;
		this.positionY = y;
		paint = new Paint();
	}

	protected void onDraw(Canvas canvas) {
		paint.setColor(Color.GRAY);
		paint.setAntiAlias(true);
		canvas.drawCircle(this.positionX, this.positionY, this.size,
				paint);
	}

	public boolean isEatenByPacman(int pacmanX, int pacmanY) {
		// @todo あたり判定の数字は各オブジェクトのサイズをとらないと
		if (
				(pacmanX - 50 <= this.positionX) && (this.positionX <= pacmanX + 50) &&
				(pacmanY - 50 <= this.positionY) && (this.positionY <= pacmanY + 50)) {
			return true;
		}
		return false;
	}

	public int getPositionX(){
		return this.positionX;
	}

	public int getPositionY(){
		return this.positionY;
	}
}
