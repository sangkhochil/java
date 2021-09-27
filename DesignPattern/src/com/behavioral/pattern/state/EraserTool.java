package com.behavioral.pattern.state;

public class EraserTool implements Tool {

	@Override
	public void MouseDown() {
		System.out.println("Eraer Tool MouseDown");
	}

	@Override
	public void MouseUp() {
		System.out.println("Eraser Tool MouseUp");
	}
}
