package com.structural.pattern.facade;

public class NotificationServer {
	// connection(ip) to server -> return connection
	// authentication(appID, key) -> return authtoken
	// send(authToken, message, target)
	// conn.disconnect();
	public Connection ConnectionToServer() {
		return new Connection("ip");
	}
	
	public AuthToken authentication(String appID, String key) {
		return new AuthToken();
	}
	
	public void send(AuthToken token, Message message, String target) {
		System.out.println("notify message: " + message.getContent());
	}
}
