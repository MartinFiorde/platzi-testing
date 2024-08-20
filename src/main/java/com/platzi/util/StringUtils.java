package com.platzi.util;

public class StringUtils {

    public static String repeat(String text, int count) {
        StringBuilder fullText = new StringBuilder();
        for (int i = 0; i < count; i++) {
            fullText.append(text);
        }
        return fullText.toString();
    }
}
