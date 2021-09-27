package com.problem3;

public class Problem3 {
	public void Test() {
//		When we have two overloaded version of same method, JVM will always call most specific method.
//		child object method will call
		methodTest(null);
		
	}
	public void methodTest(Object object) {
		System.out.println("Calling object method");
	}

	public void methodTest(String object) { // <---- this method will call
		System.out.println("Calling String method");
	}
	
//	public void methodTest(StringBuffer object) {  // if i add this compiler get error. because
//		System.out.println("Calling StringBuffer method");
//	}
}
