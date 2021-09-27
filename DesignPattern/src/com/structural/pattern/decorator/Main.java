package com.structural.pattern.decorator;

public class Main {

	public static void main(String[] args) {
		Stream stream =new EncryptCloudStream(new CompressCloudStream(new CloudStream()));
		stream.store("1234-1234-1234-1234");
	}
}
