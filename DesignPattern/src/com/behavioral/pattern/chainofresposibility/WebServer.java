package com.behavioral.pattern.chainofresposibility;

public class WebServer {
	Handler handler;

	public WebServer(Handler handler) {
		this.handler = handler;
	};
	
	public void handle(HttpRequest request) {
		handler.handle(request);
	}
}
