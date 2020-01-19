package com.alcloud.dietaryjournal.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Food {

    private long id;
    private String name;
    private String userId;
    private int portion;
    private int weight;
    private Date created = new Date();

    public Food() {

    }

    /**
     * @return the food id
     */
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public int getPortion() {
        return portion;
    }

    public int getWeight() {
        return weight;
    }

    public Date getDate() {
        return created;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
