package com.learning.java;

import java.util.LinkedHashMap;

/**
 * @author preethi this class implements the LRU cache
 *
 * @param <K> 
 * @param <V>
 */
public class LRUMain<K, V> extends LinkedHashMap<K, V> {
	
	private static final long serialVersionUID = -8580090813252762918L;
	
	private final int capacity;

	public LRUMain(int capacity) {
		super(capacity+1, 1.0f, true);
		this.capacity = capacity;
	}
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return (size() > this.capacity);
	}
	
	public static void main(String[] args) {
		int faults = 0;
		int[] arr = { 1, 2, 3, 5, 1, 3 };
		LRUMain<Integer, Integer> linkedSet = new LRUMain<>(4);

		for (int i = 0; i < arr.length; i++) {
			if(!linkedSet.containsValue(arr[i]))
				faults++;
			linkedSet.put(i, arr[i]);
		}
		System.out.println(linkedSet);
		System.out.println(faults);
	}
}
