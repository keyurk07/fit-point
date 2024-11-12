package com.diet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diet.entities.DietEntry;
import com.diet.entities.FoodItems;
import com.diet.repository.DietEntryRepository;
import com.diet.repository.FoodItemsRepository;

@Service
public class DietEntryService {

    @Autowired
    private DietEntryRepository dietEntryRepository;

    @Autowired
    private FoodItemsRepository foodItemsRepository;

    public DietEntry calculateAndSaveDietEntry(DietEntry request) {
        // Fetch food item details from the repository based on itemName
        FoodItems foodItem = foodItemsRepository.findByItemName(request.getItemName())
            .orElseThrow(() -> new RuntimeException("Food item not found"));

        // Perform calorie and protein calculations
        double calculatedCalories = foodItem.getCalorie_per_gram() * request.getQty();
        double calculatedProteins = foodItem.getProtien_per_gram() * request.getQty();

        // Create and save a new DietEntry
        DietEntry dietEntry = new DietEntry();
        dietEntry.setItemName(request.getItemName());
        dietEntry.setUserId(request.getUserId());
        dietEntry.setQty(request.getQty());
        dietEntry.setCalculated_calories(calculatedCalories);
        dietEntry.setCalculated_protiens(calculatedProteins);

        return dietEntryRepository.save(dietEntry);
    }
    
    public Optional<List<DietEntry>> getAllDietEntriesByUserId(long userId) {
        return Optional.of(dietEntryRepository.findByUserId(userId));
    }
}
