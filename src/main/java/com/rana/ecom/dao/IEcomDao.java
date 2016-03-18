package com.rana.ecom.dao;

import java.util.List;

import com.rana.ecom.model.Product;
import com.rana.ecom.model.UpdateProduct;

public interface IEcomDao {
	
	
	public List<Product> getProductByCategory(String category, int skip, int limit) throws Exception;
	
	public Product getProductById(String id) throws Exception;
	
	public int insertProduct(Product product) throws Exception;
	
	public List<Product> getProductsByCategory(String category, int skip, int limit) throws Exception;
	
	public int addOrUpdateAttribute(String attrName, String attrValue, String id) throws Exception;
	
	public int updateProduct(String attrName, String value, String id) throws Exception;
	
	public int updateProductNew(UpdateProduct product) throws Exception;
	
	public int updatePrice(Product product) throws Exception;
	
	public int updateInventory(Product product) throws Exception;

}
