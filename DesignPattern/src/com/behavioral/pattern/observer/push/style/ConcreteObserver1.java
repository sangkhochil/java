package com.behavioral.pattern.observer.push.style;

public class ConcreteObserver1 extends Observer {

	@Override
	void update(int value) {
		System.out.println("Concrete Obserer1 " + value);
	}

}
