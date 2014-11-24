package android.lab2.maze.ui;

import android.app.Activity;
import android.lab2.maze.game.painter.GamePainterView;
import android.os.Bundle;

public class MainActivity extends Activity {
	
	private static MainActivity me = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		additionalInit();
	}

	private void additionalInit() {
		me = this;
	}
	
	public static MainActivity getInstance(){
		return me;
	}
	
}
