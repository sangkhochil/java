package com.behavioral.pattern.iterator;

public class Main {

	public static void main(String[] args) {
		BrowserHistory<String> brower = new BrowserHistory();
		brower.push("a");
		brower.push("b");
		brower.push("c");
		
		Iterator<String> iterator = brower.createIterator();
		while(iterator.hasNext()) {
			String url = iterator.current();
			System.out.println(url);
			iterator.next();
		}
	}
}
