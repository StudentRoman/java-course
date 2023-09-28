package edu.penzgtu.oop;

import java.util.Scanner;
import java.util.Arrays;

public class MergeSort {
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
            System.out.printf("Array before sorting - %s \n", Arrays.toString(items));
            mergeSort(items);
            System.out.printf("Array after sorting - %s", Arrays.toString(items));
        } else {
            System.err.println("Wrong input format");
        }

        scanner.close();
    }

    private static void merge(int[] a, int[] leftArray, int[] rightArray, int left, int right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                a[k++] = leftArray[i++];
            } else {
                a[k++] = rightArray[j++];
            }
        }

        while (i < left) {
            a[k++] = leftArray[i++];
        }

        while (j < right) {
            a[k++] = rightArray[j++];
        }
    }

    public static void mergeSort(int[] array) {
        int arrayLength = array.length;

        if (arrayLength < 2) {
            return;
        }

        int mid = arrayLength / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[arrayLength - mid];

        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }

        for (int i = mid; i < arrayLength; i++) {
            rightArray[i - mid] = array[i];
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(array, leftArray, rightArray, mid, arrayLength - mid);
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
