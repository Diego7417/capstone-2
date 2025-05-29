package com.MySandwichShop.Models;

public class Chips extends Product{
    public Chips(String type, double v){
        setDisplayName(type + "Chips");
        setPrice(1.50);
    }
}
