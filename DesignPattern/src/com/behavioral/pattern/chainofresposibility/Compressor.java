package com.behavioral.pattern.chainofresposibility;

public class Compressor extends Handler {

	public Compressor(Handler next) {
		super(next);
	}

	@Override
	protected boolean doHandle(HttpRequest request) {
		System.out.println("Compressor done");
		return true;
	}
}
