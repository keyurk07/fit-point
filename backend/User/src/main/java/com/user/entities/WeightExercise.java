package com.user.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeightExercise {
	private long weightId;
	private String exerciseType;
	private long sets;
	private long reps;
	private double weight;
	private LocalDateTime dateTime;	
	private long userId;


}
