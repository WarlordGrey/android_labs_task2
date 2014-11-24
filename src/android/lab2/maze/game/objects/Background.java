package android.lab2.maze.game.objects;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Background implements IDraw{
	
	private int color;
	private View view;

	public Background(View view,int color) {
		this.color = color;
		this.view = view;
	}

	@Override
	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(color);
		paint.setStyle(Paint.Style.FILL);
		canvas.drawRect(
				view.getLeft(),
				view.getTop(),
				view.getRight(),
				view.getBottom(),
				paint
		);
	}

}
