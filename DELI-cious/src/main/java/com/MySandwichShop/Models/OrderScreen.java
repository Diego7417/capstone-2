package com.MySandwichShop.Models;

import java.util.Scanner;

public class OrderScreen{

    private Order order = new Order();
    private final Scanner scanner = new Scanner(System.in);

    public void display() {
        boolean ordering = true;

        while (ordering){
            System.out.println("\n--- Order Menu ---");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.println("Choose an option");
            String input = scanner.nextLine();

            switch (input){
                case "1":
                    SandwichBuilder sandwichBuilder = new SandwichBuilder();
                    Sandwich sandwich =sandwichBuilder.buildFromInput(scanner);
                    order.addItem(sandwich);
                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addChips();
                    break;
                case "4":
                    order.printOrderDetails();
                    saveReceipt();
                    ordering = false;
                    break;
                case "0":
                    System.out.println("Order cancelled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }
    private void addDrink(){
        System.out.print("Enter drink size (small, medium, large): ");
        String size = scanner.nextLine().toLowerCase();
        String displayName = size + " drink";
        double price;

        switch (size) {
            case "small" -> price = 2.00;
            case "medium" -> price = 2.50;
            case "large" -> price = 3.00;
            default -> {
                System.out.println("Invalid size. Defaulting to medium.");
                displayName = "medium drink";
                price = 2.50;
            }
        }
        Drink drink = new Drink(displayName);
        order.addItem(drink);

    }
    private void addChips() {
        System.out.print("Enter chip type (BBQ, Sour Cream, Nacho Cheese, Cool Ranch): ");
        String type = scanner.nextLine();
        Chips chips = new Chips(type + " Chips", 1.50);
        order.addItem(chips);

    }
    private void saveReceipt() {
        ReceiptWriter receiptWriter = new ReceiptWriter();
        receiptWriter.writerReceipt(order);
    }
}
