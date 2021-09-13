package com.mvc.prducts;

public class Products {
	public Products(Integer id, String name, Integer quantity, double unitPrice) {
		
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	
	public Products(String name, Integer quantity, double unitPrice) {
		
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}




	private Integer id;
	private String name;
	private Integer quantity;
	private double unitPrice;
	
}
