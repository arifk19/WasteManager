package com.wms.api.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wms.api.dao.ProductDAO;
import com.wms.api.dto.ProductCategoryDTO;
import com.wms.api.dto.ProductDTO;
import com.wms.api.model.Product;
import com.wms.api.model.ProductCategory;
import com.wms.api.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	@Transactional
	public ProductCategoryDTO saveProductWithCategory(ProductCategoryDTO productCategoryDTO) {
		if (productCategoryDTO != null) {

			ProductCategory productCategory = new ProductCategory();
			Set<Product> products = new HashSet<Product>();
			Product product = new Product();

			if (productCategoryDTO.getProducts().size() != 0) {
				for (ProductDTO productDTO : productCategoryDTO.getProducts()) {
					product.setProductName(productDTO.getProductName());
					product.setProductDescription(productDTO.getProductDescription());
					product.setProductPrice(productDTO.getProductPrice());
					products.add(product);
				}
			}
			productCategory.setProductCategoryName(productCategoryDTO.getProductCategoryName());
			productCategory.setProductCategoryDescription(productCategoryDTO.getProductCategoryDescription());
			productCategory.setProducts(products);

			Long producId = productDAO.save(productCategory);
			if (producId != null) {
				return productCategoryDTO;
			}
		}
		return null;
	}
}
