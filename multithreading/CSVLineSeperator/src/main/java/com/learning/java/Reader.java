package com.learning.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Reader implements Runnable {

	private String inputFilePath;

	public Reader(String filePath) {
		super();
		this.inputFilePath = filePath;
	}

	public void run() {
		long startTime = System.currentTimeMillis();
		String inputFileName = "/Multithreading_Task1_Books.csv";
		List<String> inputLines = null;
		URI uri;
		try {
			uri = this.getClass().getResource(inputFileName).toURI();
			inputLines = Files.readAllLines(Paths.get(uri), Charset.defaultCharset());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ForkJoinPool objForkJoinPool = new ForkJoinPool();
		ForkJoinWriter objForkJoinWriter = new ForkJoinWriter(inputLines);
		objForkJoinPool.invoke(objForkJoinWriter);
		long endTime = System.currentTimeMillis();
		System.out.println("total time taken " + (endTime - startTime) + "ms");
	}

}
