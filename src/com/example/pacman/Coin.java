package com.example.pacman;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

public class Coin extends BaseGameObject{
	private int size = 10;

	public Coin(Context context, int x, int y) {
		super(context, x, y);
	}

	protected void onDraw(Canvas canvas) {
		paint.setColor(Color.YELLOW);
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
}
