package edu.penzgtu.oop;

import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер месяца ");
        String userInputMonth = scanner.nextLine();
        System.out.print("Введите год ");
        String userInputYear = scanner.nextLine();

        if (!isValidInput(userInputYear) | !isValidInput(userInputMonth)) {
            System.err.println("Wrong input format");
            return;
        }

        int month = Integer.parseInt(userInputMonth);
        int year = Integer.parseInt(userInputYear);

        if (year > 0 && month >= 1 && month <= 12) {
            int daysInMonth = getDaysInMonth(month, year);
            System.out.printf("Количество дней %d", daysInMonth);
        } else {
            System.err.println("Указан неверный год или месяц");
            return;
        }

        scanner.close();
    }

    public static int getDaysInMonth(int month, int year) {
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            return year % 4 == 0 ? 29 : 28;
        } else {
            return 31;
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
