package edu.penzgtu.oop;

import java.util.Scanner;

public class NumbersMedian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the array length ");
        String userInput = scanner.nextLine();

        if (!isValidInput(userInput)) {
            System.err.println("Wrong input format");
            return;
        }

        int arrayLength = Integer.parseInt(userInput);

        System.out.println("Insert array elements:");
        int[] items = insertingElements(arrayLength);

        if (items != null) {
            double median = getArrayMedian(items);
            System.out.println(median);
        } else {
            System.err.println("Wrong input format");
        }

        scanner.close();
    }

    public static double getArrayMedian(int[] numbers) {
        int arrayLength = numbers.length;

        if (arrayLength % 2 == 0) {
            return (double) (numbers[arrayLength / 2] + numbers[arrayLength / 2 - 1]) / 2;
        } else {
            return numbers[arrayLength / 2];
        }
    }

    private static int[] insertingElements(int arrayLength) {
        int[] array = new int[arrayLength];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < arrayLength; i++) {
            String numberInput = scanner.nextLine();

            if (!isValidInput(numberInput)) {
                return null;
            }

            array[i] = Integer.parseInt(numberInput);
        }

        return array;
    }

    private static boolean isValidInput(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
