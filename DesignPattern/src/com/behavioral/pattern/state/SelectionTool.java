package com.behavioral.pattern.state;

public class SelectionTool implements Tool {

	@Override
	public void MouseDown() {
		System.out.println("Selction Tool MouseDown");
	}

	@Override
	public void MouseUp() {
		System.out.println("Selection Tool MouseUp");
	}
}
