package com.learning.java;

public class Spilt {

	public static void main(String args[]) {
		/*
		 * CSVLineSeperator objCSVLineSeperator = new CSVLineSeperator(); int
		 * nooffiles = objCSVLineSeperator.readData();
		 */
		String inputFilePath = "/home/preethi/Downloads/multithreading/Multithreading_Task1_Books.csv";
		Thread thread = new Thread(new Reader(inputFilePath));
		thread.start();
	}
}
