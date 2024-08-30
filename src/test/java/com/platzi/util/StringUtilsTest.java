package com.platzi.util;

class StringUtilsTest {

    public static void main(String[] args) {

        String result1 = StringUtils.repeat("hola",3);
        if (!"holaholahola".equals(result1)) System.out.println("ERROR1"); // si falla, no tenemos información extra

        String result2 = StringUtils.repeat("mundo",2);
        if (!"mundomundo".equals(result2)) System.out.println("ERROR2");
    }
}