package com.MySandwichShop.Models;

public enum Size {
    FOUR,
    EIGHT,
    TWELVE;

    public double getBreadPrice() {
        switch (this) {
            case FOUR:
                return 5.50;
            case EIGHT:
                return 7.00;
            case TWELVE:
                return 8.50;
            default:
                return 0.0;
        }
    }

    public double getMeatPrice() {
        switch (this) {
            case FOUR:
                return 1.00;
            case EIGHT:
                return 2.00;
            case TWELVE:
                return 3.00;
            default:
                return 0.0;
        }
    }

    public double getExtraMeatPrice() {
        switch (this) {
            case FOUR:
                return 0.50;
            case EIGHT:
                return 1.00;
            case TWELVE:
                return 1.50;
            default:
                return 0.0;
        }
    }

    public double getCheesePrice() {
        switch (this) {
            case FOUR:
                return 0.75;
            case EIGHT:
                return 1.50;
            case TWELVE:
                return 2.25;
            default:
                return 0.0;
        }
    }

    public double getExtraCheesePrice() {
        switch (this) {
            case FOUR:
                return 0.30;
            case EIGHT:
                return 0.60;
            case TWELVE:
                return 0.90;
            default:
                return 0.0;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case FOUR:
                return "4 inch";
            case EIGHT:
                return "8 inch";
            case TWELVE:
                return "12 inch";
            default:
                return "Unknown size";
        }
    }
}
