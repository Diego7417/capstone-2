package com.MySandwichShop.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SandwichBuilder {
    private String bread;
    private String meat;
    private List<String> toppings  = new ArrayList<>();
    private boolean toasted;
    private boolean hasCheese;
    private String condiment;

    public SandwichBuilder setBread(String bread) {
        this.bread = bread;
        return this;
    }

    public SandwichBuilder setMeat(String meat) {
        this.meat = meat;
        return this;
    }

    public SandwichBuilder addTopping(String topping) {
        this.toppings.add(topping);
        return this;
    }

    public SandwichBuilder setToasted(boolean toasted) {
        this.toasted = toasted;
        return this;
    }

    public SandwichBuilder setHasCheese(boolean hasCheese) {
        this.hasCheese = hasCheese;
        return this;
    }

    public SandwichBuilder setCondiment(String condiment) {
        this.condiment = condiment;
        return this;
    }

    public Sandwich build() {
        return new Sandwich(bread, meat, toppings, toasted, hasCheese, condiment);
    }

    public Sandwich buildFromInput(Scanner scanner) {
        System.out.print("Choose bread (White/Wheat/Rye/Wrap): ");
        String breadInput = scanner.nextLine().trim();
        if (breadInput.isEmpty()) breadInput = "White";
        setBread(breadInput);

        System.out.print("Choose meat (Steak/Ham/Salami/Roast beef/Chicken/Bacon/None): ");
        String meatInput = scanner.nextLine().trim();
        if (meatInput.isEmpty()) meatInput = "None";
        setMeat(meatInput);



        System.out.println("Toasted (yes/no)");
        setToasted(scanner.nextLine().trim().equalsIgnoreCase("yes"));

        System.out.print("Add cheese? (yes/no): ");
        setHasCheese(scanner.nextLine().trim().equalsIgnoreCase("yes"));

        System.out.print("Choose condiment (Mayo/Mustard/Ranch/Thousand Islands/Vinaigrette/Au jus/None): ");
        String condimentInput = scanner.nextLine().trim();
        if (condimentInput.isEmpty()) condimentInput = "None";
        setCondiment(condimentInput);

        System.out.println("Sandwich built successfully!");
        return build();

    }

    public Sandwich toppings(Scanner scanner) {
        System.out.println("Add toppings (type 'done' to finish):");
        while (true) {
            System.out.print("Topping: ");
            String topping = scanner.nextLine().trim();
            if (topping.equalsIgnoreCase("done")) break;
            if (!topping.isEmpty()) addTopping(topping);
        }
        return this.build();
    }
}
