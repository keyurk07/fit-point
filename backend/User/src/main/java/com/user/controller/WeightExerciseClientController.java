package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entities.CardioExercise;
import com.user.entities.CardioExerciseDTO;
import com.user.entities.WeightExercise;
import com.user.entities.WeightExerciseDTO;
import com.user.exerciseClient.WeightExerciseClient;

@RequestMapping("/weightClient")
@RestController
public class WeightExerciseClientController {
	@Autowired
	private WeightExerciseClient weightExerciseClient;
	@GetMapping("/")
	public List<WeightExercise> getAllExercises(){
		return  weightExerciseClient.getAllExercises();
	}
	
	@GetMapping("/{id}")
	public Optional<WeightExercise> getExerciseById(@PathVariable("id") long weightId){
		return weightExerciseClient.getExerciseById(weightId);
	}
	
	
	
	@PostMapping("/{id}")
	public WeightExercise createExercise(@PathVariable("id") long userId,@RequestBody WeightExerciseDTO weightExerciseDTO) {
		WeightExercise newweight = new WeightExercise();
		newweight.setReps(weightExerciseDTO.getReps());
		newweight.setSets(weightExerciseDTO.getSets());
		newweight.setWeight(weightExerciseDTO.getWeight());
		newweight.setExerciseType(weightExerciseDTO.getExerciseType());
		newweight.setUserId(userId);
		return weightExerciseClient.createExercise(newweight);
		
	}
	@GetMapping("/search/{name}")
    public List<WeightExercise> findByExerciseTypeContaining(@PathVariable("name") String exerciseType){
		return weightExerciseClient.findByExerciseTypeContaining(exerciseType);
	}

	@DeleteMapping("/{id}")
    public Void deleteExercise(@PathVariable("id") long weightId) {
		return weightExerciseClient.deleteExercise(weightId);
	}
	
    @PutMapping("/{id}")
	public WeightExercise updateExercise(@PathVariable("id") long weightId, @RequestBody WeightExercise weightExercise) {
    	return weightExerciseClient.updateExercise(weightId, weightExercise);
    }
    


}
