package com.wms.api.dto;

/**
 * This is a ProductDTo class which holds the information of the product.
 * 
 * @author arifk2
 *
 */
public class ProductDTO {

	private String productName;
	private String productDescription;
	private float productPrice;
	private String imagePath;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
