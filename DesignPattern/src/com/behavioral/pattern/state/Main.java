package com.behavioral.pattern.state;

public class Main {

	public static void main(String[] args) {
		var canvas = new Canvas();
		
		canvas.setCurrentTool(new SelectionTool());
		canvas.MouseDown();
		canvas.MouseUp();
		
		canvas.setCurrentTool(new BrashTool());
		canvas.MouseDown();
		canvas.MouseUp();
		
		canvas.setCurrentTool(new EraserTool());
		canvas.MouseDown();
		canvas.MouseUp();
	}
}
