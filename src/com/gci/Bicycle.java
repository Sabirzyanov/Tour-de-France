package com.gci;

public class Bicycle {
    private String modelName;
    private double maxSpeed;
    private int price;

    public Bicycle(String modelName, double maxSpeed, int price) {
        this.modelName = modelName;
        this.maxSpeed = maxSpeed;
        this.price = price;
    }

    public String getModelName() {
        return modelName;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
