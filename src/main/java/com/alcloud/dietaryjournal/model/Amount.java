package com.alcloud.dietaryjournal.model;

public class Amount {

    private int portion;
    private int weight;

    public Amount(final int portion, final int weight) {
        this.portion = portion;
        this.weight = weight;
    }

    public int getPortion() {
        return portion;
    }

    public int getWeight() {
        return weight;
    }
}

