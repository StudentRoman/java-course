package edu.penzgtu.oop;

import java.util.Scanner;
import java.util.Arrays;

public class EratosthenesSieve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the array size ");
        String userInput = scanner.nextLine();

        if (!isValidInput(userInput)) {
            System.err.println("Wrong input format");
            return;
        }

        int arrayLength = Integer.parseInt(userInput);
        boolean[] result = getEratosthenesSieve(arrayLength);
        
        System.out.printf("List of prime numbers from 2 to %d \n", arrayLength);
        for (int i = 2; i < result.length; i++) {
            if (result[i]) {
                System.out.println(i);
            }
        }

        scanner.close();
    }

    public static boolean[] getEratosthenesSieve(int sieveSize) {
        boolean[] sieve = new boolean[sieveSize + 1];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i * i <= sieveSize; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= sieveSize; j += i) {
                    sieve[j] = false;
                }
            }
        }

        return sieve;
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
