package com.learning.java;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Writer implements Runnable {

	String title;
	String fileText;

	public Writer(String title, String fileText) {
		super();
		this.title = title;
		this.fileText = fileText;
	}

	@Override
	public void run() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("/home/preethi/Downloads/multithreading/output/" + title + ".txt", "UTF-8");
			writer.println(fileText);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}

	}

}
