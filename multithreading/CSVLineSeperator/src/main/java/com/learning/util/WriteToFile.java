package com.learning.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation to write the content in text file
 * 
 * @author preethi
 *
 */
public class WriteToFile {
	
	private static Logger logger = Logger.getLogger(WriteToFile.class.getName());
	
	private static AtomicInteger fileNumber = new AtomicInteger();

	/**
	 * Method to write content in file
	 * 
	 * @param fileText lines to be written in text file
	 */
	public void writeData(List<String> fileText) {
		try (PrintWriter writer = new PrintWriter("/home/preethi/Downloads/multithreading/output/" + fileNumber.incrementAndGet() + ".txt",
				"UTF-8")) {
			writer.println(fileText);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
			
		}
	}
}
