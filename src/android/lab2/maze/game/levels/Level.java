package android.lab2.maze.game.levels;

import android.lab2.maze.exceptions.WallsNotFound;
import android.lab2.maze.game.objects.Background;
import android.lab2.maze.game.objects.Ball;
import android.lab2.maze.game.objects.Wall;
import android.view.View;

public abstract class Level {
	
	protected Ball start = null;
	protected Ball finish = null;
	protected Ball gameBall = null;
	protected Wall [] walls = null;
	protected Background background = null;
	protected View currentView = null;
	
	public Wall [] getWalls() throws WallsNotFound{
		if (walls == null){
			throw new WallsNotFound("Level haven't any wall!");
		}
		return walls;
	}

	public Ball getStart() {
		return start;
	}

	public Ball getFinish() {
		return finish;
	}
	
	public Ball getGameBall() {
		return gameBall;
	}
	
	public Background getBackGround() {
		return background;
	}
	
	public View getCurrentView() {
		return currentView;
	}

}
