package com.rana.ecom.model;

import java.io.Serializable;
import java.util.Date;

public class Price implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2506311971567929131L;
	private String type;
	private Date startDate;
	private Date endDate;
	private String value;
	private String unit;
	
	
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	

}
