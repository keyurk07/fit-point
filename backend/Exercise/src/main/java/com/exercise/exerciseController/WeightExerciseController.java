package com.exercise.exerciseController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.entities.WeightExercise;
import com.exercise.services.WeightExerciseService;

@RestController
@RequestMapping("/api/weight-exercise")
@CrossOrigin
public class WeightExerciseController {
	 @Autowired
	    private WeightExerciseService weightExerciseService;

	    @GetMapping
	    public ResponseEntity<List<WeightExercise>> getAllExercises() {
	        List<WeightExercise> exercises = weightExerciseService.getAllExercises();
	        return new ResponseEntity<>(exercises, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<WeightExercise> getExerciseById(@PathVariable("id") long weightId) {
	        return weightExerciseService.getExerciseById(weightId)
	                .map(exercise -> new ResponseEntity<>(exercise, HttpStatus.OK))
	                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }
	    @PostMapping
	    public ResponseEntity<WeightExercise> createExercise(@RequestBody WeightExercise weightExercise) {
	    	weightExercise.setDateTime(LocalDateTime.now());
	    	WeightExercise createdExercise = weightExerciseService.createExercise(weightExercise);
	        return new ResponseEntity<>(createdExercise, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<WeightExercise> updateExercise(@PathVariable("id") long weightId, @RequestBody WeightExercise weightExercise) {
	    	weightExercise.setDateTime(LocalDateTime.now());
	    	Optional<WeightExercise> newWeightExercise=weightExerciseService.getExerciseById(weightId);
	    	if(newWeightExercise.isPresent()) {
	    		return ResponseEntity.ok().body(weightExerciseService.updateExercise(weightId, weightExercise));
	    	}
	    	else {
	    		return ResponseEntity.noContent().build();
	    	}
	        
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteExercise(@PathVariable("id") long weightId) {
	        weightExerciseService.deleteExercise(weightId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    @GetMapping("/search/{name}")
	    public ResponseEntity<List<WeightExercise>> findByExerciseTypeContaining(@PathVariable("name") String exerciseType) {
	        List<WeightExercise> exercises = weightExerciseService.findByExerciseTypeContaining(exerciseType);
	        return exercises.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(exercises, HttpStatus.OK);
	    }
	    @PostMapping("/calculateCalories")
	    public ResponseEntity<Double> calculateCalories(@RequestBody WeightExercise exercise) {
	        double weightLifted = exercise.getWeight(); 
	        long reps = exercise.getReps();
	        long sets = exercise.getSets();
	        double metValue = 4.5;

	        double caloriesBurned = (weightLifted * reps * sets / 1000) * metValue;

	        return ResponseEntity.ok(caloriesBurned);
	    }


}
