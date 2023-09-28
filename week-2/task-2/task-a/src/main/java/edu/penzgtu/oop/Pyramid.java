package edu.penzgtu.oop;

import java.util.Scanner;

public class Pyramid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the pyramid height ");
        String userInput = scanner.nextLine();

        if (!isValidInput(userInput)) {
            System.err.println("Wrong input format");
            return;
        }

        int pyramidHeight = Integer.parseInt(userInput);
        String result = pyramidBuilder(pyramidHeight, "#");

        System.out.println(result);

        scanner.close();
    }

    public static String pyramidBuilder(int height, String symbol) {
        String result = "";
        String symbolsLine = symbol;

        for (int i = 1; i <= height; i++) {
            for (int j = height - i; j > 0; j--) {
                result += " ";
            }

            result += symbolsLine + "  " + symbolsLine + "\n";
            symbolsLine += "#";
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
