package edu.penzgtu.oop;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
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

        MergeSort mergeSort = new MergeSort();

        if (items != null) {
            System.out.printf("Array before sorting - %s \n", Arrays.toString(items));
            mergeSort.sortArray(items);
            System.out.printf("Array after sorting - %s", Arrays.toString(items));
        } else {
            System.err.println("Wrong input format");
        }

        scanner.close();
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
