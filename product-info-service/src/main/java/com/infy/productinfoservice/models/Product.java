package com.infy.productinfoservice.models;

public class Product {
	private String productId;
	private String productName;
	
	public Product() {}
	
	public Product(String productId,String productName) {
		this.productId = productId;
		this.productName=productName;
	}

	
	public String getProductId() {
		return productId;
	}

	

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}	
}