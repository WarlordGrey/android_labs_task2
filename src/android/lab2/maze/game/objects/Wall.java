package android.lab2.maze.game.objects;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.lab2.maze.math.GameMath;

public class Wall implements IGameObject {

	private Point startPoint;
	private Point endPoint;
	private int color;

	public Wall(Point first, Point second, int color) {
		this.startPoint = first;
		this.endPoint = second;
		this.color = color;
	}

	@Override
	public int getColor() {
		return color;
	}

	@Override
	public void move(int incX, int incY) {
		startPoint.x = startPoint.x + incX;
		startPoint.y = startPoint.y + incY;
		endPoint.x = endPoint.x + incX;
		endPoint.y = endPoint.y + incY;
	}

	@Override
	public void moveToPoint(Point point) {
		Point center = getCenter();
		int deltaX = point.x - center.x;
		int deltaY = point.y - center.y;
		startPoint.x += deltaX;
		startPoint.y += deltaY;
		endPoint.x += deltaX;
	}

	@Override
	public boolean hasPoint(Point point) {
		return GameMath.isLineHasPoint(startPoint, endPoint, point);
	}
	
	public boolean isBallCrossWall(Ball ball){
		return GameMath.isRoundCrossLine(
				ball.getCenter(),
				ball.getRadius(),
				startPoint,
				endPoint
		);
	}

	@Override
	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(color);
		paint.setStyle(Paint.Style.FILL);
		canvas.drawLine(
				startPoint.x,
				startPoint.y, 
				endPoint.x,
				endPoint.y,
				paint
		);
	}

	@Override
	public Point getCenter() {
		return new Point(
				getSegmentCenter(startPoint.x, endPoint.x), 
				getSegmentCenter(startPoint.y, endPoint.y)
		);
	}

	private int getSegmentCenter(int coord1, int coord2) {
		return (int) Math.round((coord1 + coord2) / 2);
	}

}
