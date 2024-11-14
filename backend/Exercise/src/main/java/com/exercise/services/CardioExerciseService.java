package com.exercise.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.entities.CardioExercise;
import com.exercise.repository.CardioExerciseRepository;

@Service
public class CardioExerciseService {
	
	@Autowired
    private CardioExerciseRepository cardioExerciseRepository;
	
	public List<CardioExercise> getAllExercises() {
        return cardioExerciseRepository.findAll();
    }

    public Optional<CardioExercise> getExerciseById(long cardioId) {
        return cardioExerciseRepository.findById(cardioId);
    }

    public CardioExercise createExercise(CardioExercise cardioExercise) {
//    	long setNewUserId = cardioExerciseRepository.get
        return cardioExerciseRepository.save(cardioExercise);
    }

    public CardioExercise updateExercise(long cardioId, CardioExercise cardioExercise) {
        cardioExercise.setCardioId(cardioId);
        return cardioExerciseRepository.save(cardioExercise);
    }

    public void deleteExercise(long cardioId) {
        cardioExerciseRepository.deleteById(cardioId);
    }

    public List<CardioExercise> findByExerciseTypeContaining(String exerciseType) {
        return cardioExerciseRepository.findByExerciseTypeContaining(exerciseType); // Substring search
    }
    
    public double calculateCaloriesBurnt(String exerciseType, double distance, long timeSpent) {
        double calories = 0.0;

        switch (exerciseType.toLowerCase()) {
            case "walking":
                calories = (distance * 0.5) + (timeSpent * 3); 
                break;
            case "running":
                calories = (distance * 0.8) + (timeSpent * 5); 
                break;
            case "cycling":
                calories = (distance * 0.4) + (timeSpent * 4); 
                break;
            default:
                throw new IllegalArgumentException("Invalid exercise type");
        }
        return calories;
    }

}
