package com.platzi.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilsTest {

    @Test
    void testRepeat() {
        String expected = "mundomundo";
        String result = StringUtils.repeat("mundo",2);
        assertEquals(expected, result);
    }
}