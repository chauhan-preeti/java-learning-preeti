package com.learning.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CSVLineSeperator {

	public int readData() {
		BufferedReader br = null;
		String line = null;
		String fileText = "";
		int fileNumber = 0;
		int lineNumber = 5000;
		Scanner s = null;
		int i = 0;
		try {
			br = new BufferedReader(
					new FileReader("/home/preethi/Downloads/multithreading/Multithreading_Task1_Books.csv"));
			while (br.readLine() != null) {
				if (i < lineNumber) {
					line = br.readLine();
					fileText += line + "\n";
					// System.out.println(line);
					i++;
				} else {
					fileNumber++;
					System.out.println("Writing data" + fileNumber);
					writeData(fileText, fileNumber);
					i = 0;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fileNumber;
	}

	public void writeData(String line, int fileNumber) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("/home/preethi/Downloads/multithreading/output/" + String.valueOf(fileNumber)
					+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".txt", "UTF-8");
			writer.println(line);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
}