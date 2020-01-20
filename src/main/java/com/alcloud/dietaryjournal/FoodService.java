package com.alcloud.dietaryjournal;

import com.alcloud.dietaryjournal.model.Food;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

class FoodService {

    private final Logger logger = LoggerFactory.getLogger(FoodService.class);

    private Map<Long, Food> foods = new HashMap<>();

    Food getFoodById(long id) {
        return foods.get(id);
    }

    List<Food> getAllFood(String userId, Date dateLow, Date dateHigh){
        List<Food> sortedByDateFood = new ArrayList<>();
        for (Food food: foods.values()){
            if(food.getUserId().equals(userId) &&
                    food.getDate().compareTo(dateLow) > 0 &&
                    food.getDate().compareTo(dateHigh) < 0){
                sortedByDateFood.add(food);
            }
        }
        return sortedByDateFood;
    }

    Long addFood(Food food){
        long id = (foods.size() + 1);
        food.setId(id);
        if (food.getPortion() < 0){
            food.setPortion(0);
            logger.warn("The portion must be positive");
        }
        if (food.getWeight() < 0){
            food.setWeight(0);
            logger.warn("The weight must be positive");
        }
        foods.put(food.getId(), food);
        return id;
    }

    Food removeFood(long id){
        return foods.remove(id);
    }
}
