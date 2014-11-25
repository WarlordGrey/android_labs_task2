package android.lab2.maze.ui;

import android.app.Activity;
import android.lab2.maze.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_win);
		additionalInit();
	}
	
	private void additionalInit() {
		Button btnOk = (Button) findViewById(R.id.btnOk);
		btnOk.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				exit();
			}
		});
		TextView txtTime = (TextView) findViewById(R.id.txtTime);
		long time = GameActivity.getInstance().getWastedTime();
		long secs = time / 1000;
		long msecs = time % 1000;
		txtTime.setText(secs+":"+msecs+"\nseconds");
	}
	
	private void exit(){
		finish();
	}
	
}
