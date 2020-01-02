package com.wms.api.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Repository;

import com.wms.api.base.dao.BaseDAO;
import com.wms.api.dao.ProductCategoryDAO;
import com.wms.api.dto.ProductCategoryDTO;
import com.wms.api.exception.ApplicationCustomException;
import com.wms.api.model.ProductCategory;

@Repository
public class ProductCategoryDAOImpl implements ProductCategoryDAO {

	@Autowired
	private BaseDAO<ProductCategory> productCategoryDAO;

	@Autowired
	private MessageSource messageSource;

	@Override
	public Serializable saveProductCategroy(ProductCategoryDTO productCategoryDTO)
			throws HibernateException, ApplicationCustomException {

		final ProductCategory productCategoryExist = (ProductCategory) productCategoryDAO.getCurrentSession()
				.createCriteria(ProductCategory.class)
				.add(Restrictions.eq("productCategoryName", productCategoryDTO.getProductCategoryName()))
				.uniqueResult();
		if (productCategoryExist != null) {
			throw new ApplicationCustomException(

					messageSource.getMessage("product.category.already.exist",
							new Object[] { productCategoryDTO.getProductCategoryName() }, null));
		} else {
			ProductCategory productCategory = new ProductCategory();
			if (productCategoryDTO.getProductCategoryName() != null) {
				productCategory.setProductCategoryName(productCategoryDTO.getProductCategoryName());
			}
			if (productCategoryDTO.getProductCategoryDescription() != null) {
				productCategory.setProductCategoryDescription(productCategoryDTO.getProductCategoryDescription());
			}
			Serializable productCategorySave = productCategoryDAO.save(productCategory);
			if (productCategorySave != null) {
				return productCategorySave;
			}
		}
		return null;
	}

	@Override
	public ProductCategoryDTO getProductCategory(String productCategoryName)
			throws NoSuchMessageException, ApplicationCustomException {

		final ProductCategory productCategoryExist = (ProductCategory) productCategoryDAO.getCurrentSession()
				.createCriteria(ProductCategory.class).add(Restrictions.eq("productCategoryName", productCategoryName))
				.uniqueResult();
		if (productCategoryExist == null) {
			throw new ApplicationCustomException(
					messageSource.getMessage("product.category.not.exist", new Object[] { productCategoryName }, null));
		} else {
			ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
			productCategoryDTO.setProductCategoryId(productCategoryExist.getProductCategoryId());
			productCategoryDTO.setProductCategoryName(productCategoryExist.getProductCategoryName());
			productCategoryDTO.setProductCategoryDescription(productCategoryExist.getProductCategoryDescription());
			productCategoryDTO.setImagePath(productCategoryExist.getImagePath());

			return productCategoryDTO;
		}
	}

	@Override
	public List<ProductCategoryDTO> get() {
		Criteria criteria = productCategoryDAO.getCurrentSession().createCriteria(ProductCategory.class);
		List<ProductCategory> productCategoryList = criteria.list();
		if (!productCategoryList.isEmpty() && productCategoryList.size() != 0) {
			List<ProductCategoryDTO> productCategoryDTOs = new ArrayList<>();

			for (ProductCategory productCategory : productCategoryList) {
				ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
				productCategoryDTO.setProductCategoryId(productCategory.getProductCategoryId());
				productCategoryDTO.setProductCategoryName(productCategory.getProductCategoryName());
				productCategoryDTO.setProductCategoryDescription(productCategory.getProductCategoryDescription());
				productCategoryDTO.setImagePath(productCategory.getImagePath());

				productCategoryDTOs.add(productCategoryDTO);
			}
			return productCategoryDTOs;
		}
		return null;
	}
}
