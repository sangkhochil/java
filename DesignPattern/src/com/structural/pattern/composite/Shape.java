package com.structural.pattern.composite;

public class Shape implements Components {
	@Override
	public void render() {
		System.out.println("render shape");
	}

	@Override
	public void move() {
		System.out.println("render move");
	}
}
