package com.MySandwichShop.Models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product{
    private Size size;
    private Bread bread;
    private List<Topping> toppings = new ArrayList<>();
    private boolean toasted;
    private String meat;
    private boolean hasCheese;
    private String condiment;


    public Sandwich(Size size, Bread bread, List<Topping> toppings, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toppings = toppings;
        this.toasted = toasted;
    }

    public Size getSize(){
        return size;
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
    }
    public void setToasted(boolean toasted){
        this.toasted = toasted;
    }

    @Override
    public double getPrice() {
      double base = switch (size) {
          case FOUR -> 5.50;
          case EIGHT -> 7.00;
          case TWELVE -> 8.50;
      };
        double toppingCost = toppings.stream().mapToDouble(t -> t.getPrice(size)).sum();
        double price = base + toppingCost;
        setDisplayName(size + "″ " + bread + " Sandwich" + (toasted ? " (toasted)" : ""));
        return price;
    }



    @Override
    public String toString() {
        return getDisplayName() + " | toppings: " + toppings;
    }
}
