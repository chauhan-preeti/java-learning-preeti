package com.tbc.playarea.javalearning.tasks.service;

import java.util.List;

import com.tbc.playarea.javalearning.tasks.refactor.Rental;

/**
 * Service class to generate statement for customer
 * 
 * @author preethi
 *
 */
public interface StatementService {

	/**
	 * To generate statement
	 * 
	 * @param rentals
	 *            List of rentals
	 * @param name
	 *            Name of customer for which the statement has to be generated
	 */
	public void generateStatement(List<Rental> rentals, String name);

}