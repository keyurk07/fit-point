package com.user.exerciseClient;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.entities.WeightExercise;

@FeignClient(value = "weightExerciseClient", url = "http://localhost:9001/api/weight-exercise")
public interface WeightExerciseClient {
	
	@GetMapping
	public List<WeightExercise> getAllExercises();
	
	@GetMapping("{id}")
	public Optional<WeightExercise> getExerciseById(@PathVariable("id") long weightId);
	
	@PostMapping
	public WeightExercise createExercise(@RequestBody WeightExercise weightExercise);
	
	@GetMapping("/search/{name}")
    public List<WeightExercise> findByExerciseTypeContaining(@PathVariable("name") String exerciseType);

	@DeleteMapping("{id}")
    public Void deleteExercise(@PathVariable("id") long weightId);
	
    @PutMapping("{id}")
	public WeightExercise updateExercise(@PathVariable("id") long weightId, @RequestBody WeightExercise weightExercise);


}
