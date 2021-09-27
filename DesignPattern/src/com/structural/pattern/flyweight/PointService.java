package com.structural.pattern.flyweight;

import java.util.ArrayList;
import java.util.List;

public class PointService {
	List<Point> points = new ArrayList<Point>();
	public List<Point> getPoints() {
		Point point = new Point(1,2,IconFactory.getIcon(PointType.CAFE));
		points.add(point);
		
		point = new Point(3, 4, IconFactory.getIcon(PointType.RESTRAUNT));
		points.add(point);
		
		point = new Point(5, 6, IconFactory.getIcon(PointType.BUSSTATION));
		points.add(point);
		
		return points;
	}
}
