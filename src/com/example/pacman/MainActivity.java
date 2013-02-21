package com.example.pacman;

import android.os.Bundle;
import android.app.Activity;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private RelativeLayout viewGroup;
	private Pacman pacman;
	private GameController gameController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		viewGroup = new RelativeLayout(this);
		gameController = new GameController(this);
		viewGroup.addView(gameController);
		pacman = new Pacman(this);
		viewGroup.addView(pacman);

		setContentView(viewGroup);
		// setContentView(pacman);
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