package com.MySandwichShop.Models;

import java.util.Scanner;

public class HomeScreen {

    public void display(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            System.out.println("=== Welcome to DELI-cious ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println("Please select an option :) :");
            String input = scanner.nextLine();

            switch (input){
                case "1":
                    OrderScreen orderScreen = new OrderScreen();
                    orderScreen.display();
                    break;
                case "0":
                    System.out.println("Thank you very much for visiting DELI-icous!");
                    scanner.close();
                    running = false;
                    break;
                default:
                    System.out.println("Not a valid option. Please try again");

            }
        }
    }
}
