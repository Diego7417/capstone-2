package com.MySandwichShop.Models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem menuItem) {
        items.add(menuItem);
    }

    public void clearItems() {
        items.add((MenuItem) items);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return 0;
    }

    public void printOrderDetails() {
    }

    public Object getTotal() {
    }
}