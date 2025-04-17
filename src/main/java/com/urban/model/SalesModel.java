package com.urban.model;

import java.time.LocalDate;

public class SalesModel {
	private int salesId;
	private int userId;
	private int productId;
	private int salesPrice;
	private LocalDate salesDate;
	
	public SalesModel() {
		
	}

	public SalesModel(int salesId, int userId, int productId, int salesPrice, LocalDate salesDate) {
		super();
		this.salesId = salesId;
		this.userId = userId;
		this.productId = productId;
		this.salesPrice = salesPrice;
		this.salesDate = salesDate;
	}

	public int getSalesId() {
		return salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(int salesPrice) {
		this.salesPrice = salesPrice;
	}

	public LocalDate getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(LocalDate salesDate) {
		this.salesDate = salesDate;
	}
	
	

}
