package com.example.pacman;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;

public class BaseGameObject extends View {
	protected int size = 50;
	protected int positionX;
	protected int positionY;
	protected Paint paint;

	public BaseGameObject(Context context, int x, int y) {
		super(context);
		this.positionX = x;
		this.positionY = y;
		paint = new Paint();
	}

	public int[][] getMyArea() {
		// 自分のオブジェクトのエリアを返却
		int[] leftTop = { this.positionX - size, this.positionY - size };
		int[] leftBottom = { this.positionX - size, this.positionY + size };
		int[] rightTop = { this.positionX + size, this.positionY - size };
		int[] rightBottom = { this.positionX + size, this.positionY + size };

		int[][] myArea = { leftTop, leftBottom, rightTop, rightBottom };
		return myArea;
	}


	public int[][] getMoveArea(int x, int y) {
		// 自分のオブジェクトのエリアを返却
		int[] leftTop = { x - size, y - size };
		int[] leftBottom = { x - size, y + size };
		int[] rightTop = { x + size, y - size };
		int[] rightBottom = { x + size, y + size };

		int[][] myArea = { leftTop, leftBottom, rightTop, rightBottom };
		return myArea;
	}

}
