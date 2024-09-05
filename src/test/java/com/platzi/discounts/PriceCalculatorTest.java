package com.platzi.discounts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceCalculatorTest {

    @Test
    void total_zero_when_no_prices() {
        PriceCalculator calc = new PriceCalculator();
        assertEquals(0.0, calc.getTotal());
    }

    @Test
    void total_is_sum_of_prices() {
        PriceCalculator calc = new PriceCalculator();
        calc.addPrice(10.2);
        calc.addPrice(15.5);
        assertEquals(25.71, calc.getTotal(), 0.011);
    }

    @Test
    void total_with_correct_discount() {
        PriceCalculator calc = new PriceCalculator();
        calc.addPrice(12.3);
        calc.addPrice(1.6);
        calc.addPrice(4.8);
        calc.addPrice(123.65);
        calc.addPrice(234.11);
        calc.addPrice(100);
        calc.setDiscount(25);
        assertEquals(357.35, calc.getTotal(), 0.011) ;
    }
}