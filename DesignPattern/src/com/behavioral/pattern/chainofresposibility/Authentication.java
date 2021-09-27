package com.behavioral.pattern.chainofresposibility;

public class Authentication extends Handler {

	public Authentication(Handler next) {
		super(next);
	}

	@Override
	protected boolean doHandle(HttpRequest request) {
		System.out.println("Authentication Done..");
		return true;
	}
}
