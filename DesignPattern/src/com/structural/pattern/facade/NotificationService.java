package com.structural.pattern.facade;

public class NotificationService {
	public void send(String message, String target) {
		var server = new NotificationServer();
		var conn = server.ConnectionToServer();
		var token = server.authentication("appID", "key");
		server.send(token, new Message(message), target);
		conn.disConnect();
	}
}
