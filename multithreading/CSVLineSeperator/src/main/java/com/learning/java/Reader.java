package com.learning.java;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Reader thread to read the content of input file
 * 
 * @author preethi
 *
 */
public class Reader implements Runnable {

	private static Logger logger = Logger.getLogger(Reader.class.getName());
	
	private static final String INPUT_FILE_NAME = "/Multithreading_Task1_Books.csv";

	public void run() {
		long startTime = System.currentTimeMillis();
		String inputFileName = INPUT_FILE_NAME;
		List<String> inputLines = null;
		URI uri;
		try {
			uri = this.getClass().getResource(inputFileName).toURI();
			inputLines = Files.readAllLines(Paths.get(uri), Charset.defaultCharset());
		} catch (IOException | URISyntaxException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
		ForkJoinPool objForkJoinPool = new ForkJoinPool();
		ForkJoinWriter objForkJoinWriter = new ForkJoinWriter(inputLines);
		objForkJoinPool.invoke(objForkJoinWriter);
		System.out.println("total time taken " + (System.currentTimeMillis() - startTime) + "ms");
		
	}

}
