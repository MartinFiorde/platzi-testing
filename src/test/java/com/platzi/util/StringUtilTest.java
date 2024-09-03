package com.platzi.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    void repeat_string_once() {
        assertEquals("mundo", StringUtil.repeat("mundo", 1));
    }

    @Test
    void repeat_string_multiple_times() {
        assertEquals("mundomundomundo", StringUtil.repeat("mundo", 3));
    }

    @Test
    void repeat_string_cero_times() {
        assertEquals("", StringUtil.repeat("mundo", 0));
    }

    @Test
    void repeat_string_negative_times() {
        assertThrows(IllegalArgumentException.class, () -> StringUtil.repeat("mundo", -1));
    }


    @Test
    void string_not_empty() {
        assertFalse(StringUtil.isEmpty("random String"));
    }

    @Test
    void string_is_empty() {
        assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    void null_is_empty() {
        assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    void whitespace_is_empty() {
        assertTrue(StringUtil.isEmpty("    "));
    }
}