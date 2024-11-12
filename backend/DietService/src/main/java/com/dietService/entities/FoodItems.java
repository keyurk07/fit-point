package com.dietService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FoodItems {
	
	@Id
	long itemId;
	String itemName;
	long qty;
	double calorie_per_gram;
	double protien_per_gram;
	
	
	public FoodItems() {
		super();
	}
	
	


	public FoodItems(long itemId, String itemName, long qty, double calorie_per_gram, double protien_per_gram) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.qty = qty;
		this.calorie_per_gram = calorie_per_gram;
		this.protien_per_gram = protien_per_gram;
	}




	public long getItemId() {
		return itemId;
	}


	public void setItemId(long itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public long getQty() {
		return qty;
	}


	public void setQty(long qty) {
		this.qty = qty;
	}


	public double getCalorie_per_gram() {
		return calorie_per_gram;
	}


	public void setCalorie_per_gram(double calorie_per_gram) {
		this.calorie_per_gram = calorie_per_gram;
	}


	public double getProtien_per_gram() {
		return protien_per_gram;
	}


	public void setProtien_per_gram(double protien_per_gram) {
		this.protien_per_gram = protien_per_gram;
	}

	

}
