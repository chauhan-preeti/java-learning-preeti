package com.tbc.playarea.javalearning.tasks.refactor;

import java.io.Serializable;
import java.util.Date;

/**
 * Book class to represent Book data and methods.
 * 
 * @author preethi
 *
 */
public abstract class Book implements Serializable {

	private static final long serialVersionUID = 181769423955843694L;
	
	private Date releaseDate;
	private String title;

	public Book(final String title, final Date releaseDate) {
		super();
		this.title = title;
		this.releaseDate = releaseDate;
	}

	public Book(final String title) {
		this(title, null);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	/**
	 * To get rent price
	 * 
	 * @param daysRented
	 *            Number of days book is rented for
	 * @return rent price corresponding book and number of days it has been rented
	 *         for
	 */
	public double fetchRentPrice(int daysRented) {
		double amount = getBasePrice();
		int thresholdDays = getThresholdDays();
		if (daysRented > thresholdDays) {
			amount += (daysRented - thresholdDays) * getMultiplyingFactor();
		}
		return amount;
	}

	/**
	 * To get Base price
	 * 
	 * @return base rent
	 */
	public abstract double getBasePrice();

	/**
	 * To get number of days for which rent is fixed
	 * 
	 * @return threshold days
	 */
	public abstract int getThresholdDays();

	/**
	 * Multiplying factor for increasing rent
	 * 
	 * @return multiplying factor
	 */
	public abstract double getMultiplyingFactor();

	/**
	 * To fetch rent price
	 * 
	 * @param daysRented
	 *            Number of days for which book has been rented
	 * @return Rental points
	 */
	public abstract int fetchRentalPoints(int daysRented);

}
