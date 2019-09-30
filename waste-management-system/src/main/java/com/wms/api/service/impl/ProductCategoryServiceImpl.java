package com.wms.api.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.wms.api.dao.ProductCategoryDAO;
import com.wms.api.dto.ProductCategoryDTO;
import com.wms.api.exception.ApplicationCustomException;
import com.wms.api.service.ProductCategoryService;

/**
 * This is a class created to hold the product category service information
 * 
 * @author ArifKhan
 *
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryDAO productCategoryDAO;

	@Autowired
	private MessageSource messageSource;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ProductCategoryDTO saveProductCategory(ProductCategoryDTO productCategoryDTO)
			throws HibernateException, ApplicationCustomException {
		if (productCategoryDTO != null) {
			boolean saveStatus = productCategoryDAO.saveProductCategroy(productCategoryDTO);
			if (saveStatus) {
				return productCategoryDTO;
			}
		}
		return null;
	}

	@Override
	@Transactional
	public ProductCategoryDTO getProductCategory(ProductCategoryDTO productCategoryDTO)
			throws NoSuchMessageException, ApplicationCustomException {
		if (productCategoryDTO != null) {
			if (!StringUtils.isEmpty(productCategoryDTO.getProductCategoryName())) {
				ProductCategoryDTO producCategoryFromDB = productCategoryDAO
						.getProductCategory(productCategoryDTO.getProductCategoryName());
				if (producCategoryFromDB != null) {
					return producCategoryFromDB;
				}
			} else {
				throw new ApplicationCustomException(
						messageSource.getMessage("productCategoryName.cannot.blank", null, null));
			}
		}
		return null;
	}

	@Override
	@Transactional
	public List<ProductCategoryDTO> getProductCategory() {
		List<ProductCategoryDTO> productCategoryList = productCategoryDAO.get();
		if (productCategoryList != null) {
			return productCategoryList;
		}
		return null;
	}
}