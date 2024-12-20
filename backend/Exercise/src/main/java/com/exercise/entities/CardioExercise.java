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
public class CardioExercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cardioId;
	private String exerciseType;
	private double distance;
	private long timeSpent;
	private LocalDateTime dateTime;
	
	private long userId;

}
