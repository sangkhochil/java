package com.behavioral.pattern.command;

public class ServiceCommand implements Command {
	AddUserService addUserService;
	public ServiceCommand(AddUserService addUserService) {
		super();
		this.addUserService = addUserService;
	}
	
	@Override
	public void execute() {
		addUserService.addUser();
	}
}
