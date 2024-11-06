package com.exercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.entities.CardioExercise;
import com.exercise.entities.WeightExercise;

@Repository
public interface WeightExerciseRepository extends JpaRepository<WeightExercise, Long> {
	List<WeightExercise> findByExerciseTypeContaining(String exerciseType); 
}
