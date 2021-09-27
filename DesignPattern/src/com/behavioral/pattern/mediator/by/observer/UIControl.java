package com.behavioral.pattern.mediator.by.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class UIControl {

	List<Observer> observers = new ArrayList<>();
	
	void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
