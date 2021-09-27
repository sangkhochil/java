package com.structural.pattern.decorator;

public class CompressCloudStream implements Stream {
	Stream stream;
	public CompressCloudStream(Stream stream) {
		this.stream = stream;
	}
	
	@Override
	public void store(String data) {
		String compress = compress(data);
		stream.store(compress);
	}
	private String compress(String data) {
		return data.substring(0,5);
	}
}
