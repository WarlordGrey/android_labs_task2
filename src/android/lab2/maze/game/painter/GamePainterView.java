package android.lab2.maze.game.painter;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.lab2.maze.ui.MainActivity;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePainterView extends SurfaceView implements SurfaceHolder.Callback {
	
	public GamePainterView(Context context) {
		super(context);
		additionalInit();
	}

	public GamePainterView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		additionalInit();
	}

	public GamePainterView(Context context, AttributeSet attrs) {
		super(context, attrs);
		additionalInit();
	}

	public void additionalInit(){
		getHolder().addCallback(this);
		MainActivity.getInstance().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
			//We don't need that at our task	
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		
	}

	

}
