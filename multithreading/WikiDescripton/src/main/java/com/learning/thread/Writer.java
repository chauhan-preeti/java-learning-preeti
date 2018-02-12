package com.learning.thread;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Writer thread to write description in text file
 * 
 * @author preethi
 *
 */
public class Writer implements Runnable {

	String title;
	StringBuilder fileText;
	
	private static Logger logger = Logger.getLogger(Writer.class.getName());

	public Writer(String title, StringBuilder fileText) {
		super();
		this.title = title;
		this.fileText = fileText;
	}

	@Override
	public void run() {
		try(PrintWriter writer = new PrintWriter("/home/preethi/Downloads/multithreading/output/" + title + ".txt", "UTF-8")){
			writer.println(fileText);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
	}
}
