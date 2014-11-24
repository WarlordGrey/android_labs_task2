package android.lab2.maze.game.objects;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.lab2.maze.math.GameMath;

public class Ball implements IGameObject {
	
	private Point center;
	private int radius;
	private int color;

	public Ball(Point center, int radius,int color){
		this.center = center;
		this.radius = radius;
		this.color = color;
	}
	
	public Point getLeftTopPoint(){
		return new Point(center.x-radius,center.y-radius);
	}
	
	public Point getRightBottomPoint(){
		return new Point(center.x+radius,center.y+radius);
	}
	
	@Override
	public int getColor(){
		return color;
	}
	
	@Override
	public Point getCenter(){
		return center;
	}
	
	public int getRadius(){
		return radius;
	}
	
	@Override
	public void move(int incX, int incY){
		center.x = center.x+incX;
		center.y = center.y+incY;
	}
	
	@Override
	public void moveToPoint(Point point){
		this.center = point;
	}
	
	@Override
	public boolean hasPoint(Point point){
		return GameMath.isRoundHasPoint(center, radius, point);
	}
	
	@Override
	public void draw(Canvas canvas){
		Paint paint = new Paint();
		paint.setColor(color);
		paint.setStyle(Paint.Style.FILL);
		canvas.drawCircle(getCenter().x, getCenter().y, radius, paint);
	}
	
}
