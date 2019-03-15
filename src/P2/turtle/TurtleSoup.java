/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P2.turtle;

import java.util.List;
import java.util.Set;

import java.util.ArrayList;
import java.util.HashSet;

public class TurtleSoup {

	/**
	 * Draw a square.
	 * 
	 * @param turtle     the turtle context
	 * @param sideLength length of each side
	 */
	public static void drawSquare(Turtle turtle, int sideLength) {

		turtle.draw();
		turtle.forward(sideLength);
		turtle.turn(90.00);
		turtle.forward(sideLength);
		turtle.turn(90.00);
		turtle.forward(sideLength);
		turtle.turn(90.00);
		turtle.forward(sideLength);
		turtle.turn(90.00);

	}

	/**
	 * Determine inside angles of a regular polygon.
	 * 
	 * There is a simple formula for calculating the inside angles of a polygon; you
	 * should derive it and use it here.
	 * 
	 * @param sides number of sides, where sides must be > 2
	 * @return angle in degrees, where 0 <= angle < 360
	 */
	public static double calculateRegularPolygonAngle(int sides) {// 根据边数求出多边形的内角度数
		double angle;
		double side = (double) sides;
		angle = 180 - 360 / side;
		return angle;
	}

	/**
	 * Determine number of sides given the size of interior angles of a regular
	 * polygon.
	 * 
	 * There is a simple formula for this; you should derive it and use it here.
	 * Make sure you *properly round* the answer before you return it (see
	 * java.lang.Math). HINT: it is easier if you think about the exterior angles.
	 * 
	 * @param angle size of interior angles in degrees, where 0 < angle < 180
	 * @return the integer number of sides
	 */
	public static int calculatePolygonSidesFromAngle(double angle) {// 根据多边形的内角度数求出多边形的边数

		double outangle = 180.0 - angle;

		double side = 360 / outangle;

		int sides = (int) side;
		if (sides - side < 0)
			sides = sides + 1;
		return sides;
	}

