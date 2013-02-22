package com.example.pacman;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private RelativeLayout viewGroup;
	private GameController gameController;
	private Pacman pacman;
	private ArrayList<Object> CoinList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		viewGroup = new RelativeLayout(this);
		gameController = new GameController(this);
		viewGroup.addView(gameController);
		CoinList = new ArrayList<Object>();
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				Coin coin = new Coin(this, i * 50, j * 50 + 200);
				CoinList.add(coin);
				viewGroup.addView(coin);
			}
		}
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
			for (int i = 0; i < CoinList.size(); i++) {
				Coin coin = (Coin) CoinList.get(i);
				if (pacman.isEatCoin(coin)) {
					CoinList.remove(coin);
					viewGroup.removeView(coin);
				}
			}
			break;
		default:
			break;
		}
		return true;
	}

}