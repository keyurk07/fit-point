package com.user.exerciseClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.entities.DietEntry;
import com.user.entities.DietEntryRequestDto;

@FeignClient(value="diet", url="http://localhost:9003/api/diet")
public interface DietEntryClient {
	
	@PostMapping("/calculate")
    public ResponseEntity<DietEntry> calculateDietEntry(@RequestBody DietEntry request);
	
	
    
}
