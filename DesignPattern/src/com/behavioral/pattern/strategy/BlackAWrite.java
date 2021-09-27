package com.behavioral.pattern.strategy;

public class BlackAWrite implements Filter {

	@Override
	public void apply(String fileNage) {
		System.out.println("Black & write fiter");
	}
}
