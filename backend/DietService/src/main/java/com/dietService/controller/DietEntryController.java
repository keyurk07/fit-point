package com.dietService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dietService.entities.DietEntry;
import com.dietService.services.DietEntryService;

@RestController
@RequestMapping("/api/diet")
public class DietEntryController {
	 @Autowired
	    private DietEntryService dietEntryService;

	    // POST method to add a new diet entry
	    @PostMapping("/add")
	    public ResponseEntity<DietEntry> addDietEntry(@RequestBody DietEntry dietEntry) {
	        DietEntry createdDietEntry = dietEntryService.addDiet(dietEntry.getItemName(),dietEntry.getQty());
	        if (createdDietEntry != null) {
	            return new ResponseEntity<>(createdDietEntry, HttpStatus.CREATED);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    @GetMapping("/all")
	    public ResponseEntity<List<DietEntry>> getAllDietEntries() {
	        List<DietEntry> dietEntries = dietEntryService.getAllDietEntries();
	        return new ResponseEntity<>(dietEntries, HttpStatus.OK);
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<DietEntry> getDietEntryById(@PathVariable long id) {
	        DietEntry dietEntry = dietEntryService.getDietEntryById(id);
	        if (dietEntry != null) {
	            return new ResponseEntity<>(dietEntry, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    @GetMapping("/nutrition/{itemId}")
	    public ResponseEntity<String> getCaloriesAndProteinsByItemId(@PathVariable long itemId) {
	        DietEntry dietEntry = dietEntryService.getDietEntryById(itemId);
	        
	        if (dietEntry != null) {
	            double calories = dietEntry.getCalculated_calories();
	            double proteins = dietEntry.getCalculated_protiens();
	            String response = "Calories: " + calories + ", Proteins: " + proteins + "g";
	            return new ResponseEntity<>(response, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    
	    @PutMapping("/update/{id}")
	    public ResponseEntity<DietEntry> updateDietEntry(@PathVariable long id, @RequestBody DietEntry updatedDietEntry) {
	        DietEntry updatedEntry = dietEntryService.updateDietEntry(id, updatedDietEntry.getItemName(),updatedDietEntry.getQty());
	        if (updatedEntry != null) {
	            return new ResponseEntity<>(updatedEntry, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteDietEntry(@PathVariable long id) {
	        boolean isDeleted = dietEntryService.deleteDietEntry(id);
	        if (isDeleted) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }



	    


}
