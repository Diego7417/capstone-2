package com.MySandwichShop.Models;



public class Checkout {

    private Order order;

    public Checkout(Order order){
        this.order = order;
    }
    public void processPayment(){
        double total = order.getTotalPrice();
        System.out.println("Your total is $" + String.format("%.2f", total));
        System.out.println("Processing payment please wait...");
        System.out.println("Payment successful! Thank you for your order :)");
    }
    public void printReceipt(){
        ReceiptWriter receiptWriter = new ReceiptWriter();
        receiptWriter.writerReceipt(order);
    }
}
