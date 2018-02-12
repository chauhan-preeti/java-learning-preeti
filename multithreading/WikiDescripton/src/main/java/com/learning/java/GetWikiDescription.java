package com.learning.java;

import com.learning.java.model.Constants;

/**
 * Implementation to get wiki description
 * 
 * @author preethi
 *
 */
public class GetWikiDescription {
	
	private static String fileType = "lineType";

	public static void main(String[] args) {
		if(fileType.equals(Constants.CSV_TYPE))
		{
			CSVReader objCSVReader = new CSVReader();
			objCSVReader.getFileContents("/home/preethi/Downloads/multithreading/Multithreading_Task_2_java Keywords.txt");
		}
		else if(fileType.equals(Constants.TAB_TYPE))
		{
			TabSeparatedReader objTabSeperatedReader = new TabSeparatedReader();
			objTabSeperatedReader.getFileContents("/home/preethi/Downloads/multithreading/Multithreading_Task_2_fortune1000companies.txt");
		}
		else if(fileType.equals(Constants.LINE_TYPE))
		{
			LineReader objLineReader = new LineReader();
			objLineReader.getFileContents("/home/preethi/Downloads/multithreading/Multithreading_Task2_ProgrammingLanguages.txt");
		}		
	}
}
