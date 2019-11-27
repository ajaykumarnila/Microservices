package com.infy.customerservice.models;

public class Product {
	private String productId;
	private String productName;
	private int rating;
	
	public Product() {}
	
	public Product(String productId) {
		this.productId = productId;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
