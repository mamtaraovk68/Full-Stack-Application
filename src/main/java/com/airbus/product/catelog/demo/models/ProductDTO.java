package com.airbus.product.catelog.demo.models;

import javax.persistence.Entity;

import lombok.Data;


public class ProductDTO {

	public ProductDTO() {
		
	}
	
	public ProductDTO(String productId, String productCategory, String productName, String productDesc,
			int unit) {
		super();
		this.productId = productId;
		this.productCategory = productCategory;
		this.productName = productName;
		this.productDesc = productDesc;
		this.unit =unit;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	String productId;
	String productCategory;
	String productName;
	String productDesc;
	int unit;
	
	
 
}
