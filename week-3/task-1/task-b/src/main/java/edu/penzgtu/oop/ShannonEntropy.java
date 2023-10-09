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
        double[] charCounts = new double[256];

        for (int i = 0; i < str.length(); i++) {
            charCounts[str.charAt(i)]++;
        }

        double entropy = 0;

        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > 0) {
                double element = charCounts[i] / str.length();
                entropy -= element * Math.log(element) / Math.log(2);
            }
        }

        return entropy;
    }
}