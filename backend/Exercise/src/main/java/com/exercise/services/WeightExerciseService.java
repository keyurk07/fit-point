package com.exercise.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.exercise.entities.WeightExercise;

import com.exercise.repository.WeightExerciseRepository;

@Service
public class WeightExerciseService {
	@Autowired
    private WeightExerciseRepository weightExerciseRepository;
	
	public List<WeightExercise> getAllExercises() {
        return weightExerciseRepository.findAll();
    }

    public Optional<WeightExercise> getExerciseById(long weightId) {
        return weightExerciseRepository.findById(weightId);
    }

    public WeightExercise createExercise(WeightExercise weightExercise) {
        return weightExerciseRepository.save(weightExercise);
    }

    public WeightExercise updateExercise(long weightId, WeightExercise weightExercise) {
        weightExercise.setWeightId(weightId);
        return weightExerciseRepository.save(weightExercise);
    }

    public void deleteExercise(long weightId) {
    	weightExerciseRepository.deleteById(weightId);
    }

    public List<WeightExercise> findByExerciseTypeContaining(String exerciseType) {
        return weightExerciseRepository.findByExerciseTypeContaining(exerciseType); // Substring search
    }
    
}
