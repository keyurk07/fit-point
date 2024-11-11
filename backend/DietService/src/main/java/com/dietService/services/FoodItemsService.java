package com.dietService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dietService.repository.FoodItemsRepository;

@Service
public class FoodItemsService {
	
	@Autowired
	FoodItemsRepository foodItemRepo;

}
