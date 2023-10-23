package edu.penzgtu.oop;

public class FibonacciClassic {
    public long calculate(int number) {
        if (number == 0 || number == 1) {
            return number;
        }

        return calculate(number - 2) + calculate(number - 1);
    }
}
