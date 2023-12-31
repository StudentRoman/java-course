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
        int[] items = fillArray(arrayLength);

        if (items != null) {
            MergeSort mergeSort = new MergeSort();
            mergeSort.sortArray(items);

            double median = getArrayMedian(items);
            System.out.println(median);
        } else {
            System.err.println("Wrong input format");
        }

        scanner.close();
    }

    public static double getArrayMedian(int[] numbers) {
        int arrayLength = numbers.length;
        int median = arrayLength / 2;

        if (arrayLength % 2 == 0) {
            return (numbers[median] + numbers[median - 1]) / 2.0;
        } else {
            return numbers[median];
        }
    }

    private static int[] fillArray(int arrayLength) {
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
