package com.behavioral.pattern.observer.push.style;

public class Main {

	public static void main(String[] args) {
		DataSource datasource = new DataSource();
		datasource.addObserver(new ConcreteObserver1());
		datasource.addObserver(new ConcreteObserver2());
		datasource.setValue(12);
	}

}
