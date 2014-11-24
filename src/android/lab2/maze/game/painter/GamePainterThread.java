package android.lab2.maze.game.painter;

import android.graphics.Canvas;
import android.lab2.maze.ui.GameActivity;
import android.view.View;

public class GamePainterThread extends Thread {
	
	private boolean painting = false;
	private GamePainterView currentView;
	
	public GamePainterThread (GamePainterView currentView){
		this.currentView = currentView;
	}
	
	public void setPainting(boolean isPainting){
		this.painting = isPainting;
	}
	
	@Override
	public void run() {
		Canvas canvas;
		GamePainter painter = new GamePainter(this);
		while (painting) {
			try {
				canvas = currentView.getHolder().lockCanvas();
				if (canvas == null) {
					continue;
				}
				painter.paintCurrentMazeState(canvas);
				canvas = painter.getCanvas();
				if (canvas != null){
					currentView.getHolder().unlockCanvasAndPost(canvas);
				}
			}
			catch (Exception e){
			}
		}
		GameActivity.getInstance().returnToMainMenu();
	}
	
	public View getCurrentView(){
		return currentView;
	}

}
