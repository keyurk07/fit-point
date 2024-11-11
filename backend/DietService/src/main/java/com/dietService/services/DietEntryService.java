package com.dietService.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dietService.entities.DietEntry;
import com.dietService.entities.FoodItems;
import com.dietService.repository.DietEntryRepository;
import com.dietService.repository.FoodItemsRepository;

@Service
public class DietEntryService {
	
	@Autowired
	DietEntryRepository dietEntryRepo;
	
	@Autowired
	FoodItemsRepository foodItemsRepo; 
	
	public DietEntry addDiet(String itemName, long qty) {
		Optional<FoodItems> newFoodItem = foodItemsRepo.findByItemName(itemName);
		if(newFoodItem.isPresent()) {
			DietEntry newDietEntry = new DietEntry();
			newDietEntry.setItemName(itemName);
			newDietEntry.setQty(qty);
			newDietEntry.setCalculated_calories(newFoodItem.get().getCalorie_per_gram());
			newDietEntry.setCalculated_protiens(newFoodItem.get().getProtien_per_gram());
			
			return dietEntryRepo.save(newDietEntry);
		}
		else {
			return null;
		}
	}
	
	

}
