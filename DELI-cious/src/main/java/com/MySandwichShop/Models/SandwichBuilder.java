package com.MySandwichShop.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SandwichBuilder {
    Scanner scanner = new Scanner(System.in);

    private Size size;
    private String bread;
    private String meat;
    private boolean extraMeat;
    private List<String> toppings = new ArrayList<>();
    private List<String> extraToppings = new ArrayList<>();
    private boolean toasted;
    private boolean hasCheese;
    private boolean extraCheese;
    private String condiment;

    public SandwichBuilder setSize(Size size) {
        this.size = size;
        return this;
    }

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
        List<Topping> toppingObjects = new ArrayList<>();
        for (String t : toppings) {
            toppingObjects.add(new Topping(t, ToppingType.Regular));
        }
        for (String t : extraToppings) {
            toppingObjects.add(new Topping("Extra " + t, ToppingType.Regular));
        }

        if (meat != null && !meat.equalsIgnoreCase("none")) {
            toppingObjects.add(new Topping(meat, ToppingType.Meat));
            if (extraMeat) {
                toppingObjects.add(new Topping("Extra " + meat, ToppingType.Meat));
            }

            if (hasCheese) {
                toppingObjects.add(new Topping("Cheese", ToppingType.Cheese));
                if (extraCheese) {
                    toppingObjects.add(new Topping("Extra Cheese", ToppingType.Cheese));
                }

                if (condiment != null && !condiment.equalsIgnoreCase("none")) {
                    toppingObjects.add(new Topping(condiment, ToppingType.Regular));
                }

                Bread breadEnum = Bread.valueOf(bread.toUpperCase());

                Sandwich sandwich = new Sandwich(size, breadEnum, toppingObjects, toasted);
                String displayName = size + " Sandwich on " + bread + (toasted ? " (Toasted)" : "");
                sandwich.setDisplayName(displayName);
                return sandwich;
            }
        }

        return null;
    }
    public Sandwich buildFromInput (Scanner scanner){
        System.out.print("Choose size (4/8/12 inch): ");
        String sizeInput = scanner.nextLine().trim();
        Size size;

        switch (sizeInput) {
            case "4" -> this.size = Size.FOUR;
            case "8" -> this.size = Size.EIGHT;
            case "12" -> this.size = Size.TWELVE;
            default -> {
                System.out.println("Invalid input. Defaulting to 8 inch.");
                this.size = Size.EIGHT;
            }
        }

        System.out.print("Choose bread (White/Wheat/Rye/Wrap): ");
        String breadInput = this.scanner.nextLine().trim();
        if (breadInput.isEmpty()) breadInput = "White";
        setBread(breadInput);

        System.out.print("Choose meat (Steak/Ham/Salami/Roast beef/Chicken/Bacon/None): ");
        String meatInput = this.scanner.nextLine().trim();
        if (meatInput.isEmpty()) meatInput = "None";
        setMeat(meatInput);

        System.out.print("Add extra meat? (yes/no): ");
        this.extraMeat = scanner.nextLine().trim().equalsIgnoreCase("yes");


        System.out.println("Toasted (yes/no)");
        setToasted(this.scanner.nextLine().trim().equalsIgnoreCase("yes"));

        System.out.print("Add cheese? (yes/no): ");
        setHasCheese(this.scanner.nextLine().trim().equalsIgnoreCase("yes"));


        System.out.print("Add extra cheese? (yes/no): ");
        this.extraCheese = scanner.nextLine().trim().equalsIgnoreCase("yes");

        System.out.print("Choose condiment (Mayo/Mustard/Ranch/Thousand Islands/Vinaigrette/Au jus/None): ");
        String condimentInput = this.scanner.nextLine().trim();
        if (condimentInput.isEmpty()) condimentInput = "None";
        setCondiment(condimentInput);

        System.out.println("Sandwich built successfully!");
        return build();

    }


    public Sandwich toppings (Scanner scanner) {
        System.out.println("Add toppings (type 'done' to finish):");
        while (true) {
            System.out.print("Topping: ");
            String topping = this.scanner.nextLine().trim();
            if (topping.equalsIgnoreCase("done")) break;
            if (!topping.isEmpty()) addTopping(topping);
        }
        return build();
    }
}