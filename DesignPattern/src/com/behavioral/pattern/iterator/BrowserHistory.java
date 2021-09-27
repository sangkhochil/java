package com.behavioral.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory<T> {
	private List<T> urls = new ArrayList();
	public void push(T value) {
		urls.add(value);
	}
	
	public Iterator<T> createIterator(){
		return new ListIterator(this);
	}
	
	private class ListIterator implements Iterator<T>{
		BrowserHistory<T> browser;
		ListIterator(BrowserHistory<T> browser){
			this.browser = browser;
		}
		private int index;
		@Override
		public boolean hasNext() {
			return index < urls.size();
		}

		@Override
		public T current() {
			return urls.get(index);
		}

		@Override
		public void next() {
			index++;
		}		
	}
}
