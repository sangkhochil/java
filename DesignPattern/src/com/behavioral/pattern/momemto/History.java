package com.behavioral.pattern.momemto;

import java.util.ArrayList;
import java.util.List;

public class History {

	List<EditorState> list = new ArrayList<>();
	public void push(EditorState editorState) {
		list.add(editorState);
	}
	public EditorState pop() {
		int lastIndex = list.size() - 1;
		if(lastIndex < 0)
			return new EditorState("");
		
		EditorState lastState = list.get(lastIndex);
		list.remove(lastIndex);
		return lastState;
	}

}
