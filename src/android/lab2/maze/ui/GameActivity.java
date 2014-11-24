package android.lab2.maze.ui;

import android.app.Activity;
import android.lab2.maze.game.painter.GamePainterView;
import android.os.Bundle;

public class GameActivity extends Activity {
	
	private static GameActivity me = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		additionalInit();
		setContentView(new GamePainterView(this));
	}
	
	private void additionalInit() {
		me = this;
	}
	
	public static GameActivity getInstance(){
		return me;
	}
	
	public synchronized void returnToMainMenu(){
		finish();
	}

}
