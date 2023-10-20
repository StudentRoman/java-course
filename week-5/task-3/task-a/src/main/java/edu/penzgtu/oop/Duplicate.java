package edu.penzgtu.oop;

import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Duplicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите значения через пробел: ");
        String userInput = scanner.nextLine();

        ArrayList<String> inputArray = new ArrayList<>(Arrays.asList(userInput.split(" ")));
        HashSet<String> result = new HashSet<>(inputArray);

        System.out.printf("Входной массив: %s%n", inputArray);
        System.out.printf("Массив уникальных значений: %s", result);

        scanner.close();
    }
}