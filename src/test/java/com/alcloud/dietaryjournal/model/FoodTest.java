package com.alcloud.dietaryjournal.model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    @Test
    void setId() throws NoSuchFieldException, IllegalAccessException {

        final long inputFoodIdValue = 2L;

        final long expectedId = inputFoodIdValue;

        final Food food = new Food();
        food.setId(inputFoodIdValue);

        final Field field = food.getClass().getDeclaredField("id");
        field.setAccessible(true);

        assertEquals(expectedId, field.get(food), "Fields didn't match");
    }

    @Test
    void setName() throws NoSuchFieldException, IllegalAccessException {
        final String inputFoodNameValue = "apple";

        final String expectedName = inputFoodNameValue;

        final Food food = new Food();
        food.setName(inputFoodNameValue);

        final Field field = food.getClass().getDeclaredField("name");
        field.setAccessible(true);

        assertEquals(expectedName, field.get(food), "Fields didn't match");
    }

    @Test
    void getId() throws NoSuchFieldException, IllegalAccessException {
        final long inputIdValue = 3L;

        final long expectedId = inputIdValue;

        final Food food = new Food();
        final Field field = food.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(food, inputIdValue);

        final long actualId = food.getId();

        assertEquals(expectedId, actualId,"field wasn't retrieved properly");
    }

    @Test
    void getName() throws NoSuchFieldException, IllegalAccessException {
        final String inputFoodNameValue = "pineapple";

        final String expectedName = inputFoodNameValue;

        final Food food = new Food();
        final Field field = food.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(food, inputFoodNameValue);

        final String actualId = food.getName();

        assertEquals(expectedName, actualId,"field wasn't retrieved properly");
    }
}