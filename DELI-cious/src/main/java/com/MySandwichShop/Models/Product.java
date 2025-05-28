package com.MySandwichShop.Models;

public abstract class Product implements MenuItem{
    private String displayName;
    private double price;

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
