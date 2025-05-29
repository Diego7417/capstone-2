package com.MySandwichShop.Models;

public class Drink extends Product{
    public Drink(String size){
        double price;
        String display;
        switch (size.toLowerCase()) {
            case "small":
                price = 2.00;
                display = "Small Drink";
                break;
            case "medium":
                price = 2.50;
                display = "Medium Drink";
                break;
            case "large":
                price = 3.00;
                display = "Large Drink";
                break;
            default:
                price = 2.50;
                display = "Default Drink";
                break;
        }

        setDisplayName(display);
        setPrice(price);
    }
}
