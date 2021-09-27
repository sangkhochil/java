package com.behavioral.pattern.strategy;

public class Main {

	public static void main(String[] args) {
		ImageStorage imageStorage = new ImageStorage();
		imageStorage.store("a", new JpegCompressor(), new BlackAWrite());
		imageStorage.store("a", new PngCompressor(), new BlackAWrite());
	}
}
