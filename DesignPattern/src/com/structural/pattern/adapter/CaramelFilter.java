package com.structural.pattern.adapter;

public class CaramelFilter implements Filter {
	Caramel caramel;
	public CaramelFilter(Caramel caramel) {
		this.caramel = caramel;
	}
	
	@Override
	public void filter() {
		caramel.init();
		caramel.render();
	}

}
