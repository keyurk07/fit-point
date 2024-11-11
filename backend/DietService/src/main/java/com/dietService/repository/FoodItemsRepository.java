package com.dietService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dietService.entities.FoodItems;

@Repository
public interface FoodItemsRepository extends JpaRepository<FoodItems,Long> {
	Optional<FoodItems> findByItemName(String itemName);

}
