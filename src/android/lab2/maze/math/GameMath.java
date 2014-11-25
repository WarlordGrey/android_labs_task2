package android.lab2.maze.math;

import android.graphics.Point;
import android.graphics.Rect;
import android.lab2.maze.exceptions.DiscriminantLessThanZero;


public class GameMath {
	
	public static boolean isLineHasPoint(Point startPoint, Point endPoint, Point point){
		if (
				(startPoint.x == endPoint.x)
				&& (startPoint.x == point.x)
				&& (
						(
								(point.y>=startPoint.y)
								&& (endPoint.y>=point.y)
						)
						|| (
								(startPoint.y>=point.y)
								&& (point.y>=endPoint.y)
						) 
				   )
		){
			return true;
		}	
		double a = (startPoint.y-endPoint.y)/(double)(startPoint.x-endPoint.x);
		double b = ((startPoint.y+endPoint.y)-a*(startPoint.x+endPoint.x))/2;
		return ( 
				(point.y == (int)Math.round((a*point.x+b)))
				&& ( 
						(
								(point.x>startPoint.x)
								&& (endPoint.x>point.x)
						)
						|| (
								(startPoint.x>point.x)
								&& (point.x>endPoint.x)
						) 
				)
		);
	}

	public static int getCrossProductPointAndLine(
			Point lineStart,
			Point lineEnd,
			Point point
	){	
		return (point.x - lineStart.x)
				* (lineEnd.y - lineStart.y)
				- (point.y - lineStart.y)
				* (lineEnd.x - lineStart.x);
	}
	
	public static boolean isRoundCrossLine(
			Point roundCenter,
			int radius,
			Point lineStart,
			Point lineEnd
	){
		Point[] pointsWhereCanCross;
		try {
			pointsWhereCanCross = getRoundAndLineCrossPoints(
					roundCenter,
					radius,
					lineStart,
					lineEnd
			);
			for(Point curPoint : pointsWhereCanCross){
				boolean roundHasPoint = isRoundHasPoint(roundCenter, radius, curPoint);
				boolean lineHasPoint = isLineHasPoint(lineStart, lineEnd, curPoint);
				if (lineHasPoint && roundHasPoint){
					return true;
				}
			}
		} catch (DiscriminantLessThanZero e) {
			return false;
		}
		return false;
	}
	
	/*
	 *  y == k*x + b
	 *  
	 *  &&
	 *  
	 *  
	 */
	public static Point [] getRoundAndLineCrossPoints(
			Point roundCenter,
			int radius,
			Point lineStart,
			Point lineEnd
	)throws DiscriminantLessThanZero{
		double aEquation;
		double bEquation;
		double cEquation;
		if (lineStart.x == lineEnd.x){
			aEquation = 1;
			bEquation = - 2*roundCenter.y;
			cEquation = 
					lineStart.x*lineStart.x
					- radius*radius
					- 2*lineStart.x*roundCenter.x
					+roundCenter.x*roundCenter.x
					+roundCenter.y*roundCenter.y;
			QuadraticEquationResult equatationRoots = getXFromQuadraticEquation(
					new QuadraticEquationKoefs(aEquation, bEquation, cEquation)
			);
			return new Point []{
					new Point(
							lineStart.x,
							(int)Math.round(equatationRoots.x1)
					),
					new Point(
							lineStart.x,
							(int)Math.round(equatationRoots.x2)
					)
			};
		} else {
			LineFunctionKoefs koefs = getLineFunctionKoefsFromLineEquationKoefs(
					lineStart, lineEnd
			);
			aEquation = koefs.k*koefs.k + 1;
			bEquation = 2*(koefs.k*koefs.b-roundCenter.x-koefs.k*roundCenter.y);
			cEquation = 
					roundCenter.x*roundCenter.x
					+ koefs.b*koefs.b
					- 2*koefs.b*roundCenter.y
					+ roundCenter.y*roundCenter.y
					- radius*radius;
			QuadraticEquationResult equatationRoots = getXFromQuadraticEquation(
					new QuadraticEquationKoefs(aEquation, bEquation, cEquation)
			);
			return new Point []{
				new Point(
						(int)Math.round(equatationRoots.x1),
						getYFromLinearFunction(
								(int)Math.round(equatationRoots.x1),
								koefs
						)
				),
				new Point(
						(int)Math.round(equatationRoots.x2),
						getYFromLinearFunction(
								(int)Math.round(equatationRoots.x2),
								koefs
						)
				)
			};
		}
		
	}
	
	public static LineFunctionKoefs getLineFunctionKoefsFromLineEquationKoefs(
			Point lineStart,
			Point lineEnd
	){	
		double denominator = lineEnd.x-lineStart.x;
		return new LineFunctionKoefs(
				(lineEnd.y-lineStart.y)/(denominator),
				(lineEnd.x*lineStart.y-lineStart.x*lineEnd.y)/(denominator)
		);
	}
	
	public static LineEquationKoefs getLineEquationKoefsFromSegment(
			Point lineStart,
			Point lineEnd
	){
		int a = lineStart.y - lineEnd.y;
		int b = lineEnd.x - lineStart.x;
		return new LineEquationKoefs(
				a,
				b,
				( - lineStart.x*a) - b*lineStart.y
		);
	}
	
	public static int getYFromLinearFunction(int x, LineFunctionKoefs koefs){
		return (int)Math.round(koefs.k*x + koefs.b);
	}
	
	public static boolean isRoundHasPoint(Point roundCenter, int radius, Point point){
 		return ((radius - (int) Math.round(getVectorsLength(point, roundCenter))) >= 0);
	}
	
	public static double getVectorsLength(Point start, Point end){
		int imagineLineXLength = Math.abs(start.x-end.x);
		int imagineLineYLength = Math.abs(start.y-end.y);
		return Math.sqrt(
				imagineLineXLength*imagineLineXLength
				+imagineLineYLength*imagineLineYLength
		);
	}
	
	public static QuadraticEquationResult getXFromQuadraticEquation(QuadraticEquationKoefs koefs)
	throws DiscriminantLessThanZero{
		double D = koefs.b*koefs.b - 4*koefs.a*koefs.c;
		double denominator = 2*koefs.a;
		double realPart = (-koefs.b)/denominator;
		if (D<0){
			throw new DiscriminantLessThanZero();
		} 
		return new QuadraticEquationResult(
				realPart+Math.sqrt(D)/denominator,
				realPart-Math.sqrt(D)/denominator
		);
	}
	
	public static boolean isRoundInTheSquare(Point center, int radius, Rect rect){
		return 
				rect.contains(center.x-radius, center.y-radius)
				&& rect.contains(center.x+radius, center.y+radius);
	}
	
}
