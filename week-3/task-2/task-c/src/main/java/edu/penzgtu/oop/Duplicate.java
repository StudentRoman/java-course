package edu.penzgtu.oop;

import java.util.Scanner;

public class Duplicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string ");
        String userInput = scanner.nextLine();

        String result = replaceDuplicate(userInput);
        System.out.printf("New string -> %s", result);

        scanner.close();
    }

    public static String replaceDuplicate(String str) {
        return str.replaceAll("(.)\\1{2,}", "$1");
    }
}
