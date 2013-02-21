package com.example.pacman;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class GameController extends View {

	public int x = 100, y = 100;
	public int xx, yy;
	private final String tag = "Android";

	public GameController(Context context) {
		super(context);
	}

	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);
		paint.setAntiAlias(true);
		canvas.drawCircle(x, y, 50, paint);
		String log = String.valueOf(xx) + ", " + String.valueOf(yy);
		canvas.drawText(log, 10, 10, paint);
	}

	public boolean onTouchEvent(MotionEvent e) {

		xx = (int) e.getX();
		yy = (int) e.getY();
		if (((int) xx >= x - 100) && ((int) xx <= x + 100)
				&& ((int) yy >= y - 100) && ((int) yy <= y + 100)) {
			switch (e.getAction()) {
			case MotionEvent.ACTION_MOVE:
				x = (int) e.getX();
				y = (int) e.getY();
				break;
			default:
				break;
			}
		}
		invalidate();
		return true;
	}

}