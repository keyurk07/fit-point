package com.dietService.services;

import java.util.List;
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
			newDietEntry.setCalculated_calories(newFoodItem.get().getCalorie_per_gram() * qty);
			newDietEntry.setCalculated_protiens(newFoodItem.get().getProtien_per_gram() * qty);
			
			return dietEntryRepo.save(newDietEntry);
		}
		else {
			return null;
		}
	}
	
	public List<DietEntry> getAllDietEntries() {
	    return dietEntryRepo.findAll();
	}
	
	public DietEntry getDietEntryById(long id) {
	    Optional<DietEntry> dietEntry = dietEntryRepo.findById(id);
	    return dietEntry.orElse(null);
	}
	
	public DietEntry updateDietEntry(long id, String itemName, long qty) {
	    Optional<DietEntry> existingEntry = dietEntryRepo.findById(id);
	    if (existingEntry.isPresent()) {
	        DietEntry dietEntry = existingEntry.get();
	        
	        Optional<FoodItems> foodItem = foodItemsRepo.findByItemName(itemName);
	        if (foodItem.isPresent()) {
	            dietEntry.setItemName(itemName);
	            dietEntry.setQty(qty);
	            dietEntry.setCalculated_calories(foodItem.get().getCalorie_per_gram() * qty);
	            dietEntry.setCalculated_protiens(foodItem.get().getProtien_per_gram() * qty);

	            return dietEntryRepo.save(dietEntry);
	        }
	    }
	    return null;
	}
	
	public boolean deleteDietEntry(long id) {
	    Optional<DietEntry> dietEntry = dietEntryRepo.findById(id);
	    if (dietEntry.isPresent()) {
	        dietEntryRepo.deleteById(id);
	        return true;
	    }
	    return false;
	}
	

}
