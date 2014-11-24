package android.lab2.maze.game.levels;

import android.graphics.Point;
import android.lab2.maze.R;
import android.lab2.maze.game.objects.Background;
import android.lab2.maze.game.objects.Ball;
import android.lab2.maze.ui.MainActivity;
import android.view.View;

public class StandartLevel extends Level {
	
	private static int START_X = 100;
	private static int START_Y = 100;
	private static int FINISH_X = 800;
	private static int FINISH_Y = 400;
	
	private static int START_AND_FINISH_RADIUS = 40;
	private static int GAME_BALL_RADIUS = 30;
	
	public StandartLevel(View currentView){
		this.currentView = currentView;
		start = new Ball(
				new Point(START_X,START_Y),
				START_AND_FINISH_RADIUS,
				MainActivity.getInstance().getResources()
				.getColor(R.color.startPointColor)
		);
		finish = new Ball(
			new Point(FINISH_X,FINISH_Y),
			START_AND_FINISH_RADIUS,
			MainActivity.getInstance().getResources()
				.getColor(R.color.finishPointColor)
		);
		gameBall = new Ball(
			new Point(START_X,START_Y),
			GAME_BALL_RADIUS,
			MainActivity.getInstance().getResources()
			.getColor(R.color.gameBallColor)
		);
		background = new Background(
				this.currentView,
				MainActivity.getInstance().getResources()
				.getColor(R.color.backgroundColor)
		);
		walls = null;
	}

}
