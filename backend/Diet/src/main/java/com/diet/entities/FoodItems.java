package com.diet.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long itemId;
	String itemName;
	long qty;
	double calorie_per_gram;
	double protien_per_gram;	

}
