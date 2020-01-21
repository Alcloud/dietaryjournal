package com.alcloud.dietaryjournal.controller;

import com.alcloud.dietaryjournal.controller.FoodResourceTest;
import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeFoodResourceIT extends FoodResourceTest {

    // Execute the same tests but in native mode.
}