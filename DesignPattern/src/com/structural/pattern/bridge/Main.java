package com.structural.pattern.bridge;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var remoteControl0 = new RemoteControl(new SonyTV());
		remoteControl0.turnOn();
		remoteControl0.turnOff();
		
		var remoteControl1 = new AdvancedremoteControl(new SamsungTV());
		remoteControl1.turnOn();
		remoteControl1.turnOff();
		remoteControl1.setChannel(1);
		
		var remoteControl2 = new AdvancedremoteControl(new SonyTV());
		remoteControl2.turnOn();
		remoteControl2.turnOff();
		remoteControl2.setChannel(3);
		Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        String s = scan.nextLine();
	}
}
