package com.alcloud.dietaryjournal.controller;

import com.alcloud.dietaryjournal.model.Food;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * The FoodService class implements CRUD operations for food items
 *
 * @author Aleksei Piatkin
 * @version 1.0
 * @since 2020-01-19
 */

class FoodService {

    private final Logger logger = LoggerFactory.getLogger(FoodService.class);

    // Database replacement. For test purposes only!
    private Map<Long, Food> foods = new HashMap<>();

    /**
     * @param id - food id
     * @return the food item by food id
     */
    Food getFoodById(long id) {
        return foods.get(id);
    }

    /**
     * @param userId   - user id
     * @param dateLow  - date begin
     * @param dateHigh - end date
     * @return list of the sorted by date food items
     */
    List<Food> getAllFood(String userId, Date dateLow, Date dateHigh) {
        List<Food> sortedByDateFood = new ArrayList<>();
        for (Food food : foods.values()) {

            // Check if the request matches the specified time period and user.
            if (food.getUserId() != null && dateLow != null && dateHigh != null) {
                if (food.getUserId().equals(userId) &&
                        food.getDate().compareTo(dateLow) > 0 &&
                        food.getDate().compareTo(dateHigh) < 0) {
                    sortedByDateFood.add(food);
                }
            }
        }
        logger.debug("Sorted food for user " + userId + ": " + sortedByDateFood.toString());
        return sortedByDateFood;
    }

    /**
     * @param food - food item
     * @return id of added food item
     */
    Long addFood(Food food) throws IllegalArgumentException {

        // Check if amount is negative
        if (food.getPortion() < 0 || food.getWeight() < 0) {
            throw new IllegalArgumentException("The amount must be positive");
        }

        long id = (foods.size() + 1);
        food.setId(id);

        foods.put(food.getId(), food);
        return id;
    }

    /**
     * @param id - food id
     * @return deleted food item
     */
    Food removeFood(long id) {
        return foods.remove(id);
    }
}
