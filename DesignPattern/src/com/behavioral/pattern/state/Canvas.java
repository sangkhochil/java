package com.behavioral.pattern.state;

public class Canvas {
	private Tool currentTool;
	
	void MouseDown() {
		this.currentTool.MouseDown();
	}
	
	void MouseUp() {
		currentTool.MouseUp();
	}

	public Tool getCurrentTool() {
		return currentTool;
	}

	public void setCurrentTool(Tool currentTool) {
		this.currentTool = currentTool;
	}
}
