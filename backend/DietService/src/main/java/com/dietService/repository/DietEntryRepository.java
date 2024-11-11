package com.dietService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dietService.entities.DietEntry;

@Repository
public interface DietEntryRepository extends JpaRepository<DietEntry, Long>{
//	Optional<DietEntry> findByItemName(String itemName);
}
