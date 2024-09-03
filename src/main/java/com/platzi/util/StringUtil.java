package com.platzi.util;

public class StringUtil {

    public static String repeat(String text, int count) {
        if (count < 0) throw new IllegalArgumentException("Negative count not allowed");
        StringBuilder fullText = new StringBuilder();
        for (int i = 0; i < count; i++) {
            fullText.append(text);
        }
        return fullText.toString();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
