package android.lab2.maze.logic;

import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.lab2.maze.ui.MainActivity;

public class Mover implements SensorEventListener{
	
	private Sensor sensor = null;
	int x;
	int y;
	int z;
	
	public Mover(){
		SensorManager sensMgr = (SensorManager)MainActivity
				.getInstance().getSystemService(
						MainActivity.SENSOR_SERVICE
		);
		sensor = sensMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sensMgr.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	public Point getNextPoint(Point currentPoint){
		return new Point(currentPoint.x-x,currentPoint.y+y);
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		x = (int) event.values[0];
		y = (int) event.values[1];
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
	}

}
