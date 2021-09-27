package com.behavioral.pattern.strategy;

public class JpegCompressor implements Compressor {

	@Override
	public void compress(String fileNage) {
		System.out.println("Jpeg Compressor");
	}

}
