package com.platzi.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzUtilTest {

    @Test
    void should_return_fizz_for_multiples_of_3() {
        assertEquals("Fizz", FizzBuzzUtil.fizzBuzzItem(3));
        assertEquals("Fizz", FizzBuzzUtil.fizzBuzzItem(6));
        assertEquals("Fizz", FizzBuzzUtil.fizzBuzzItem(9));
        assertEquals("Fizz", FizzBuzzUtil.fizzBuzzItem(303));
    }

    @Test
    void should_return_buzz_for_multiples_of_5() {
        assertEquals("Buzz", FizzBuzzUtil.fizzBuzzItem(5));
        assertEquals("Buzz", FizzBuzzUtil.fizzBuzzItem(10));
        assertEquals("Buzz", FizzBuzzUtil.fizzBuzzItem(20));
        assertEquals("Buzz", FizzBuzzUtil.fizzBuzzItem(500));
    }

    @Test
    void should_return_fizzBuzz_for_multiples_of_3_and_5() {
        assertEquals("FizzBuzz", FizzBuzzUtil.fizzBuzzItem(15));
        assertEquals("FizzBuzz", FizzBuzzUtil.fizzBuzzItem(30));
        assertEquals("FizzBuzz", FizzBuzzUtil.fizzBuzzItem(45));
        assertEquals("FizzBuzz", FizzBuzzUtil.fizzBuzzItem(300));
    }

    @Test
    void should_return_number_for_non_multiples_of_3_and_5() {
        assertEquals("1", FizzBuzzUtil.fizzBuzzItem(1));
        assertEquals("2", FizzBuzzUtil.fizzBuzzItem(2));
        assertEquals("4", FizzBuzzUtil.fizzBuzzItem(4));
        assertEquals("16", FizzBuzzUtil.fizzBuzzItem(16));
        assertEquals("299", FizzBuzzUtil.fizzBuzzItem(299));
    }

    @Test
    void should_return_correct_list_for_range() {
        List<String> expected = Arrays.asList("1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz".split(","));
        assertEquals(expected, FizzBuzzUtil.fizzBuzzRange(15));
    }

    @Test
    void should_return_correct_string_from_array() {
        String expected = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz".replace(",", "");
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        assertEquals(expected, FizzBuzzUtil.fizzBuzzAsString(input));
    }

    @Test
    void should_return_correct_string_from_list_with_nulls() {
        String expected = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz".replace(",", "");
        List<Integer> input = Arrays.asList(null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, null);
        assertEquals(expected, FizzBuzzUtil.fizzBuzzAsString(input));
    }

    @Test
    void should_return_correct_list_from_list() {
        List<String> expected = Arrays.asList("1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz".split(","));
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        assertEquals(expected, FizzBuzzUtil.fizzBuzzAsList(input));
    }

    @Test
    void should_return_correct_list_from_array() {
        List<String> expected = Arrays.asList("1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz".split(","));
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        assertEquals(expected, FizzBuzzUtil.fizzBuzzAsList(input));
    }
}
