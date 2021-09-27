package com.behavioral.pattern.chainofresposibility;

public class Main {

	public static void main(String[] args) {
		//pipeline process
		//Authentication -> Logger -> Compressor
		HttpRequest request = new HttpRequest();
		Compressor compressor = new Compressor(null);
		Logger logger = new Logger(compressor);
		Authentication authentication = new Authentication(logger);
		WebServer webserver = new WebServer(authentication);
		webserver.handle(request);
	}
}
