package com.user.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.user.exerciseClient.CardioExerciseClient;


@RequestMapping("/cardioClient")
@RestController
public class CardioExerciseClientController {
	
	@Autowired
	private CardioExerciseClient exerciseClient;
	
	@GetMapping("/")
	public List<CardioExercise> getAllCardioExercises(){
		return exerciseClient.getAllExercises();
	}
	@GetMapping("/{id}")
	public Optional<CardioExercise> getExerciseById(@PathVariable("id") long cardioId){
		return exerciseClient.getExerciseById(cardioId);
	}
	@GetMapping("/search/{name}")
	public List<CardioExercise> findByExerciseTypeContaining(@PathVariable("name") String exerciseType) {
		return exerciseClient.findByExerciseTypeContaining(exerciseType);
	} 
	@PostMapping("/{id}")
	public CardioExercise createExercise(@PathVariable("id") long userId,@RequestBody CardioExerciseDTO cardioExerciseDTO) {
		CardioExercise newcardio = new CardioExercise();
		newcardio.setDistance(cardioExerciseDTO.getDistance());
		newcardio.setTimeSpent(cardioExerciseDTO.getTimeSpent());
		newcardio.setExerciseType(cardioExerciseDTO.getExerciseType());
		newcardio.setUserId(userId);	
		return exerciseClient.createExercise(newcardio);
	}
	@DeleteMapping("/{id}")
    public Void deleteExercise(@PathVariable("id") long cardioId) {
		return exerciseClient.deleteExercise(cardioId);
	}
	 @PutMapping("/{id}")
		public CardioExercise updateExercise(@PathVariable("id") long cardioId, @RequestBody CardioExercise cardioExercise) {
		return exerciseClient.updateExercise(cardioId, cardioExercise);
	}

}
