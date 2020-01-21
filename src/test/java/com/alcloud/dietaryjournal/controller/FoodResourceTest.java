package com.alcloud.dietaryjournal.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

@QuarkusTest
class FoodResourceTest {

    @Test
    void testGetFood() {
        given()
          .when().get("/1")
          .then()
             .statusCode(200);
    }
}