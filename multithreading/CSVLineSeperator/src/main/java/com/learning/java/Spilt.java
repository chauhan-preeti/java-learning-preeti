package com.learning.java;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Implementation to convert CSV to text files
 * 
 * @author preethi
 *
 */
public class Spilt {

	private static final String OUTPUT = "/output";

	private static Logger logger = Logger.getLogger(Spilt.class.getName());

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Reader());
		thread.start();
		thread.join();
	}

	/**
	 * Method to create directory on current path
	 */
	public void createOutputDirectory() {
			String path = getPath();
			path += OUTPUT;
			
			File file = new File(path);
			if(!file.exists())
			{
				file.mkdir();
			}
			
	}

	/**
	 * Method to get the execution path
	 * @return String retruns the execution path
	 */
	public static String getPath() {
		String path = "";
		try {
			path = new File(".").getCanonicalPath();
		} catch (IOException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
		return path;
	}
}
