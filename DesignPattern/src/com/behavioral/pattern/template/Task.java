package com.behavioral.pattern.template;

public abstract class Task {
	AuditTrail audit;
	
	public Task() {
		audit = new AuditTrail();
	}
	
	public void execute() {
		audit.record();
		doExecute();
	}
	
	protected abstract void doExecute();
}
