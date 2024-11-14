package com.exercise.entities;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeightExercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long weightId;
	private String exerciseType;
	private long sets;
	private long reps;
	private double weight;
	private LocalDateTime dateTime;	
	private long userId;

}
