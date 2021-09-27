package com.behavioral.pattern.strategy;

public class ImageStorage {	
	public ImageStorage() {
	}

	public void store(String fileNage, Compressor compress, Filter filter) {
		compress.compress(fileNage);
		filter.apply(fileNage);
	}
}
