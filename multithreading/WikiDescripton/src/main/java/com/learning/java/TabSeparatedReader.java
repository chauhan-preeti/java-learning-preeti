package com.learning.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.learning.java.model.*;
import com.learning.thread.Reader;

/**
 * This class read the tab separated words
 * 
 * @author preethi
 *
 */
public class TabSeparatedReader extends FileContentReader {

	private static Logger logger = Logger.getLogger(TabSeparatedReader.class.getName());

	@Override
	protected void getFileContents(String fileName) {
		try (BufferedReader br1 = new BufferedReader(new FileReader(fileName))) {
			for (String line; (line = br1.readLine()) != null;) {
				if (!line.isEmpty()) {
					String[] words = line.split("\t");
					for (int i = 0; i < words.length; i++) {
						if (!words[i].isEmpty() && i == 1) {
							Thread readerThread = new Thread(new Reader(words[i].trim()));
							readerThread.start();
						}
					}
				}
			}
		} catch (IOException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
	}
}
