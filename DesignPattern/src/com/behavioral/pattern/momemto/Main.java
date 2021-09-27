package com.behavioral.pattern.momemto;

public class Main {

	public static void main(String[] args) {
		Editor editor = new Editor();
		editor.setContent("a");
		editor.setContent("b");
		editor.setContent("c");
		System.out.println(editor.undo());
		editor.setContent("d");
		System.out.println(editor.undo());
		System.out.println(editor.undo());
		System.out.println(editor.undo());
		System.out.println(editor.undo());
	}
}
