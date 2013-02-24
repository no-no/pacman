package com.example.pacman;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Enemy extends View {
	private int size = 50;
	private int positionX;
	private int positionY;
	private Paint paint;
	Random random = new Random();

	public Enemy(Context context, int x, int y) {
		super(context);
		this.positionX = x;
		this.positionY = y;
		paint = new Paint();
	}

	protected void onDraw(Canvas canvas) {
		paint.setColor(Color.RED);
		paint.setAntiAlias(true);
		canvas.drawCircle(this.positionX, this.positionY, this.size, paint);
	}

	public void move() {
		int n = random.nextInt(50);

		if (n % 4 == 0) {
			this.positionX += 25;
		}
		if (n % 4 == 1) {
			this.positionX -= 25;
		}
		if (n % 4 == 2) {
			this.positionY += 25;
		}
		if (n % 4 == 3) {
			this.positionY -= 25;
		}
		this.invalidate();
	}

	public boolean isEatPacman(int pacmanX, int pacmanY){
		// @todo あたり判定の数字は各オブジェクトのサイズをとらないと
		if (
				(this.positionX - 100 <= pacmanX) && (pacmanX <= this.positionX + 100) &&
				(this.positionY - 100) <= pacmanY && (pacmanY <= this.positionY + 100)) {
			return true;
		}
		return false;
	}

}
