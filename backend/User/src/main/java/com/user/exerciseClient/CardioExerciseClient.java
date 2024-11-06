package com.user.exerciseClient;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.entities.CardioExercise;

@FeignClient(value = "ExerciseClient", url = "http://localhost:9001/api/cardio-exercises")
public interface CardioExerciseClient {
	
	@GetMapping
	public List<CardioExercise> getAllExercises();
	
	@GetMapping("{id}")
	public Optional<CardioExercise> getExerciseById(@PathVariable("id") long cardioId);
	
	@PostMapping
	public CardioExercise createExercise(@RequestBody CardioExercise cardioExercise);
	
	@GetMapping("/search/{name}")
    public List<CardioExercise> findByExerciseTypeContaining(@PathVariable("name") String exerciseType);
	
	@DeleteMapping("{id}")
    public Void deleteExercise(@PathVariable("id") long cardioId);
	
    @PutMapping("{id}")
	public CardioExercise updateExercise(@PathVariable("id") long cardioId, @RequestBody CardioExercise cardioExercise);

}
