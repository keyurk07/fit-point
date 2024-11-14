package com.diet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diet.entities.DietEntry;

public interface DietEntryRepository extends JpaRepository<DietEntry, Long> {
	List<DietEntry> findByUserId(long userId);
}
