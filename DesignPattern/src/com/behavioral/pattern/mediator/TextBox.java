package com.behavioral.pattern.mediator;

public class TextBox extends UIControl {
	String text;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
		owner.changed(this);
	}
	
	public TextBox(DialogBox owner) {
		super(owner);
	}

}
