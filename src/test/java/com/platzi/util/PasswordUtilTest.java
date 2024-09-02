package com.platzi.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.platzi.util.PasswordUtil.SecurityLevel.*;

class PasswordUtilTest {
    @Test
    void weak_when_has_less_than_8_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("abc456!"));
    }

    @Test
    void weak_when_has_only_numbers() {
        assertEquals(WEAK, PasswordUtil.assessPassword("12345678"));
    }

    @Test
    void weak_when_has_only_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("abcdefgh"));
    }

    @Test
    void medium_when_has_only_letters_and_numbers() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("1234efgh"));
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcd5678"));
        assertEquals(MEDIUM, PasswordUtil.assessPassword("ab3456gh"));
        assertEquals(MEDIUM, PasswordUtil.assessPassword("12cdef78"));
    }

    @Test
    void strong_when_has_letters_numbers_and_symbols() {
        assertEquals(STRONG, PasswordUtil.assessPassword("!bcd5678"));
        assertEquals(STRONG, PasswordUtil.assessPassword("abc4567!"));
        assertEquals(STRONG, PasswordUtil.assessPassword("abc!5678"));
    }
}