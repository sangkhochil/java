package com.jgr.reflection;

abstract class CalculateAble<T>{
	abstract T add(T a, T b); 
}	 
public class Test {	 
	public static void main(String[] args) {
		CalculateAble<Integer> a = new CalculateAble<>() { // diamond operator is empty 
			public Integer add(Integer a, Integer b){  
				return a+b;   
			}  
		};
		int result = a.add(10, 20);
		System.out.println(result);
	}
}