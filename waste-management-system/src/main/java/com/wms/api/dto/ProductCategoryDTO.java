package com.wms.api.dto;

import java.util.Set;

/**
 * This is a ProductCategoryDTO class which holds the information of the product
 * category
 * 
 * @author arifk2
 *
 */
public class ProductCategoryDTO {
	private String productCategoryName;
	private String productCategoryDescription;
	private String imagePath;
	private Set<ProductDTO> products;

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public String getProductCategoryDescription() {
		return productCategoryDescription;
	}

	public void setProductCategoryDescription(String productCategoryDescription) {
		this.productCategoryDescription = productCategoryDescription;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Set<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDTO> products) {
		this.products = products;
	}
}
