package com.learning.java;

public enum Card {
	CARBON("carbon"), RUBYX("rubyx"), SAPPHIRO("sapphiro");
	String getCard;

	private Card(String getCard) {
		this.getCard = getCard;
	}
	
	public String getGetCard() {
		return getCard;
	}
	
	protected void setGetCard(String getCard) {
		this.getCard = getCard;
	}
}
