package com.structural.pattern.flyweight;

public class Point {
	private int x;
	private int y;
	private PointIcon pointIcon;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public PointIcon getPointIcon() {
		return pointIcon;
	}
	public Point(int x, int y, PointIcon pointIcon) {
		this.x = x;
		this.y = y;
		this.pointIcon = pointIcon;
	}
}
