package edu.penzgtu.oop;

import java.time.Duration;
import java.time.Instant;

public class Application {
    public static final int NUMBER = 40;

    public static void main(String[] args) {
        FibonacciClassic fibonacciClassic = new FibonacciClassic();
        Instant startClassicFibonacci = Instant.now();

        fibonacciClassic.calculate(NUMBER);

        long timeClassicFibonacci = Duration.between(startClassicFibonacci, Instant.now()).toNanos();
        System.out.printf("Классическая реализация: %s%n", timeClassicFibonacci);

        FibonacciCache fibonacciCache = new FibonacciCache();
        Instant startCachedFibonacci = Instant.now();

        fibonacciCache.calculate(NUMBER);

        long timeCachedFibonacci = Duration.between(startCachedFibonacci, Instant.now()).toNanos();
        System.out.printf("Реализация с помощью кэша: %s%n", timeCachedFibonacci);
    }
}