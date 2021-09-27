package com.behavioral.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	List<Observer> list = new ArrayList<>();
	void addObserver(Observer observer) {
		list.add(observer);
	}
	
	void removeObserver(Observer observer) {
		list.remove(observer);
	}
	
	void notifyObserver() {
		for (Observer observer : list) {
			observer.update();
		}
	}
}
