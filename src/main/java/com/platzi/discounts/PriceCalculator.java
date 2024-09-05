package com.platzi.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    List<Double> prices;
    private double discount;

    public PriceCalculator() {
        this.prices = new ArrayList<>();
        this.discount = 0;
    }

    public double getTotal() {
        double total = 0;
        for (Double price : prices) {
            total += price;
        }
        return total*(1-discount);
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(int discountAsInt) {
        if (discountAsInt < 0 || discountAsInt >= 100) throw new IllegalArgumentException("discount must be between 0 and 100");
        this.discount = ((double) discountAsInt)/100;
    }
}
