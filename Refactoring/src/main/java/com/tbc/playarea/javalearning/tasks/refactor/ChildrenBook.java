package com.tbc.playarea.javalearning.tasks.refactor;

import java.util.Date;

/**
 * Book with Fiction genre
 * @author preethi
 *
 */
public final class ChildrenBook extends Book{
	
	private static final long serialVersionUID = 7369566790143486799L;
	
	private static final int RENTAL_POINT = 1;
	private static final double BASE_PRICE = 1.5;
	private static final int THRESHOLD_DAYS = 3;
	private static final double MULTIPLYING_FACTOR = 2;

	public ChildrenBook(String title) {
		super(title,null);
	}
	
	public ChildrenBook(final String title, final Date releaseDate) {
		super(title, releaseDate);
	}
	
	public int fetchRentalPoints(int daysRented) {
		return RENTAL_POINT;
	}

	public double getBasePrice() {
		return BASE_PRICE;
	}

	public int getThresholdDays() {
		return THRESHOLD_DAYS;
	}

	public double getMultiplyingFactor() {
		return MULTIPLYING_FACTOR;
	}

}
