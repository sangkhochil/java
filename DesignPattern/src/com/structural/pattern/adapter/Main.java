package com.structural.pattern.adapter;

public class Main {

	public static void main(String[] args) {
		ImageView view = new ImageView(new Image());
		view.apply(new VividFilter());
		view.apply(new CaramelFilter(new Caramel()));
	}
}
