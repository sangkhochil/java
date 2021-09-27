package com.structural.pattern.composite;

public class Main {

	public static void main(String[] args) {
		Group group1 = new Group();
		group1.add(new Shape());
		group1.add(new Shape());
		
		Group group2 = new Group();
		group2.add(new Shape());
		group2.add(new Shape());
		
		Group group = new Group();
		group.add(group1);
		group.add(group2);
		
		group.render();
		group.move();
	}

}
