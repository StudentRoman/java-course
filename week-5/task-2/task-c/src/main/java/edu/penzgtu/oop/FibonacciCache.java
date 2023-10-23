package edu.penzgtu.oop;

import java.util.HashMap;

public class FibonacciCache {
    private static final HashMap<Integer, Long> cache = new HashMap<>();

    public static long calculate(int number) {
        if (number == 0 || number == 1) {
            return number;
        }

        return cacheHelper(number - 2) + cacheHelper(number - 1);
    }

    public static long cacheHelper(int number) {

        if (!cache.containsKey(number)) {
            cache.put(number, calculate(number));
        }

        return cache.get(number);
    }
}
