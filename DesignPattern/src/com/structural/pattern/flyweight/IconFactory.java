package com.structural.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class IconFactory {
	static Map<PointType, PointIcon> icons = new HashMap<>();
	
	public static PointIcon getIcon(PointType type) {
		if(!icons.containsKey(type)) {
			icons.put(type, new PointIcon(type, null));
		}
		return icons.get(type);
	}
}
