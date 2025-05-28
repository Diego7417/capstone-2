package com.MySandwichShop.Models;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptWriter {
    public void writerReceipt(Order order){
        try {
            FileWriter writer = new FileWriter("receipt.txt");

            writer.write("===== RECEIPT =====\n");
            for (MenuItem item : order.getItems()) {
                writer.write(item.getName() + " - $" + String.format("%.2f", item.getPrice()) + "\n");
            }
            writer.write("--------------------\n");
            writer.write("Total: $" + String.format("%.2f", order.getTotal()) + "\n");

            writer.close();
            System.out.println("Receipt saved to receipt.txt");
        } catch (IOException e) {
            System.out.println("Failed to save receipt: " + e.getMessage());
        }
    }
}
