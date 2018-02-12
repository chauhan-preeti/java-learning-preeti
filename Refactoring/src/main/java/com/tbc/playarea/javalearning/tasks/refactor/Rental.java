/**
 * 
 */
package com.tbc.playarea.javalearning.tasks.refactor;

import java.io.Serializable;

/**
 * Represent a customer renting a book.
 * 
 * @author preethi
 *
 */
public class Rental implements Serializable {

	private static final long serialVersionUID = -6466914761602264846L;
	
	private Book book;
	private int daysRented;

	public Rental(Book book, int daysRented) {
		super();
		this.book = book;
		this.daysRented = daysRented;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}

	public double fetchRentalPrice() {
		return book.fetchRentPrice(getDaysRented());
	}

	public int fetchRentalPoints() {
		return book.fetchRentalPoints(getDaysRented());
	}

}
