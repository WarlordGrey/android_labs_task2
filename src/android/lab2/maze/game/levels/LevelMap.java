package android.lab2.maze.game.levels;

import java.util.LinkedList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.Point;
import android.lab2.maze.exceptions.WallsNotFound;
import android.lab2.maze.game.objects.Ball;
import android.lab2.maze.game.objects.IDraw;
import android.lab2.maze.game.objects.Wall;
import android.lab2.maze.logic.Mover;
import android.view.View;

public class LevelMap {

	private Level currentLevel = null;
	private Mover mover = null;
	
	public LevelMap(View currentView){
		currentLevel = new StandartLevel(currentView);
		additionalInit();

	}
	
	public LevelMap(Level level){
		this.currentLevel = level;
		additionalInit();
	}
	
	public void additionalInit(){
		mover = new Mover();
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
		Point prevCenter = currentLevel.getGameBall().getCenter();
		Point nextPoint = mover.getNextPoint(
				prevCenter
		);
		currentLevel.getGameBall().moveToPoint(
				nextPoint
		);
		boolean outOfView = !currentLevel.getBackGround().hasBall(currentLevel.getGameBall());
		boolean crossWall = isBallCrossOneOfWalls(currentLevel.getGameBall(),nextPoint);
		if (outOfView || crossWall){
			currentLevel.getGameBall().moveToPoint(prevCenter);
		}
	}
	
	private boolean isBallCrossOneOfWalls(Ball ball, Point pointToMove){
		try {
			for (Wall wall : currentLevel.getWalls()){
				if (wall.isBallCrossWall(ball)){
					return true;
				}
			}
		} catch (WallsNotFound e) {
		}
		return false;
	}
	
}
