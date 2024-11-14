package com.user.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeightExerciseDTO {

	private String exerciseType;
	private long reps;
	private long sets;
	private double weight;

}
