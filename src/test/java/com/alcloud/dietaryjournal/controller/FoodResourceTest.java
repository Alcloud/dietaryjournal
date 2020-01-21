package com.alcloud.dietaryjournal.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

@QuarkusTest
class FoodResourceTest {

    @Test
    public void testAdd() {
        given()
                .body("{\n" +
                        "        \"date\": \"2020-01-21T12:58:49.249Z[UTC]\",\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"apple\",\n" +
                        "        \"portion\": 2,\n" +
                        "        \"userId\": \"4\",\n" +
                        "        \"weight\": 300\n" +
                        "    }")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/foods")
                .then()
                .statusCode(200);
    }


    @Test
    public void testList() {
        given()
                .when().get("/foods/4")
                .then()
                .statusCode(204);
    }
}