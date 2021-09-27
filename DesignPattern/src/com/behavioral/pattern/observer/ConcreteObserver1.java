package com.behavioral.pattern.observer;

public class ConcreteObserver1 implements Observer {

	@Override
	public void update() {
		System.out.println("Update ConcreteObserver1");
	}
}
