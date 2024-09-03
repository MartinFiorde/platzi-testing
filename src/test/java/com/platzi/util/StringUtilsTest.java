package com.platzi.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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


    @Test
    void string_not_empty() {
        assertFalse(StringUtils.isEmpty("random String"));
    }

    @Test
    void string_is_empty() {
        assertTrue(StringUtils.isEmpty(""));
    }

    @Test
    void null_is_empty() {
        assertTrue(StringUtils.isEmpty(null));
    }

    @Test
    void whitespace_is_empty() {
        assertTrue(StringUtils.isEmpty("    "));
    }
}