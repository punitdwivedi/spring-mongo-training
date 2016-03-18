package com.rana.ecom.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.rana.ecom.config.DBManager;
import com.rana.ecom.model.Price;
import com.rana.ecom.model.Product;
import com.rana.ecom.model.UpdateProduct;

@Component
public class EcomDaoImpl implements IEcomDao {

	@Autowired
	DBManager dbManager;

	@Override
	public List<Product> getProductByCategory(String category, int skip,
			int limit) throws Exception {

		List<Product> products = null;
		Query qry = new Query();
		qry.addCriteria(Criteria.where("category").is(category));
		qry.with(new Sort(Sort.Direction.ASC, "name")).skip(skip).limit(limit);

		try {
			products = dbManager.getMongoTemplate().find(qry, Product.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return products;
	}

	@Override
	public Product getProductById(String id) throws Exception {
		Product product = null;
		Query qry = new Query();
		qry.addCriteria(Criteria.where("id").is(id));

		try {
			product = dbManager.getMongoTemplate().findOne(qry, Product.class);
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
		return product;
	}

	@Override
	public int insertProduct(Product product) throws Exception {
		try {
			dbManager.getMongoTemplate().insert(product);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return 0;
	}

	@Override
	public List<Product> getProductsByCategory(String category, int skip,
			int limit) throws Exception {
		List<Product> products = null;
		final Query query = new Query();
		query.addCriteria(Criteria.where("category").is(category));
		query.with(new Sort(Sort.Direction.DESC, "createDate")).skip(skip)
				.limit(limit);
		try {
			products = dbManager.getMongoTemplate().find(query, Product.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return products;
	}

	@Override
	public int addOrUpdateAttribute(String attrName, String attrValue, String id)
			throws Exception {

		Query qry = new Query();
		Update upd = new Update();

		String key = "attributes.".concat(attrName);
		qry.addCriteria(Criteria.where("_id").is(id));
		upd.set(key, attrValue);
		dbManager.getMongoTemplate().updateFirst(qry, upd, Product.class);
		return 0;
	}

	@Override
	public int updateProduct(String attrName, String value, String id)
			throws Exception {

		Query qry = new Query();
		Update upd = new Update();

		qry.addCriteria(Criteria.where("_id").is(id));
		upd.set(attrName, value);
		upd.set("updateDate", new Date(System.currentTimeMillis()));
		try {
			dbManager.getMongoTemplate().updateFirst(qry, upd, Product.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		return 0;
	}

	@Override
	public int updateProductNew(UpdateProduct product) throws Exception {

		if (product != null) {
			Map<String, String> attrMap = product.getAttrMap();
			if (attrMap != null && attrMap.size() > 0) {

				Query qry = new Query();
				Update upd = new Update();

				qry.addCriteria(Criteria.where("_id").is(product.getId()));

				Set<Map.Entry<String, String>> entry = attrMap.entrySet();
				for (Map.Entry<String, String> ent : entry) {
					String key = ent.getKey();
					String value = ent.getValue();

					upd.set(key, value);

				}
				upd.set("updateDate", new Date(System.currentTimeMillis()));
				dbManager.getMongoTemplate().updateFirst(qry, upd,
						Product.class);
			}
		}

		return 0;
	}

	@Override
	public int updatePrice(Product product) throws Exception {
		
		List<Price> prices = product.getPriceInfo();
		Query qry = new Query();
		Update upd = new Update();
		
		Product pdt = dbManager.getMongoTemplate().findOne(qry, Product.class);
		
		
		qry.addCriteria(Criteria.where("_id").is(product.getId()));
		
		pdt.getPriceInfo().addAll(product.getPriceInfo());
		
		try {
			//dbManager.getMongoTemplate().updateFirst(qry, upd, Product.class);
			dbManager.getMongoTemplate().save(pdt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateInventory(Product product) throws Exception {
		
		
		Query qry = new Query();
		Update upd = new Update();
		
		qry.addCriteria(Criteria.where("_id").is(product.getId()));
		upd.set("inventory", product.getInventory());
		
		dbManager.getMongoTemplate().updateFirst(qry, upd, Product.class);
		
		
		return 0;
	}

}
