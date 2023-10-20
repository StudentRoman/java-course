package edu.penzgtu.oop;

import java.util.HashMap;

public class Fibonacci {
    static HashMap<Integer, Long> cache = new HashMap<>();

    public long fibonacciClassic(int number) {
        if (number == 0 || number == 1) {
            return number;
        }

        return fibonacciClassic(number - 2) + fibonacciClassic(number - 1);
    }

    private static Long cacheValue(int number) {
        if (!cache.containsKey(number)) {
            cache.put(number, fibonacciWithMemoization(number));
        }

        return cache.get(number);
    }

    public static long fibonacciWithMemoization(int number) {
        if (number == 0 || number == 1) {
            return number;
        }

        return cacheValue(number - 2) + cacheValue(number - 1);
    }
}
