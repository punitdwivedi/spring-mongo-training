package com.rana.ecom.model;

import java.io.Serializable;
import java.util.Map;

public class UpdateProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4087010274891836823L;
	
	private String id;
	private Map<String, String> attrMap;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, String> getAttrMap() {
		return attrMap;
	}

	public void setAttrMap(Map<String, String> attrMap) {
		this.attrMap = attrMap;
	}
	
	

}
