package com.alcloud.dietaryjournal;

import com.alcloud.dietaryjournal.model.Food;

import java.util.*;

public class FoodService {

    private static FoodService ourInstance = new FoodService();

    public static FoodService getInstance(){
        return ourInstance;
    }

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
        foods.put(food.getId(), food);
        return id;
    }

    Food removeFood(long id){
        return foods.remove(id);
    }
}
