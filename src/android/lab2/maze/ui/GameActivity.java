package android.lab2.maze.ui;

import android.app.Activity;
import android.content.Intent;
import android.lab2.maze.game.painter.GamePainterView;
import android.os.Bundle;

public class GameActivity extends Activity {
	
	private static GameActivity me = null;
	private long wastedTime = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		additionalInit();
		setContentView(new GamePainterView(this));
	}
	
	private void additionalInit() {
		me = this;
		wastedTime = System.currentTimeMillis();
	}
	
	public static GameActivity getInstance(){
		return me;
	}
	
	public synchronized void returnToMainMenu(){
		wastedTime = System.currentTimeMillis() - wastedTime;
		showAfterLevelMenu();
		finish();
	}
	
	private void showAfterLevelMenu(){
		Intent intent = new Intent(GameActivity.this, WinActivity.class);
		startActivity(intent);
	}
	
	public long getWastedTime(){
		return wastedTime;
	}

}
