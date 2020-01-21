package com.alcloud.dietaryjournal.controller;

import com.alcloud.dietaryjournal.model.Food;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodServiceTest {

    private FoodService foodService = new FoodService();
    private Map<Long, Food> testFoods = foodService.foods;

    void setFoodList() {
        testFoods.clear();

        Food apple = new Food();
        Food egg = new Food();
        Food potato = new Food();

        apple.setId(1);
        apple.setName("apple");
        apple.setWeight(200);
        apple.setPortion(1);
        apple.setUserId("user1");
        apple.setCreated(new Date(1579598596064L));

        egg.setId(2);
        egg.setName("egg");
        egg.setWeight(50);
        egg.setPortion(1);
        egg.setUserId("user1");
        egg.setCreated(new Date(1579598718223L));

        potato.setId(3);
        potato.setName("potato");
        potato.setWeight(30);
        potato.setPortion(3);
        potato.setUserId("user1");
        potato.setCreated(new Date(1579599042409L));

        testFoods.put(1L, apple);
        testFoods.put(2L, egg);
        testFoods.put(3L, potato);
    }

    @Test
    void getFoodById() {
        setFoodList();
        final long inputFoodIdValue = 2;

        final long expectedId = inputFoodIdValue;
        final String expectedName = "egg";
        final int expectedWeight = 50;
        final int expectedPortion = 1;
        final String expectedUserId = "user1";

        final Food actualFoodItem = foodService.getFoodById(inputFoodIdValue);

        final long actualId = actualFoodItem.getId();
        final String actualName = actualFoodItem.getName();
        final int actualWeight = actualFoodItem.getWeight();
        final int actualPortion = actualFoodItem.getPortion();
        final String actualUserId = actualFoodItem.getUserId();

        assertEquals(expectedId, actualId, "IDs didn't match");
        assertEquals(expectedName, actualName, "Names didn't match");
        assertEquals(expectedWeight, actualWeight, "Weights didn't match");
        assertEquals(expectedPortion, actualPortion, "Portions didn't match");
        assertEquals(expectedUserId, actualUserId, "User IDs didn't match");
    }

    @Test
    void getAllFood() {
        setFoodList();

        final String inputUserId = "user1";
        final long inputStartDate = 1579598596064L;
        final long inputEndDate = 1579599003878L;

        final int expectedListSize = 2;
        final String expectedFirstFoodName = "apple";
        final String expectedSecondFoodName = "egg";

        final List<Food> actualFoodList = foodService.getAllFood(
                inputUserId,
                new Date(inputStartDate),
                new Date(inputEndDate));

        assertEquals(expectedListSize, actualFoodList.size(), "List size didn't match");
        assertEquals(expectedFirstFoodName, actualFoodList.get(0).getName(), "First food names didn't match");
        assertEquals(expectedSecondFoodName, actualFoodList.get(1).getName(), "Second food names didn't match");
    }

    @Test
    void addFood() {
        setFoodList();

        final Food inputFoodItem = new Food();

        inputFoodItem.setName("pineapple");
        inputFoodItem.setWeight(60);
        inputFoodItem.setPortion(2);
        inputFoodItem.setUserId("user1");

        final int expectedListSize = 4;
        final long expectedFoodId = 4;

        final long actualFoodId = foodService.addFood(inputFoodItem);

        assertEquals(expectedListSize, testFoods.size(), "Food list size didn't match");
        assertEquals(expectedFoodId, actualFoodId, "Food IDs didn't match");
    }

    @Test
    void removeFood() {
        setFoodList();

        final long inputFoodIdValue = 2;

        final long expectedId = inputFoodIdValue;
        final int expectedListSize = 2;
        final String expectedRemovedFoodName = "egg";

        final Food actualRemovedFoodItem = foodService.removeFood(inputFoodIdValue);

        assertEquals(expectedListSize, testFoods.size(), "List sizes didn't match");
        assertEquals(expectedId, actualRemovedFoodItem.getId(), "Food IDs didn't match");
        assertEquals(expectedRemovedFoodName, actualRemovedFoodItem.getName(), "Food names didn't match");
    }
}