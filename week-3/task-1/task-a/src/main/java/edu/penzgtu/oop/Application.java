package edu.penzgtu.oop;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Что ищем: ");
        String substring = scanner.nextLine();

        if (substring.isEmpty()) {
            System.err.println("Введена пустая строка для поиска");
            return;
        }

        System.out.println("Где ищем (* или пустая строка для остановки ввода): ");
        String str = fillString();

        int result = searchSubstring(str, substring);

        System.out.println(result);
        scanner.close();
    }

    public static int searchSubstring(String str, String substring) {
        int count = 0;
        int lastIndex = 0;

        while ((lastIndex = str.indexOf(substring, lastIndex)) != -1) {
            lastIndex += substring.length() - 1;
            count++;
        }

        return count;
    }

    private static String fillString() {
        Scanner scanner = new Scanner(System.in);
        String str = "";

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("*") || line.isEmpty()) {
                break;
            }

            str += line + " ";
        }

        scanner.close();

        return str;
    }
}