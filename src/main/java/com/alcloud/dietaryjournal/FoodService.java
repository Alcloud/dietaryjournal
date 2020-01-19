package com.alcloud.dietaryjournal;

import com.alcloud.dietaryjournal.model.Food;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodService {

    private static FoodService ourInstance = new FoodService();

    public static FoodService getInstance(){
        return ourInstance;
    }

    private Map<Long, Food> foods = new HashMap<>();

    Food getFoodById(long id) {
        return foods.get(id);
    }

    List<Food> getAllFood(){
        return new ArrayList<>(foods.values());
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
