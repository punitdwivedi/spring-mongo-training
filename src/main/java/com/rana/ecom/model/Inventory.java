package com.rana.ecom.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Inventory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1481813744495423374L;
	private int totalQuantity;
	private Date lastUpdatedOn;
	private List<Store> stores;
	
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	public List<Store> getStores() {
		return stores;
	}
	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
	
	
	

}
