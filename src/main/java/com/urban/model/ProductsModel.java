package com.urban.model;

public class ProductsModel {
	private int productId;
	private int productPrice;
	private int inStock;
	private String productName;
	
	public ProductsModel() {
		
	}

	public ProductsModel(int productId, String productName, int productPrice, int inStock) {
		super();
		this.productId = productId;
		this.productPrice = productPrice;
		this.inStock = inStock;
		this.productName = productName;
	}
	
	public ProductsModel( String productName, int productPrice, int inStock) {
		this.productPrice = productPrice;
		this.inStock = inStock;
		this.productName = productName;
	}




	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	

}
