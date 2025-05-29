package com.MySandwichShop.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Topping {
    Scanner scanner = new Scanner(System.in);
    private String name;
    private ToppingType type;
    private boolean extraMeat;
    private boolean extraCheese;
    private List<String> extraToppings = new ArrayList<>();

    public Topping(String name, ToppingType type) {
        this.name = name;
        this.type = type;
    }

    public Topping(Topping toppingName, ToppingType toppingType) {
    }

   public Sandwich toppings() {
       System.out.println("Add toppings (type 'done' to finish):");
       while (true) {
           System.out.print("Topping: ");
           String topping = scanner.nextLine().trim();
           if (topping.equalsIgnoreCase("done")) {
               addTopping(topping);

               System.out.print("Add extra " + topping + "? (yes/no): ");
               if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
                   this.extraToppings.add(topping);
               }
           }
       }
   }

    private void addTopping(String topping) {
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
