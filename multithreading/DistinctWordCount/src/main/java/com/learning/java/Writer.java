package com.learning.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Writer thread to count the word
 * 
 * @author preethi
 *
 */
public class Writer implements Runnable {

	private static Logger logger = Logger.getLogger(Writer.class.getName());

	File file;
	ConcurrentMap<String, Integer> map;

	public Writer(File file, ConcurrentMap<String, Integer> map) {
		super();
		this.file = file;
		this.map = map;
	}

	@Override
	public void run() {
		try (BufferedReader br1 = new BufferedReader(new FileReader(file.toString()))) {
			for (String line; (line = br1.readLine()) != null;) {
				String[] words = line.split(" ");
				for (int i = 0; i < words.length; i++) {
					String word = words[i];

					if (map.containsKey(word))
						map.put(word, map.get(word) + 1);
					else {
						map.put(word, 1);
					}
				}
			}
		} catch (IOException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
	}
}
