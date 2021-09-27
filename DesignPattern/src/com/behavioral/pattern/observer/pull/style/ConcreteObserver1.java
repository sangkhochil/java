package com.behavioral.pattern.observer.pull.style;

public class ConcreteObserver1 extends Observer {
	DataSource datasource;
	public ConcreteObserver1(DataSource datasource) {
		this.datasource = datasource;
	}
	
	@Override
	void update() {
		System.out.println("Concrete Obserer1 " + datasource.getValue());
	}

}
