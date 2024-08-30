package com.platzi.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilsTest {

    public static void main(String[] args) {

        String result1 = StringUtils.repeat("hola",3);
        String expected1 = "holaholahola";
        //assertEquals1(result1, expected1);// assert manual

        String result2 = StringUtils.repeat("mundo",2);
        String expected2 = "mundomundo";
        assertEquals(result2, expected2);
    }

    private static void assertEquals1(String result1, String expected1) {
        if (!result1.equals(expected1)) throw new RuntimeException(result1 + " is not equal to " + expected1);
    }
}