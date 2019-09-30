package com.wms.api.dto;

/**
 * This is a ProductCategoryDTO class which holds the information of the product
 * category
 * 
 * @author arifk2
 *
 */
public class ProductCategoryDTO {
	private long productCategoryId;
	private String productCategoryName;
	private String productCategoryDescription;
	private String imagePath;

	public long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

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

}
