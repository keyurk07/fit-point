package com.user.exerciseClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "FoodItemsClient", url = "http://localhost:9003/api/food")
public interface FoodItemsClient {

}
