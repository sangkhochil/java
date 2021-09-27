package com.behavioral.pattern.momemto;

public class Editor {
	History editor = new History();
	public void setContent(String content) {
		editor.push(new EditorState(content));
	}
	
	public String undo() {
		return editor.pop().getContent();
	}
}
