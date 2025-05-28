package com.MySandwichShop.Models;

public class Drink extends Product{
    public Drink(String size, double price){
        double price;
        String display = switch (size.toLowerCase()) {
            case "small" -> {
                price = 2.00;
                yield "Small Drink";
            }
            case "medium" -> {
                price = 2.50;
                yield "Medium Drink";
            }
            case "large" -> {
                price = 3.00;
                yield "Large Drink";
            }
            default -> {
                price = 2.50;
                yield "Default Drink";
            }
        };

        setDisplayName(display);
        setPrice(price);
    }

    @Override
    public int getName() {
        return 0;
    }
}
