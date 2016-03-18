package com.rana.ecom.model;

import java.io.Serializable;
import java.util.Date;

public class Store implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7272279456660761294L;
	private String name;
	private int quantity;
	private String quantityUnit;
	private Date lastUpdatedOn;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	
	
	
	

}
