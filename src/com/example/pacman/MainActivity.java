package com.example.pacman;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GameController pacman = new GameController(this);
		setContentView(pacman);
		// setContentView(R.layout.activity_main);
	}
}