package com.behavioral.pattern.mediator.by.observer;

public class ArticlesDialogBox {
	ListBox listbox = new ListBox();
	TextBox textbox = new TextBox();
	Button button = new Button();
	
	public ArticlesDialogBox() {
		listbox.addObserver(this::selectedItem);		
		textbox.addObserver(this::textChanged);
	}
	
	public void changeItem() {
		listbox.setSelected("LisItem1");
		System.out.println(textbox.getText());
		System.out.println(button.isEnabled());
		textbox.setText("");
		System.out.println(button.isEnabled());
	}	
	
	private void selectedItem() {
		textbox.setText(listbox.getSelected());
	}
	
	private void textChanged() {
		var text = textbox.getText();
		var isEmpty = (text == null || text.isEmpty());
		button.setEnabled(!isEmpty);
	}
}
