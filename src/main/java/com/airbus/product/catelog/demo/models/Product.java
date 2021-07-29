package com.airbus.product.catelog.demo.models;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "myProductCollection")
@EntityScan
public class Product {

	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String id, String productId, String productCategory, String productName, String productDesc, int unit) {
		super();
		this.id=id;
		this.productId = productId;
		this.productCategory = productCategory;
		this.productName = productName;
		this.productDesc = productDesc;
		this.unit = unit;
	}
	
	
	@Id
	String id;
	String productId;
	String productCategory;
	String productName;
	String productDesc;
	int unit;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	
}
