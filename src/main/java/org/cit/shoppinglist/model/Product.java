package org.cit.shoppinglist.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Product Class is used to hold product information
 * 
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	
	@Min(1)
	private double price;
	
	@Size(min=1,max=20, message="Name can not be empty")
	private String name;
	
	@Size(min=1,max=20, message="Description can not be empty")
	private String description;

	public Product() {

	}

	/**
	 * @param id
	 * @param price
	 * @param name
	 * @param description
	 */
	public Product(int id, double price, String name, String description) {
		this.id = id;
		this.price = price;
		this.name = name;
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
