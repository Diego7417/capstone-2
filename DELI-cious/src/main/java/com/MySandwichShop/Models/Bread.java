package com.MySandwichShop.Models;

public enum Bread {
    WHITE, WHEAT, RYE, WRAP;

    public static Bread fromString(String input) {
        return switch (input.toLowerCase()) {
            case "white" -> WHITE;
            case "wheat" -> WHEAT;
            case "rye" -> RYE;
            case "wrap" -> WRAP;
            default -> WHITE;
        };
    }
}
