package com.platzi.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class FizzBuzzUtil {

    private FizzBuzzUtil() {
    }

    public static String fizzBuzzItem(int n) {
        StringBuilder result = new StringBuilder();
        if (n % 3 == 0) result.append("Fizz");
        if (n % 5 == 0) result.append("Buzz");
        if (result.toString().isEmpty()) result.append(n);
        return result.toString();
    }

    /**
     * @param n The upper bound of the range 1 (inclusive) to n (inclusive). Must be greater than 0.
     * @return A List of Strings containing the FizzBuzz results for each number in the range.
     */
    public static List<String> fizzBuzzRange(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) return result;
        for (int i = 1; i < n + 1; i++) {
            result.add(fizzBuzzItem(i));
        }
        return result;
    }

    public static String fizzBuzzAsString(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int value : array) {
            result.append(fizzBuzzItem(value));
        }
        return result.toString();
    }

    public static String fizzBuzzAsString(List<Integer> list) {
        int[] intArray = list.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();
        return fizzBuzzAsString(intArray);
    }

    public static List<String> fizzBuzzAsList(List<Integer> list) {
        List<String> result = new ArrayList<>();
        for (int value : list) {
            result.add(fizzBuzzItem(value));
        }
        return result;
    }

    public static List<String> fizzBuzzAsList(int[] values) {
        return fizzBuzzAsList(IntStream.of(values).boxed().toList());
    }
}
