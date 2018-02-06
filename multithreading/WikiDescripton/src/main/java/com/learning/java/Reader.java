package com.learning.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Reader implements Runnable {

	String line;
	
	public Reader(String line) {
		super();
		this.line = line;
	}

	@Override
	public void run() {
		URL url;
		Iterator<Map.Entry> itr1 = null;
		try {
			url = new URL(
					"https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&formatversion=2&explaintext=&titles="
							+ line.replace(" ", "_"));
			try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()))) {
				Object obj;
				obj = new JSONParser().parse(br);
				JSONObject jo1 = (JSONObject) obj;
				JSONObject jo = (JSONObject) jo1.get("query");
				JSONArray ja = (JSONArray) jo.get("pages");
				Iterator itr2 = ja.iterator();
				while (itr2.hasNext()) {
					itr1 = ((Map) itr2.next()).entrySet().iterator();
					while (itr1.hasNext()) {
						Map.Entry pair = itr1.next();
						if (pair.getKey().equals("extract") && pair.getValue().toString() != null
								&& !pair.getValue().toString().isEmpty()) {
							Thread writerThread = new Thread(new Writer(line.replaceAll(" ", "_").replaceAll("/", "_"),
									pair.getValue().toString()));
							writerThread.start();
						}
					}
				}

			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
