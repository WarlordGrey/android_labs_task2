package android.lab2.maze.game.painter;

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
		
	}
	
	public View getCurrentView(){
		return currentView;
	}

}
