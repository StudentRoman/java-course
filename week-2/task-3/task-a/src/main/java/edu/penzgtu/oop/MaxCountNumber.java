package edu.penzgtu.oop;

import java.util.Scanner;

public class MaxCountNumber {

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
            int result = getCountMaxNumber(items);
            System.out.println(result);
        } else {
            System.err.println("Wrong input format");
        }

        scanner.close();
    }

    public static int getCountMaxNumber(int[] nums) {
        int arrayLength = nums.length;
        int maxNum = nums[0];
        int count = 1;

        for (int i = 1; i < arrayLength; i++) {
            if (nums[i] == maxNum) {
                count++;
            } else if (nums[i] > maxNum) {
                maxNum = nums[i];
                count = 1;
            }
        }

        return count;
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
