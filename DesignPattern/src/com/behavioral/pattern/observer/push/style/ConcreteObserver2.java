package com.behavioral.pattern.observer.push.style;

public class ConcreteObserver2 extends Observer {

	@Override
	void update(int value) {
		System.out.println("ConcreteObserver2 "+ value);
	}
}
