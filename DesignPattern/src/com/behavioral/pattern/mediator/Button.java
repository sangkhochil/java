package com.behavioral.pattern.mediator;

public class Button extends UIControl {
	boolean isEnabled;
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
		owner.changed(this);
	}
	public Button(DialogBox owner) {
		super(owner);
	}
}
