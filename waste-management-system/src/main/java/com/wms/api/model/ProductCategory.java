package com.wms.api.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author arifk2
 *
 */
@Entity
@Table(name = "product_category")
public class ProductCategory {

	@Id
	@Column(name = "product_category_id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long productCategoryId;

	@Column(name = "product_category_name")
	private String productCategoryName;

	@Column(name = "product_category_description")
	private String productCategoryDescription;

	@Column(name = "image_path")
	private String imagePath;

	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL)
	private Set<Product> products;

	public ProductCategory() {
	}

	public ProductCategory(long productCategoryId, String productCategoryName, String productCategoryDescription,
			String imagePath, Set<Product> products) {
		this.productCategoryId = productCategoryId;
		this.productCategoryName = productCategoryName;
		this.productCategoryDescription = productCategoryDescription;
		this.imagePath = imagePath;
		this.products = products;
	}

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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setProductCategoryDescription(String productCategoryDescription) {
		this.productCategoryDescription = productCategoryDescription;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}