package com.structural.pattern.decorator;

public class EncryptCloudStream implements Stream {
	Stream stream;
	
	public EncryptCloudStream(Stream stream) {
		this.stream = stream;
	}

	@Override
	public void store(String data) {
		String encrypt = encryption(data);
		stream.store(encrypt);
	}
	
	private String encryption(String data) {
		return "@##$%^&*)(*&^%$#";
	}

}
