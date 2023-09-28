package edu.penzgtu.oop;

import java.util.Scanner;

public class Heron {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number ");
        String userInput = scanner.nextLine();

        if (!isValidInput(userInput)) {
            System.err.println("Wrong input format");
            return;
        }

        int number = Integer.parseInt(userInput);
        double result = heronSqrt(number);

        if (result != -1) {
            System.out.printf("Result = %s", result);
        } else {
            System.out.println("Entered a number less than zero");
        }

        scanner.close();
    }

    public static double heronSqrt(int number) {
        if (number < 0) {
            return -1;
        }

        double result = number;
        int i = 0;

        while ((result * result > number) && (i < 100)) {
            result = ((result + number / result) / 2);
            i++;
        }

        return result;
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
