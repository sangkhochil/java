package com.behavioral.pattern.mediator.by.observer;

public class TextBox extends UIControl {
	String text;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
		notifyObservers();
	}
}
