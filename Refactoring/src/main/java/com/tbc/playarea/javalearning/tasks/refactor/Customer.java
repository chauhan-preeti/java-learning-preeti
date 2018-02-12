/**
 * 
 */
package com.tbc.playarea.javalearning.tasks.refactor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Customer class to denotes customer details and operations.
 * 
 * @author preethi
 *
 */
public class Customer implements Serializable {
	
	private static final long serialVersionUID = -1381461621803728605L;
	
	private long id;
	private String name;

	private List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void addRental(final Rental rental) {
		getRentals().add(rental);
	}

}
