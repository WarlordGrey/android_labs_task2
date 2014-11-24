package android.lab2.maze.game.objects;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.lab2.maze.math.GameMath;
import android.view.View;

public class Background implements IDraw{
	
	private int color;
	private Rect rect;

	public Background(View view,int color) {
		this.color = color;
		rect = new Rect(
			view.getLeft(),
			view.getTop(),
			view.getRight(),
			view.getBottom()
		);
	}

	@Override
	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(color);
		paint.setStyle(Paint.Style.FILL);
		canvas.drawRect(
				rect,
				paint
		);
	}
	
	public boolean hasBall(Ball ball){
		return GameMath.isRoundInTheSquare(
			ball.getCenter(),
			ball.getRadius(),
			rect
		);
	}

}
