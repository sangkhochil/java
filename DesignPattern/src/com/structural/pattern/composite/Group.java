package com.structural.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Group implements Components {
	List<Components> components = new ArrayList<>();
	public void add(Components object) {
		components.add(object);
	}
	
	@Override
	public void render() {
		for (Components component : components)
			component.render();
	}
	
	@Override
	public void move() {
		for (Components component : components)
			component.move();
	}
}
