package com.behavioral.pattern.mediator;

public abstract class UIControl {
	DialogBox owner;

	public UIControl(DialogBox owner) {
		this.owner = owner;
	}
}
