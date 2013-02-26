package com.example.pacman;

import java.util.ArrayList;
import java.util.Timer;

import android.os.Bundle;
import android.app.Activity;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private RelativeLayout viewGroup;
	private GameController gameController;
	private Pacman pacman;
	private Enemy enemy;
	private ArrayList<Object> CoinList;
	private ArrayList<Object> WallList;
	private Timer gameTimer;
	private TimerController timerController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		viewGroup = new RelativeLayout(this);
		gameTimer = new Timer(true);
		this.init();
		// setContentView(R.layout.activity_main);

	}

	public void init(){
		// viewGroupを初期化
		viewGroup.removeAllViews();

		gameController = new GameController(this);
		viewGroup.addView(gameController);

		// 壁を初期化
		WallList = new ArrayList<Object>();
		Wall wall = new Wall(this, 200, 100, 500, 200);
		WallList.add(wall);
		viewGroup.addView(wall);

		// coinを初期化
		CoinList = new ArrayList<Object>();
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				Coin coin = new Coin(this, i * 50, j * 50 + 200);
				CoinList.add(coin);
				viewGroup.addView(coin);
			}
		}

		// pacmanを初期化
		pacman = new Pacman(this, 100, 100);
		viewGroup.addView(pacman);

		// 敵を初期化
		enemy = new Enemy(this, 250, 500);
		viewGroup.addView(enemy);

		setContentView(viewGroup);

		timerController = new TimerController(enemy);
		gameTimer.schedule(timerController, 100, 200);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		gameController.disp(event);

		switch (event.getAction()) {
		case MotionEvent.ACTION_MOVE:

			// pacmanが敵に食べられていたら、game over
			// @todo Timer内で敵の動きに合わせてやらないと、pacmanが動かないと当たったことにならない
			if(pacman.isEatenByEnemy(enemy)){
				this.init();
			}

			// pacmanが壁に当たっていたら何もしない
			if (pacman.canMove(event, WallList)){
				return false;
			}
			// pacmanの移動
			pacman.move(event);

			// pacmanがcoinを食べたら、コインを消す
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