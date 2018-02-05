package com.learning;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ForkWriteToFile {

	static int i=0;
	public void writeData(List<String> fileText, String timestamp) {
		PrintWriter writer = null;
		try {
			i++;
			//String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			writer = new PrintWriter("/home/preethi/Downloads/multithreading/output/" + timestamp + String.valueOf(i) + ".txt", "UTF-8");
			writer.println(fileText);
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
