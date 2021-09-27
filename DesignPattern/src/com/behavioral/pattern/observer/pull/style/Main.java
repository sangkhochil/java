package com.behavioral.pattern.observer.pull.style;

public class Main {

	public static void main(String[] args) {
		DataSource datasource = new DataSource();
		datasource.addObserver(new ConcreteObserver1(datasource));
		datasource.addObserver(new ConcreteObserver2(datasource));
		datasource.setValue(123);
	}
}
