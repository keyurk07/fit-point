package com.exercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exercise.entities.CardioExercise;

@Repository
public interface CardioExerciseRepository extends JpaRepository<CardioExercise, Long>{
	 List<CardioExercise> findByExerciseTypeContaining(String exerciseType); 
}
