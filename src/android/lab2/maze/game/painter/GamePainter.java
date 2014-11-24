package android.lab2.maze.game.painter;

import android.graphics.Canvas;
import android.lab2.maze.game.levels.Level;
import android.lab2.maze.game.levels.LevelMap;

public class GamePainter {
	
	private Canvas canvas = null;
	private GamePainterThread painterThread = null;
	private LevelMap map = null;
	
	public GamePainter(GamePainterThread painterThread,Canvas canvas, Level level){
		this.painterThread = painterThread;
		this.canvas = canvas;
		map = new LevelMap(level);
	}
	
	public GamePainter(GamePainterThread painterThread,Canvas canvas){
		this.painterThread = painterThread;
		this.canvas = canvas;
		map = new LevelMap(painterThread.getCurrentView());
	}
	
	public GamePainter(GamePainterThread painterThread){
		this.painterThread = painterThread;
		map = new LevelMap(painterThread.getCurrentView());
	}
	
	public GamePainter(GamePainterThread painterThread,Level level){
		this.painterThread = painterThread;
		map = new LevelMap(level);
	}
	
	public void setCanvas(Canvas canvas){
		this.canvas = canvas;
	}
	
	public void paintCurrentMazeState(Canvas canvas){
		setCanvas(canvas);
		map.draw(canvas);
		if (map.isLevelFinished()){
			painterThread.setPainting(false);
		}
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	
}
