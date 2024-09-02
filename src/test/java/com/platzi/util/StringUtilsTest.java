package com.platzi.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringUtilsTest {

    @Test
    void repeat_string_once() {
        assertEquals("mundo", StringUtils.repeat("mundo", 1));
    }

    @Test
    void repeat_string_multiple_times() {
        assertEquals("mundomundomundo", StringUtils.repeat("mundo", 3));
    }

    @Test
    void repeat_string_cero_times() {
        assertEquals("", StringUtils.repeat("mundo", 0));
    }

    @Test
    void repeat_string_negative_times() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.repeat("mundo", -1));
    }
}