package com.example.pacman;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

public class Enemy extends BaseGameObject {
	Random random = new Random();

	public Enemy(Context context, int x, int y) {
		super(context, x, y);
	}

	protected void onDraw(Canvas canvas) {
		paint.setColor(Color.RED);
		paint.setAntiAlias(true);
		canvas.drawCircle(this.positionX, this.positionY, this.size, paint);
	}

	public void move() {
		int n = random.nextInt(50);

		if (n % 4 == 0) {
			this.positionX += 30;
		}
		if (n % 4 == 1) {
			this.positionX -= 30;
		}
		if (n % 4 == 2) {
			this.positionY += 30;
		}
		if (n % 4 == 3) {
			this.positionY -= 30;
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
