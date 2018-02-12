package com.learning.java;

import java.io.File;

import com.learning.java.Reader;

/**
 * Class to get the count of word in multiple files
 * 
 * @author preethi
 *
 */
public class GetWordCount {
	
	private  static final String DIR_PATH = "/home/preethi/Downloads/multithreading/output/";
	
	public static void main(String[] args) {		
		long startTime = System.currentTimeMillis();
		File directory = new File(DIR_PATH);
		File[] listOfFiles = directory.listFiles();
		if (listOfFiles != null) {
			Thread readerThread = new Thread(new Reader(listOfFiles));
			readerThread.start();
		}
		System.out.println("Time taken " + (System.currentTimeMillis() - startTime) + " ms");
	}
}
