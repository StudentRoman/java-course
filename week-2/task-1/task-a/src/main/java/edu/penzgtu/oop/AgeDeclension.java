package edu.penzgtu.oop;

import java.util.Scanner;

public class AgeDeclension {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите возраст ");
        String userInput = scanner.nextLine();

        if (!isValidInput(userInput)) {
            System.err.println("Wrong input format");
            return;
        }

        int age = Integer.parseInt(userInput);

        if (age > 0) {
            String ageDeclension = getAgeDeclension(age);

            System.out.printf("Ваш возраст - %d %s", age, ageDeclension);
        } else {
            System.out.println("Указан неверный возраст");
        }

        scanner.close();
    }

    public static String getAgeDeclension(int age) {
        int lastNumber = age % 10;
        int lastTwoNumbers = age % 100;

        if ((lastTwoNumbers >= 10 && lastTwoNumbers <= 20) | lastNumber > 4) {
            return "лет";
        } else if (lastNumber == 1) {
            return "год";
        } else {
            return "года";
        }
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
