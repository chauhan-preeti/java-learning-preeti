package com.learning.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Reader thread to get wiki description of word
 * 
 * @author preethi
 *
 */
public class Reader implements Runnable {

	String line;

	private static Logger logger = Logger.getLogger(Reader.class.getName());

	public Reader(String line) {
		super();
		this.line = line;
	}

	@Override
	public void run() {
		URL url;
		try {
			StringBuilder fileText = new StringBuilder();
			url = new URL(
					"https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&formatversion=2&explaintext=&titles="
							+ line.replace(" ", "_"));
			try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()))) {
				Object obj;
				obj = new JSONParser().parse(br);
				JSONObject objJSONObject = (JSONObject) obj;
				JSONObject objJSONObject1 = (JSONObject) objJSONObject.get("query");
				if (objJSONObject1 != null) {
					JSONArray objJSONArray = (JSONArray) objJSONObject1.get("pages");
					if (objJSONArray != null) {
						for (int i = 0; i < objJSONArray.size(); i++) {
							JSONObject objJSONObject2 = (JSONObject) objJSONArray.get(i);
							if (objJSONObject2 != null && objJSONObject2.containsKey("extract")) {
								fileText.append(objJSONObject2.get("extract").toString());
							}
						}
						Thread writerThread = new Thread(
								new Writer(line.replaceAll(" ", "_").replaceAll("/", "_"), fileText));
						writerThread.start();
					}
				}
			}
		} catch (IOException | ParseException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
	}
}
