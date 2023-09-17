package edu.penzgtu.oop;

import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");

        String username = scanner.nextLine();
        System.out.printf("Hello, %s", username);

        scanner.close();
    }
}