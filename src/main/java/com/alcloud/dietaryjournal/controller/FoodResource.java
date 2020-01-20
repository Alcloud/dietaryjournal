package com.alcloud.dietaryjournal.controller;

import com.alcloud.dietaryjournal.model.Food;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

/**
 * The FoodResource class describes API for the frontend
 *
 * @author  Aleksei Piatkin
 * @version 1.0
 * @since   2020-01-19
 */

@Path("/foods")
public class FoodResource {

    private FoodService foodService = new FoodService();

    @GET
    @Path("/{foodId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Food getFood(@PathParam("foodId") long foodId) {
        return foodService.getFoodById(foodId);
    }

    @GET
    @Path("/{userId}/{datelow}/{datehigh}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Food> getAllFood(@PathParam("userId") String userId,
                                 @PathParam("datelow") long datelow,
                                 @PathParam("datehigh") long datehigh) {
        return foodService.getAllFood(userId, new Date(datelow), new Date(datehigh));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Long addFood(Food food) {
        return foodService.addFood(food);
    }

    @DELETE
    @Path("/{foodId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Food removeFood(@PathParam("foodId") long foodId) {
        return foodService.removeFood(foodId);
    }
}