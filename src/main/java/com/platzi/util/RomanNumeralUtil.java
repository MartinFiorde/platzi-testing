package com.platzi.util;

public class RomanNumeralUtil {

    private RomanNumeralUtil() {
    }

    private static final String[] romanNumber = {
            "M",    //1000
            "CM",   // 900
            "D",    // 500
            "CD",   // 400
            "C",    // 100
            "XC",   //  90
            "L",    //  50
            "XL",   //  40
            "X",    //  10
            "IX",   //   9
            "V",    //   5
            "IV",   //   4
            "I"};   //   1

    private static final int[] arabicValues = {
            1000,   // M
            900,    // CM
            500,    // D
            400,    // CD
            100,    // C > M
            90,     // XC
            50,     // L > D
            40,     // XL
            10,     // X > C
            9,      // IX
            5,      // V > L
            4,      // IV
            1};     // I > X


    public static String arabicToRoman(int n) {
        if (n < 0) return "-0";
        if (n == 0) return "0";
        if (n > 3999) return "M+";
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
}
