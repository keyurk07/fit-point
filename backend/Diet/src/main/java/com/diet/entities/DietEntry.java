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
public class DietEntry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long id;
	String itemName;
	long userId;
	long qty;
	double calculated_calories;
	double calculated_protiens;
	
}
