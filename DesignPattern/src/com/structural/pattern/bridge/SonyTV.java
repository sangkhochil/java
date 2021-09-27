package com.structural.pattern.bridge;

public class SonyTV implements Device {

	@Override
	public void turnOn() {
		System.out.println("Sony TurnOn");
	}

	@Override
	public void turnOff() {
		System.out.println("Sony TurnOff");
	}

	@Override
	public void setChannel(int number) {
		System.out.println("Sony setChannel: " + number);
	}

}
