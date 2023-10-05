package edu.penzgtu.oop;

import java.util.Scanner;

public class ShannonEntropy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку ");
        String userInput = scanner.nextLine();

        System.out.printf("Энтропия строки %.2f", calculateEntropy(userInput));

        scanner.close();
    }

    public static double calculateEntropy(String str) {
        char[] chars = str.toCharArray();
        double[] charCounts = new double[256];

        for (char element : chars) {
            charCounts[element]++;
        }

        double totalCount = 0.0;

        for (double element : charCounts) {
            totalCount += element;
        }

        for (int i = 0; i < charCounts.length; i++) {
            charCounts[i] = charCounts[i] / totalCount;
        }

        double entropy = 0;

        for (double element : charCounts) {
            if (element > 0) {
                entropy -= element * (Math.log(element) / Math.log(2));
            }
        }

        return entropy;
    }
}