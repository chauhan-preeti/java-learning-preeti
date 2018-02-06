package com.learning.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetWikiDescription {

	public static void main(String args[]) throws IOException {
		try (BufferedReader br1 = new BufferedReader(new FileReader(
				"/home/preethi/Downloads/multithreading/Multithreading_Task2_ProgrammingLanguages.txt"))) {
			for (String line; (line = br1.readLine()) != null;) {
				if (line.isEmpty())
					continue;
				else {
					Thread readerThread = new Thread(new Reader(line));
					readerThread.start();
				}

			}
		}
	}
}
