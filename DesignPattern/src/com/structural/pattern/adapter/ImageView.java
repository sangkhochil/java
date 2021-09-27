package com.structural.pattern.adapter;

public class ImageView {
	Image image;

	public ImageView(Image image) {
		this.image = image;
	}
	
	public void apply(Filter filter) {
		filter.filter();
	}
}
