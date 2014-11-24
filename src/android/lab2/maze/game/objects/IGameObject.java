package android.lab2.maze.game.objects;

import android.graphics.Point;

public interface IGameObject extends IDraw {
		
	public int getColor();
	
	public Point getCenter();
	
	public void move(int incX, int incY);
	
	public void moveToPoint(Point point);
	
	public boolean hasPoint(Point point);

}
