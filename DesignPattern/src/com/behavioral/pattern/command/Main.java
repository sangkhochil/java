package com.behavioral.pattern.command;

public class Main {

	public static void main(String[] args) {
		AddUserService adduser = new AddUserService();
		Command command = new ServiceCommand(adduser);
		Button button = new Button(command);
		button.click();
	}
}
