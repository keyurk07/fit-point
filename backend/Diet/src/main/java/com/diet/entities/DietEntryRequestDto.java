package com.diet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//package com.diet.dto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DietEntryRequestDto {
    private String itemName;
    private long qty;
    private long userId;

    // Getters and Setters
}

