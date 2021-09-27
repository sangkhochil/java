package com.structural.pattern.decorator;

public class CloudStream implements Stream {
	
	@Override
	public void store(String data) {
		System.out.println("Storing = " + data);
	}
}
