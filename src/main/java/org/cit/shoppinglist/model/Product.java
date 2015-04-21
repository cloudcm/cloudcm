package org.cit.shoppinglist.model;

import java.io.Serializable;

/**
 * Product Class is used to hold product information
 * 
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private double price;
	private String name;
	private String detail;

	public Product() {

	}

	/**
	 * @param id
	 * @param price
	 * @param name
	 * @param detail
	 */
	public Product(int id, double price, String name, String detail) {
		this.id = id;
		this.price = price;
		this.name = name;
		this.detail = detail;
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
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * @param detail
	 *            the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
