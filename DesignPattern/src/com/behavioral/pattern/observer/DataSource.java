package com.behavioral.pattern.observer;

public class DataSource extends Subject {
	String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
		notifyObserver();
	}
}
