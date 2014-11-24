package android.lab2.maze.game.levels;

import java.util.LinkedList;
import java.util.List;

import android.graphics.Canvas;
import android.lab2.maze.exceptions.WallsNotFound;
import android.lab2.maze.game.objects.IDraw;
import android.lab2.maze.game.objects.Wall;
import android.view.View;

public class LevelMap {

	private Level currentLevel = null;
	
	public LevelMap(View currentView){
		currentLevel = new StandartLevel(currentView);
	}
	
	public LevelMap(Level level){
		this.currentLevel = level;
	}
	
	public void draw(Canvas canvas){
		moveBall();
		List <IDraw> objectsToDraw = new LinkedList<IDraw>();
		objectsToDraw.add(currentLevel.getBackGround());
		objectsToDraw.add(currentLevel.getStart());
		objectsToDraw.add(currentLevel.getFinish());
		objectsToDraw.add(currentLevel.getGameBall());
		try {
			for(Wall curWall : currentLevel.getWalls()){
				objectsToDraw.add(curWall);
			}
		} catch (WallsNotFound e) {
		}
		for (IDraw drawable : objectsToDraw) {
			drawable.draw(canvas);
		}
	}
	
	public boolean isLevelFinished(){
		return currentLevel.getFinish().hasPoint(
				currentLevel.getGameBall().getCenter()
		);
	}
	
	private void moveBall(){
	}
	
}
