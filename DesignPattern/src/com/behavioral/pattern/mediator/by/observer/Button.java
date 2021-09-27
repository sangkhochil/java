package com.behavioral.pattern.mediator.by.observer;

public class Button extends UIControl {
	boolean isEnabled;
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
		notifyObservers();
	}
}
