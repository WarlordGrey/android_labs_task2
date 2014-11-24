package android.lab2.maze.ui;

import android.app.Activity;
import android.content.Intent;
import android.lab2.maze.R;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	
	private static MainActivity me = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		additionalInit();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.activity_main);
	};

	private void additionalInit() {
		me = this;
	}
	
	public static MainActivity getInstance(){
		return me;
	}

	public void startGame(View v){
		Intent intent = new Intent(MainActivity.this,GameActivity.class);
		startActivity(intent);
	}
	
	public void exit(View v){
		finish();
	}
	
}
