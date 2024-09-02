package com.platzi.util;

public class StringUtils {

    public static String repeat(String text, int count) {
        if (count < 0) throw new IllegalArgumentException("Negative count not allowed");
        StringBuilder fullText = new StringBuilder();
        for (int i = 0; i <= count; i++) { // i < count para que el test pase
            fullText.append(text);
        }
        return fullText.toString();
    }
}
