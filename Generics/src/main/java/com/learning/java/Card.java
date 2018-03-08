package com.learning.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum for types of card
 * 
 * @author preethi
 *
 */
public enum Card {
	CARBON("carbon"), RUBYX("rubyx"), SAPPHIRO("sapphiro");
	String cardName;

	private Card(String cardName) {
		this.cardName = cardName;
	}

	public String getcardName() {
		return cardName;
	}

	protected void setcardName(String cardName) {
		this.cardName = cardName;
	}
	
	 private static Map<String, Card> map = new HashMap<>();
	
	 static {
	        for (Card cardEnum : Card.values()) {
	            map.put(cardEnum.cardName, cardEnum);
	        }
	    }
	 public static <T> Card valueOf(T val) {
	        return map.get(val);
	    }
}
