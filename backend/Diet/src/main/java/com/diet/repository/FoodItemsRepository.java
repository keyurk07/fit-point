package com.diet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.diet.entities.FoodItems;
import java.util.Optional;

public interface FoodItemsRepository extends JpaRepository<FoodItems, Long> {
    Optional<FoodItems> findByItemName(String itemName);
}
