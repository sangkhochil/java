package com.behavioral.pattern.strategy;

public class PngCompressor implements Compressor {

	@Override
	public void compress(String fileNage) {
		System.out.println("Png Compressor");
	}
}
