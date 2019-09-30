package com.wms.api.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.context.NoSuchMessageException;

import com.wms.api.dto.ProductCategoryDTO;
import com.wms.api.exception.ApplicationCustomException;

/**
 * This is a interface holds the method information of the product category
 * related
 * 
 * @author ArifKhan
 *
 */
public interface ProductCategoryService {
	/**
	 * This method is created to save the product information in the database;
	 * 
	 * @param productCategoryDTO
	 * @return
	 * @throws HibernateException
	 * @throws ApplicationCustomException
	 */
	public ProductCategoryDTO saveProductCategory(ProductCategoryDTO productCategoryDTO)
			throws HibernateException, ApplicationCustomException;

	/**
	 * This method is created to get the product category information
	 * 
	 * @param productCategoryDTO
	 * @return
	 * @throws ApplicationCustomException
	 * @throws NoSuchMessageException
	 */
	public ProductCategoryDTO getProductCategory(ProductCategoryDTO productCategoryDTO)
			throws NoSuchMessageException, ApplicationCustomException;

	/**
	 * This method is created to get the list of the product category
	 * 
	 * @return
	 */
	public List<ProductCategoryDTO> getProductCategory();

}
