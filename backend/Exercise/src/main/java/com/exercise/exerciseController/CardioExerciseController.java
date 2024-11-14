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
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.entities.CardioExercise;
import com.exercise.services.CardioExerciseService;

@RestController
@RequestMapping("/api/cardio-exercises")
@CrossOrigin
public class CardioExerciseController {

    @Autowired
    private CardioExerciseService cardioExerciseService;

    @GetMapping
    public ResponseEntity<List<CardioExercise>> getAllExercises() {
        List<CardioExercise> exercises = cardioExerciseService.getAllExercises();
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardioExercise> getExerciseById(@PathVariable("id") long cardioId) {
        return cardioExerciseService.getExerciseById(cardioId)
                .map(exercise -> new ResponseEntity<>(exercise, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CardioExercise> createExercise(@RequestBody CardioExercise cardioExercise) {
    	cardioExercise.setDateTime(LocalDateTime.now());
        CardioExercise createdExercise = cardioExerciseService.createExercise(cardioExercise);
        return new ResponseEntity<>(createdExercise, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardioExercise> updateExercise(@PathVariable("id") long cardioId, @RequestBody CardioExercise cardioExercise) {
    	cardioExercise.setDateTime(LocalDateTime.now());
    	Optional<CardioExercise> newCardioExercise = cardioExerciseService.getExerciseById(cardioId);
    	if(newCardioExercise.isPresent()) {
//        return new ResponseEntity<>(cardioExerciseService.updateExercise(cardioId, cardioExercise), HttpStatus.OK);
    		return ResponseEntity.ok().body(cardioExerciseService.updateExercise(cardioId,cardioExercise));
    	}
    	else {
    		return ResponseEntity.noContent().build();
    	}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable("id") long cardioId) {
        cardioExerciseService.deleteExercise(cardioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<CardioExercise>> findByExerciseTypeContaining(@PathVariable("name") String exerciseType) {
        List<CardioExercise> exercises = cardioExerciseService.findByExerciseTypeContaining(exerciseType);
        return exercises.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(exercises, HttpStatus.OK);
    }
    
    @PostMapping("/calculate-calories")
    public ResponseEntity<Double> calculateCaloriesBurnt(@RequestBody CardioExercise calorieRequest) {
        double caloriesBurnt = cardioExerciseService.calculateCaloriesBurnt(
                calorieRequest.getExerciseType(),
                calorieRequest.getDistance(),
                calorieRequest.getTimeSpent()
        );

        // Return the calculated calories as a response
        return new ResponseEntity<>(caloriesBurnt, HttpStatus.OK);
    }


}