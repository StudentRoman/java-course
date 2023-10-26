package edu.penzgtu.oop;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку: ");
        String userInput = scanner.nextLine();

        var result = maxOccurrenceChar(userInput);
        System.out.printf("[%s, %d]", result.getKey(), result.getValue());

        scanner.close();
    }

    public static Map.Entry<Character, Long> maxOccurrenceChar(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();
    }
}