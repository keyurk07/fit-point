package com.user.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class DietEntry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String itemName;
	long qty;
	double calculated_calories;
	double calculated_protiens;
	long userId;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public double getCalculated_calories() {
		return calculated_calories;
	}

	public void setCalculated_calories(double calculated_calories) {
		this.calculated_calories = calculated_calories;
	}

	public double getCalculated_protiens() {
		return calculated_protiens;
	}

	public void setCalculated_protiens(double calculated_protiens) {
		this.calculated_protiens = calculated_protiens;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	
	public DietEntry() {
		super();
	}

	
}
