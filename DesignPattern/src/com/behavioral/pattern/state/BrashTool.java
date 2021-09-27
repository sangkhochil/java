package com.behavioral.pattern.state;

public class BrashTool implements Tool {

	@Override
	public void MouseDown() {
		System.out.println("Brash Tool MouseDown");
	}

	@Override
	public void MouseUp() {
		System.out.println("Brash Tool MouseUp");
	}
}
