package android.lab2.maze.game.levels;

import android.graphics.Point;
import android.lab2.maze.R;
import android.lab2.maze.game.objects.Background;
import android.lab2.maze.game.objects.Ball;
import android.lab2.maze.game.objects.Wall;
import android.lab2.maze.ui.MainActivity;
import android.view.View;

public class StandartLevel extends Level {
	
	private static int START_X = 50;
	private static int START_Y = 50;
	private static int FINISH_X = 400;
	private static int FINISH_Y = 600;
	
	private static int START_AND_FINISH_RADIUS = 40;
	private static int GAME_BALL_RADIUS = 30;
	
	private static int [] WALL_ARRAY = {
		100,	000,	111,	380,
		0,		450,	200,	450,
		220,	60,		200,	450,
		280,	0,		300,	150,
		300,	150,	400,	70,
		470,	80,		450,	480,
		360,	360,	462,	360,
		275,	440,	380,	440,
		280,	280,	380,	280,
		450,	480,	350,	580,
		450,	480,	500,	580,
		350,	580,	340,	700,
		340,	700,	380,	800,
		380,	800,	440,	700,
		280,	220,	270,	550,
		270,	550,	100,	600,
		100,	600,	110,	750,
		100,	980,	160,	800,
		235,	980,	260,	700
	};
	
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
		int wallsCnt = 0;
		walls = new Wall[WALL_ARRAY.length/4];
		for (int i=0; i< WALL_ARRAY.length; i=i+4){
			Point first = new Point(WALL_ARRAY[i],WALL_ARRAY[i+1]);
			Point second = new Point(WALL_ARRAY[i+2],WALL_ARRAY[i+3]);
			walls[wallsCnt] = new Wall(
					first,
					second, 
					MainActivity.getInstance().getResources()
						.getColor(R.color.wallColor)
			);
			wallsCnt++;
		}
	}

}
