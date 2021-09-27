package com.behavioral.pattern.observer.pull.style;

public class ConcreteObserver2 extends Observer {
	DataSource datasource;
	public ConcreteObserver2(DataSource datasource) {
		super();
		this.datasource = datasource;
	}
	@Override
	void update() {
		System.out.println("ConcreteObserver2 "+ datasource.getValue());
	}
}
