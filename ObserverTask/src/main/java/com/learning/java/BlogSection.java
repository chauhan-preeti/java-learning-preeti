package com.learning.java;

import java.util.ArrayList;
import java.util.Observer;

public class BlogSection implements Blog {

	ArrayList<Observer> observers = new ArrayList<Observer>();

	public void register(Observer observer) {
		synchronized (this) {
			observers.add(observer);
		}
	}

	public void unregister(Observer observer) {
		synchronized (this) {
			observers.remove(observer);
		}
	}

	public void update() {

	}
}
