package com.structural.pattern.facade;

public class Main {

	public static void main(String[] args) {
		var service = new NotificationService();
		service.send("hallo world", "Target");
	}
}
