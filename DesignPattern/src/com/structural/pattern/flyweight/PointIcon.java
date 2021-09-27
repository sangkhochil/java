package com.structural.pattern.flyweight;

public class PointIcon {
	private final PointType type;	
	private final byte[] icon;
	
	public PointType getType() {
		return type;
	}	
	
	public PointIcon(PointType type, byte[] icon) {
		this.type = type;
		this.icon = icon;
	}
}
