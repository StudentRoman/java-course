package edu.penzgtu.oop;

public class Application {
    public static final int ITERATIONS = 40;

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        long timeFibonacci = System.currentTimeMillis();

        for (int i = 0; i < ITERATIONS; i++) {
            fibonacci.fibonacciClassic(i);
        }

        System.out.print("Классическая реализация: ");
        System.out.println(System.currentTimeMillis() - timeFibonacci);

        long timeFibonacciCached = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            Fibonacci.fibonacciWithMemoization(i);
        }

        System.out.print("Реализация с помощью кэша: ");
        System.out.println(System.currentTimeMillis() - timeFibonacciCached);
    }
}