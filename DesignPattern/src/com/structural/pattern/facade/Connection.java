package com.structural.pattern.facade;

public class Connection {
	private String ip;

	public Connection(String ip) {
		this.ip = ip;
	}

	public void disConnect() {
		System.out.println("disconnect");
	}
}
