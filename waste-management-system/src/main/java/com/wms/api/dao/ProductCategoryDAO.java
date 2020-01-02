package com.wms.api.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.context.NoSuchMessageException;

import com.wms.api.dto.ProductCategoryDTO;
import com.wms.api.exception.ApplicationCustomException;

/**
 * 
 * @author ArifKhan
 *
 */
public interface ProductCategoryDAO {

	/**
	 * This method is created to save the product category
	 * 
	 * @param productCategoryDTO
	 * @return
	 * @throws HibernateException
	 * @throws ApplicationCustomException
	 */
	public Serializable saveProductCategroy(ProductCategoryDTO productCategoryDTO)
			throws HibernateException, ApplicationCustomException;

	/**
	 * This method is created to get the product information based on the product
	 * category name.
	 * 
	 * @param productCategoryName holds the information of the product category
	 * @return
	 * @throws ApplicationCustomException
	 * @throws NoSuchMessageException
	 */
	public ProductCategoryDTO getProductCategory(String productCategoryName)
			throws NoSuchMessageException, ApplicationCustomException;

	/**
	 * This method is created fetch the list of the product category
	 * 
	 * @return
	 */
	public List<ProductCategoryDTO> get();
}
