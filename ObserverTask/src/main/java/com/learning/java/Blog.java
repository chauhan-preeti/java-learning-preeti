package com.learning.java;

import java.util.Observer;

public interface Blog {
	
	public void register(Observer o);
	
	public void unregister(Observer o);
	
	public void update();
	

}
