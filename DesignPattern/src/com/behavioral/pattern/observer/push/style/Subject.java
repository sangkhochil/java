package com.behavioral.pattern.observer.push.style;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	List<Observer> list = new ArrayList<Observer>();
	void addObserver(Observer observer) {
		list.add(observer);
	}
	
	void removeObserver(Observer observer) {
		list.remove(observer);
	}
	
	void notifyObserver(int value) {
		for (Observer observer : list) {
			observer.update(value);
		}
	}
}
