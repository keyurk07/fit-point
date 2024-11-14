package com.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entities.CardioExercise;
import com.user.entities.CardioExerciseDTO;
import com.user.entities.DietEntry;
import com.user.entities.DietEntryRequestDto;
import com.user.entities.FoodItems;
import com.user.exerciseClient.DietEntryClient;

@RequestMapping("/dietEntryClient")
@RestController
public class DietEntryClientController {
	
	@Autowired
	DietEntryClient dietEntryClient;
	
	@PostMapping("/calculate/{userId}")
    public ResponseEntity<DietEntry> calculateDietEntry(@PathVariable long userId, @RequestBody DietEntryRequestDto request){
		DietEntry dietEntry =new DietEntry();
		dietEntry.setItemName(request.getItemName());
		dietEntry.setQty(request.getQty());
		dietEntry.setUserId(userId);
		return dietEntryClient.calculateDietEntry(dietEntry);
	}
	
	
}
