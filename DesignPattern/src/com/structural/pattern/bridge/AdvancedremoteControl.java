package com.structural.pattern.bridge;

public class AdvancedremoteControl extends RemoteControl{
	public AdvancedremoteControl(Device device) {
		super(device);
	}
	
	public void setChannel(int number) {
		device.setChannel(number);
	}
}
