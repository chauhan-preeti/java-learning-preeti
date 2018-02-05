package com.learning;

public class Spilt {

	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		/*
		 * CSVLineSeperator objCSVLineSeperator = new CSVLineSeperator(); int
		 * nooffiles = objCSVLineSeperator.readData();
		 */
		String inputFilePath = "/home/preethi/Downloads/multithreading/Multithreading_Task1_Books.csv";
		Thread thread = new Thread(new Reader(inputFilePath));
		thread.start();
		long endTime = System.currentTimeMillis();
		System.out.println("total time taken " + (endTime - startTime) + " ms fileNumber");
	}
}
