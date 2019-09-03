package com.wms.api.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wms.api.base.dao.BaseDAO;
import com.wms.api.dao.ProductDAO;
import com.wms.api.model.ProductCategory;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private BaseDAO<ProductCategory> productCategoryDAO;

	@Override
	public Long save(ProductCategory productCategory) {
		if (productCategory != null) {
			return (Long) productCategoryDAO.save(productCategory);
		}
		return null;
	}
}
