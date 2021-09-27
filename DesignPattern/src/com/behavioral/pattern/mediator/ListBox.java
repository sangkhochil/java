package com.behavioral.pattern.mediator;

public class ListBox extends UIControl {
	String selected;
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
		owner.changed(this);
	}
	public ListBox(DialogBox owner) {
		super(owner);
	}

}
