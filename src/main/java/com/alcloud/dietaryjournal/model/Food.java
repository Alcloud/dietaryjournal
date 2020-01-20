package com.alcloud.dietaryjournal.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * The Food class represent a model for a food item
 *
 * @author  Aleksei Piatkin
 * @version 1.0
 * @since   2020-01-19
 */

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

    /**
     * @return the food name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @return the portion
     */
    public int getPortion() {
        return portion;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @return the date of creation
     */
    public Date getDate() {
        return created;
    }

    /**
     * Set the
     * @param id - food id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Set the
     * @param portion - portion
     */
    public void setPortion(int portion) {
        this.portion = portion;
    }

    /**
     * Set the
     * @param weight - weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
