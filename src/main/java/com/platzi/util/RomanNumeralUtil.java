package com.platzi.util;

public class RomanNumeralUtil {

    private RomanNumeralUtil() {
    }

    private static final String[] romanNumber = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] arabicValues = {
            1000, 900, 500,  400, 100,   90,  50,   40,  10,    9,   5,    4,   1};

    /**
     * @param n the Arabic number to convert (1 <= n <= 3999)
     * @return the Roman numeral as a String
     * @throws IllegalArgumentException if the number is outside the valid range
     */
    public static String arabicToRoman(int n) {
        validateArabicNumber(n);

        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (arabicValues[index] <= n) {
                sb.append(romanNumber[index]);
                n -= arabicValues[index];
            } else {
                index += 1;
            }
        }
        return sb.toString();
    }

    private static void validateArabicNumber(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Number must be positive and greater than zero.");
        }
        if (n > 3999) {
            throw new IllegalArgumentException("Number must be less than or equal to 3999.");
        }
    }
}
