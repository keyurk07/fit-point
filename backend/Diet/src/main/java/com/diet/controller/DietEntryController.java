package com.diet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diet.entities.DietEntry;
import com.diet.services.DietEntryService;

@RestController
@RequestMapping("/api/diet")
public class DietEntryController {

    @Autowired
    private DietEntryService dietEntryService;

    @PostMapping("/calculate")
    public ResponseEntity<DietEntry> calculateDietEntry(@RequestBody DietEntry request) {
        DietEntry dietEntry = dietEntryService.calculateAndSaveDietEntry(request);
        return ResponseEntity.ok().body(dietEntry);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DietEntry>> getAllDietEntriesByUserId(@PathVariable long userId) {
        Optional<List<DietEntry>> dietEntries = dietEntryService.getAllDietEntriesByUserId(userId);
        return ResponseEntity.ok().body(dietEntries.get());
    }
}
