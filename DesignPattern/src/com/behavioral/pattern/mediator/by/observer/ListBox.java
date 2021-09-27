package com.behavioral.pattern.mediator.by.observer;

public class ListBox extends UIControl {
	String selected;
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
		notifyObservers();
	}
}
