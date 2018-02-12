package com.tbc.playarea.javalearning.tasks.refactor;

import java.util.Date;

/**
 * Book with non-fiction genre
 * @author preethi
 *
 */
public final class NonFictionBook extends Book{

	private static final long serialVersionUID = -1889102819958704565L;
	
	private static final int RENTAL_POINT = 1;
	private static final double BASE_PRICE = 0;
	private static final int THRESHOLD_DAYS = 0;
	private static final double MULTIPLYING_FACTOR = 3;

	public NonFictionBook(String title) {
		super(title,null);
	}
	
	public NonFictionBook(final String title, final Date releaseDate) {
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
