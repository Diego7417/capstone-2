package com.MySandwichShop.Models;

public class Topping {
    private String name;
    private ToppingType type;

    public Topping(String name, ToppingType type) {
        this.name = name;
        this.type = type;
    }

    double getPrice(Size size){
        return switch (type) {
            case Meat -> switch (size) {
                case FOUR -> 1.00;
                case EIGHT -> 2.00;
                default -> 3.00;
            };
            case Cheese -> switch (size) {
                case FOUR -> 0.75;
                case EIGHT -> 1.50;
                default -> 2.50;
            };
            default -> 0.0;
        };
    }

    @Override
    public String toString() {
        return "Topping{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
