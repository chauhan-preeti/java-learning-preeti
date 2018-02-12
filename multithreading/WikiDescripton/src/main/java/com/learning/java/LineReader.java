package com.learning.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.learning.java.model.*;
import com.learning.thread.Reader;

/**
 * This class reads one word per line
 * 
 * @author preethi
 *
 */
public class LineReader extends FileContentReader {

	private static Logger logger = Logger.getLogger(LineReader.class.getName());

	@Override
	protected void getFileContents(String fileName) {
		try (BufferedReader br1 = new BufferedReader(new FileReader(fileName))) {
			for (String line; (line = br1.readLine()) != null;) {
				if (line.isEmpty())
					continue;
				else {
					Thread readerThread = new Thread(new Reader(line));
					readerThread.start();
				}

			}
		} catch (IOException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
	}
}
