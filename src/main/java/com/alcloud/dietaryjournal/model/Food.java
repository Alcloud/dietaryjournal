package com.alcloud.dietaryjournal.model;

import java.util.Date;

public class Food {

    private String id;
    private String name;
    private String userId;
    private Amount amount;
    private Date addTime;

    public Food(String id, String name, String userId, Amount amount, Date addTime) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.amount = amount;
        this.addTime = addTime;
    }

    /**
     * @return the food id
     */
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public Amount getAmount() {
        return amount;
    }

    public Date getAddTime() {
        return addTime;
    }
}
