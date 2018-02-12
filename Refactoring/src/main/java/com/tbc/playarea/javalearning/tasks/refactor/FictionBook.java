package com.tbc.playarea.javalearning.tasks.refactor;

import java.util.Date;

/**
 * Book with Fiction genre
 * 
 * @author preethi
 *
 */
public final class FictionBook extends Book {

	private static final long serialVersionUID = -3506248503164716059L;
	
	private static final int RENTAL_POINT = 2;
	private static final double BASE_PRICE = 2;
	private static final int THRESHOLD_DAYS = 2;
	private static final double MULTIPLYING_FACTOR = 1.5;

	public FictionBook(String title) {
		super(title, null);
	}

	public FictionBook(final String title, final Date releaseDate) {
		super(title, releaseDate);
	}

	public int fetchRentalPoints(int daysRented) {
		return RENTAL_POINT;
	}

	@Override
	public double getBasePrice() {
		return BASE_PRICE;
	}

	@Override
	public int getThresholdDays() {
		return THRESHOLD_DAYS;
	}

	@Override
	public double getMultiplyingFactor() {
		return MULTIPLYING_FACTOR;
	}

}
