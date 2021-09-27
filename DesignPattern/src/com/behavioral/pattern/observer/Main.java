package com.behavioral.pattern.observer;

public class Main {

	public static void main(String[] args) {
		DataSource datasource = new DataSource();
		datasource.addObserver(new ConcreteObserver1());
		datasource.addObserver(new ConcreteObseerver2());
		datasource.addObserver(new ConcreteObserver1());
		
		datasource.setValue("Hello world");
	}

}
