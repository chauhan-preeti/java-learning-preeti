package com.learning.java.model;


/**
 * Class to read the content of file
 * 
 * @author preethi
 *
 */
public abstract class FileContentReader {
	
	/**
	 * @param fileName name of file to be processed
	 */
	protected abstract void getFileContents(String fileName);

}
