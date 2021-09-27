package com.behavioral.pattern.mediator;

public class ArticlesDialogBox extends DialogBox {
	ListBox listbox = new ListBox(this);
	TextBox textbox = new TextBox(this);
	Button button = new Button(this);
	
	public void changeItem() {
		listbox.setSelected("LisItem1");
		System.out.println(textbox.getText());
		System.out.println(button.isEnabled());
		textbox.setText("");
		System.out.println(button.isEnabled());
	}
	
	@Override
	void changed(UIControl control) {
		if(control == listbox)
			selectedItem();
		if(control == textbox)
			textChanged();
	}
	
	private void selectedItem() {
		textbox.setText(listbox.getSelected());
		//button.setEnabled(true);
	}
	
	private void textChanged() {
		var text = textbox.getText();
		var isEmpty = (text == null || text.isEmpty());
		button.setEnabled(!isEmpty);
	}
}