	/**
	 * Given the number of sides, draw a regular polygon.
	 * 
	 * (0,0) is the lower-left corner of the polygon; use only right-hand turns to
	 * draw.
	 * 
	 * @param turtle     the turtle context
	 * @param sides      number of sides of the polygon to draw
	 * @param sideLength length of each side
	 */
	public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
		turtle.draw();
		double angle;
		angle = calculateRegularPolygonAngle(sides);
		for (int i = 1; i <= sides; i++) {
			turtle.forward(sideLength);
			turtle.turn(angle);
		}
	}

	/**
	 * Given the current direction, current location, and a target location,
	 * calculate the Bearing towards the target point.
	 * 
	 * The return value is the angle input to turn() that would point the turtle in
	 * the direction of the target point (targetX,targetY), given that the turtle is
	 * already at the point (currentX,currentY) and is facing at angle
	 * currentBearing. The angle must be expressed in degrees, where 0 <= angle <
	 * 360.
	 *
	 * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
	 * 
	 * @param currentBearing current direction as clockwise from north
	 * @param currentX       current location x-coordinate
	 * @param currentY       current location y-coordinate
	 * @param targetX        target point x-coordinate
	 * @param targetY        target point y-coordinate
	 * @return adjustment to Bearing (right turn amount) to get to target point,
	 *         must be 0 <= angle < 360
	 */
	// 计算当前已有方向的向量点需要逆时针偏转多少才能到达目标点
	public static double calculateBearingToPoint(double currentBearing, int currentX, int currentY, int targetX,
			int targetY) {
		double angle = Math.atan2(targetY - currentY, targetX - currentX);
		angle = Math.toDegrees(angle);
		System.out.println(angle);
		if (angle <= 90 && angle >= -90)
			angle = 90 - angle;
		else if (angle > 90)
			angle = angle - 180;
		else
			angle = -270 - angle;
		System.out.println(angle);
		double de = angle - currentBearing;
		if (de < 0)
			de = 360 + de;
		return de;
	}

	/**
	 * Given a sequence of points, calculate the Bearing adjustments needed to get
	 * from each point to the next.
	 * 
	 * Assumes that the turtle starts at the first point given, facing up (i.e. 0
	 * degrees). For each subsequent point, assumes that the turtle is still facing
	 * in the direction it was facing when it moved to the previous point. You
	 * should use calculateBearingToPoint() to implement this function.
	 * 
	 * @param xCoords list of x-coordinates (must be same length as yCoords)
	 * @param yCoords list of y-coordinates (must be same length as xCoords)
	 * @return list of Bearing adjustments between points, of size 0 if (# of
	 *         points) == 0, otherwise of size (# of points) - 1
	 */
	public static List<Double> calculateBearings(List<Integer> xCoords, List<Integer> yCoords) {
		int n = xCoords.size();
		List<Double> ang = new ArrayList<Double>();
		double angle = Math.atan2(yCoords.get(1) - yCoords.get(0), xCoords.get(1) - yCoords.get(0));
		angle = Math.toDegrees(angle);
		ang.add(angle);
		for (int m = 1; m + 1 < n; m++) {
			int cux = xCoords.get(m);
			int cuy = yCoords.get(m);
			int tax = xCoords.get(m + 1);
			int tay = yCoords.get(m + 1);
			angle = calculateBearingToPoint(angle, cux, cuy, tax, tay);
			ang.add(angle);
		}
		return ang;
	}

	/**
	 * Given a set of points, compute the convex hull, the smallest convex set that
	 * contains all the points in a set of input points. The gift-wrapping algorithm
	 * is one simple approach to this problem, and there are other algorithms too.
	 * 
	 * @param points a set of points with xCoords and yCoords. It might be empty,
	 *               contain only 1 point, two points or more.
	 * @return minimal subset of the input points that form the vertices of the
	 *         perimeter of the convex hull
	 */
	
	public static int JudgeArray(double[] Array) {
		int judge = 0;
		int len1 = 0, len2 = 0;

		for (int i = 0; i < Array.length; i++) {
			if (Array[i] >= 0)
				len1++;

		}
		for (int j = 0; j < Array.length; j++) {
			if (Array[j] <= 0)
				len2++;
		}

		if (len1 == Array.length)
			judge = 1;
		else if (len2 == Array.length)
			judge = -1;
		return judge;

	}

	public static Set<Point> convexHull(Set<Point> points) {
		Set<Point> re = new HashSet<Point>();// 最终结果 set
		Point[] result = new Point[points.size()];// 新建结果数组
		List<Point> list = new ArrayList<Point>(points);// 将set转换为list
		int len = 0;// 结果集中的point个数
		if (points.size() <= 2)
			return points;
		for (int i = 0; i < points.size(); i++) {
			int de0 = 0;
			int de1 = 0;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).x() == list.get(i).x()) {
					if (list.get(j).y() > list.get(i).y())
						de0++;
					else if (list.get(j).y() < list.get(i).y())
						de1++;
				}
			}
			if (de0 != 0 && de1 != 0) {
				points.remove(list.get(i));
				//System.out.println(list.get(i).y());
			}
			list = new ArrayList<Point>(points);
		}
		
		  //for(Point p0:points) { double x = p0.x(); System.out.println(x); }
		
		for (int i = 0; i < points.size(); i++) {
			for (int j = 0; j < points.size(); j++) {
				if (j == i)
					continue;
				double[] judge = new double[points.size()];
				for (int k = 0; k < list.size(); k++) {
					double a = list.get(j).y() - list.get(i).y();
					double b = list.get(j).x() - list.get(i).x();
					double c = (list.get(i).x()) * (list.get(j).y()) - (list.get(i).y()) * (list.get(j).x());
					judge[k] = a * (list.get(k).x()) - b * (list.get(k).y()) - c;

				}
				if (JudgeArray(judge) != 0) {
					for (int k = 0; k < points.size(); k++) {
						if (judge[k] != 0) {
							result[len++] = list.get(i);
							break;
						}
					}
					break;

				}
			}
		}
		Point[] result1 = new Point[len];
		for (int m = 0; m < len; m++) {
			result1[m] = result[m];
			re.add(result1[m]);

		}
		return re;
	}

	/**
	 * Draw your personal, custom art.
	 * 
	 * Many interesting images can be drawn using the simple implementation of a
	 * turtle. For this function, draw something interesting; the complexity can be
	 * as little or as much as you want.
	 * 
	 * @param turtle the turtle context
	 */
	public static void drawPersonalArt(Turtle turtle) {
		turtle.draw();
		int sidelen = 40;
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++, sidelen = sidelen - 5) {
				turtle.color(PenColor.GREEN);
				turtle.forward(sidelen);
				turtle.turn(90);
			}
		}
	}

	/**
	 * Main method.
	 * 
	 * This is the method that runs when you run "java TurtleSoup".
	 * 
	 * @param args unused
	 */
	public static void main(String args[]) {
		DrawableTurtle turtle = new DrawableTurtle();
		drawSquare(turtle, 40);
		turtle.draw();
		Set<Point> point = new HashSet<Point>();
		Set<Point> points = new HashSet<Point>();
		Point p11 = new Point(1, 1);
		Point p1010 = new Point(10, 10);
		Point p110 = new Point(1, 10);
		Point p12 = new Point(1, 2);
		Point p23 = new Point(2, 3);
		Point p32 = new Point(3, 2);
		points.add(p11);
		points.add(p1010);
		points.add(p110);
		points.add(p12);
		points.add(p23);
		points.add(p32);
		point = convexHull(points);
		
		 for(Point p0:point) { double x = p0.x(); System.out.println(x); }
		 

	}

}
