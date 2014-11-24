package android.lab2.maze.game.painter;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.lab2.maze.ui.GameActivity;
import android.lab2.maze.ui.MainActivity;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePainterView extends SurfaceView implements SurfaceHolder.Callback {
	
	private GamePainterThread painter = null;

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
		int flags = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE;
		if (android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH){
			flags |= ActivityInfo.SCREEN_ORIENTATION_LOCKED;
		}
		GameActivity.getInstance().setRequestedOrientation(
				flags
		);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		painter = new GamePainterThread(this);
		painter.setPainting(true);
		painter.start();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
			//We don't need that at our task	
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		painter.setPainting(false);
		while (retry) {
			try {
				painter.join();
				retry = false;
			} catch (InterruptedException e) {
			}
		}
	}

	

}
