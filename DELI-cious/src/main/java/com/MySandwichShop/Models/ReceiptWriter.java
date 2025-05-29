package com.MySandwichShop.Models;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public void writerReceipt(Order order){
        try {
            String fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
            String filePath = "receipts/" + fileName;

            FileWriter writer = new FileWriter(filePath);

            writer.write("===== RECEIPT =====\n");
            for (MenuItem item : order.getItems()) {
                writer.write(item.getDisplayName()+ " - $" + String.format("%.2f", item.getPrice()) + "\n");
            }
            writer.write("--------------------\n");
            writer.write("Total: $" + String.format("%.2f", order.getTotalPrice()) + "\n");

            writer.close();
            System.out.println("Receipt saved to receipt.txt");
        } catch (IOException e) {
            System.out.println("Failed to save receipt: " + e.getMessage());
        }
    }
}
