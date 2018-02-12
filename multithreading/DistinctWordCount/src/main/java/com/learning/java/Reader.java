package com.learning.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.learning.java.Writer;

/**
 * Reader Thread
 * 
 * @author preethi
 *
 */
public class Reader implements Runnable {

	private static Logger logger = Logger.getLogger(Reader.class.getName());

	File[] listOfFiles;
	static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

	public Reader(File[] listOfFiles) {
		super();
		this.listOfFiles = listOfFiles;
	}

	@Override
	public void run() {
		for (File child : listOfFiles) {
			Thread writerThread = new Thread(new Writer(child, map));
			writerThread.start();
			try {
				writerThread.join();
			} catch (InterruptedException e) {
				logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
				Thread.currentThread().interrupt();
			}
		}
		writeWordsToFile();
	}

	/**
	 * Method to write the words in text file 
	 */
	public static void writeWordsToFile() {
		try (PrintWriter writer = new PrintWriter("/home/preethi/Downloads/multithreading/output/" + "words.txt",
				"UTF-8")) {
			for (String word : map.keySet()) {
				writer.println(word);
			}
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
	}
}
