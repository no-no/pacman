package com.example.pacman;

import android.os.Bundle;
import android.app.Activity;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private RelativeLayout viewGroup;
	private GameController gameController;
	private Pacman pacman;
	private Coin coin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		viewGroup = new RelativeLayout(this);
		gameController = new GameController(this);
		viewGroup.addView(gameController);
		coin = new Coin(this, 200, 200);
		viewGroup.addView(coin);
		pacman = new Pacman(this, 100, 100);
		viewGroup.addView(pacman);

		setContentView(viewGroup);
		// setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onTouchEvent(MotionEvent e) {
		gameController.disp(e);
		switch (e.getAction()) {
		case MotionEvent.ACTION_MOVE:
			pacman.move(e);
			break;
		default:
			break;
		}
		return true;
	}

}