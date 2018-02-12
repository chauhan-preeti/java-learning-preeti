package com.tbc.playarea.javalearning.tasks.service.impl;

import java.util.List;
import java.util.ListIterator;

import com.tbc.playarea.javalearning.tasks.refactor.Rental;
import com.tbc.playarea.javalearning.tasks.service.StatementService;

/**
 * Implementation to generate statement on console
 * 
 * @author preethi
 *
 */
public class ConsoleStatementGenerator implements StatementService {

	public void generateStatement(List<Rental> rentals, String name) {

		double totalAmount = 0;
		int frequentRenterPoints = 0;
		StringBuilder result = new StringBuilder("Rental Record for customer : " + name + "\n");

		result.append("Book Title\tAmount\n");

		for (ListIterator<Rental> rentalsItr = rentals.listIterator(); rentalsItr.hasNext();) {
			double thisAmount = 0;
			Rental rental = rentalsItr.next();
			thisAmount += rental.fetchRentalPrice();
			frequentRenterPoints = rental.fetchRentalPoints();
			result.append(rental.getBook().getTitle()).append("\t").append(String.valueOf(thisAmount)).append("\n");
			totalAmount += thisAmount;
		}

		result.append("Amount owed is ").append(String.valueOf(totalAmount)).append("\n");
		result.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");
		
		System.console().writer().println(result.toString());

	}

}
