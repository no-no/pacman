package com.example.pacman;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.MotionEvent;

public class Pacman extends View {
	private int size = 50;
	private int positionX;
	private int positionY;
	private Paint paint;

	public Pacman(Context context, int x, int y) {
		super(context);
		this.positionX = x;
		this.positionY = y;
		paint = new Paint();
	}

	protected void onDraw(Canvas canvas) {
		paint.setColor(Color.BLACK);
		paint.setAntiAlias(true);
		canvas.drawCircle(this.positionX, this.positionY, this.size, paint);

		String touchPosition = "pacmanポジション: " + String.valueOf(this.positionX)
				+ ", " + String.valueOf(this.positionY);
		canvas.drawText(touchPosition, 10, 20, paint);
	}

	public void move(MotionEvent event) {
		int touchPositionX = (int) event.getX();
		int touchPositionY = (int) event.getY() - 100;

		// @todo あたり判定の数字は各オブジェクトのサイズをとらないと
		if (
				( this.positionX - 75 <= touchPositionX) && (touchPositionX <= this.positionX + 75) &&
				( this.positionY - 75 <= touchPositionY) && (touchPositionY <= this.positionY + 75)) {
			this.positionX = touchPositionX;
			this.positionY = touchPositionY;

			this.invalidate();
		}
	}

	public boolean isEatCoin(Coin coin) {
		if(coin.isEatenByPacman(this.positionX, this.positionY)){
			return true;
		}
		return false;
	}

	public boolean isEatenByEnemy(Enemy enemy){
		if (enemy.isEatPacman(this.positionX, this.positionY)) {
			return true;
		}
		return false;
	}
}
