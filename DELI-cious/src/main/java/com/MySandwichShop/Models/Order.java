package com.MySandwichShop.Models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem menuItem) {
        items.add(menuItem);
    }

    public void clearItems() {
        items.clear();
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double total = 0;
        for (MenuItem item : items){
            total += item.getPrice();
        }
        return total;
    }

    public void printOrderDetails() {
        System.out.println("\n--- Order Details ---");
        for (MenuItem item : items){
            System.out.println("-" + item.getDisplayName() + ": $" + String.format("%.2f", item.getPrice()));
        }
        System.out.println("Total: $" + String.format("%.2f", getTotalPrice()));
    }

    public Object getTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}