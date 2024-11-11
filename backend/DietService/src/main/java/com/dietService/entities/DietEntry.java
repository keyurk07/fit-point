package com.dietService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DietEntry {
	
	@Id
	long id;
	String itemName;
	long qty;
	long calculated_calories;
	long calculated_protiens;
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

	public long getCalculated_calories() {
		return calculated_calories;
	}

	public void setCalculated_calories(long calculated_calories) {
		this.calculated_calories = calculated_calories;
	}

	public long getCalculated_protiens() {
		return calculated_protiens;
	}

	public void setCalculated_protiens(long calculated_protiens) {
		this.calculated_protiens = calculated_protiens;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	long userId;
	
	public DietEntry() {
		super();
	}

	
}
