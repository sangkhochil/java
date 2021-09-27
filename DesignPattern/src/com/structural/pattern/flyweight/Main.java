package com.structural.pattern.flyweight;

public class Main {

	public static void main(String[] args) {
		var service = new PointService();
		var points = service.getPoints();
		for (Point point : points) {
			System.out.printf("%s at %d, %d \n", point.getPointIcon().getType(), point.getX(), point.getY());
		}
	}
}
