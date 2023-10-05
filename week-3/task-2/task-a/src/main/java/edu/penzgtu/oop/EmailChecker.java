package edu.penzgtu.oop;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email address ");
        String userInput = scanner.nextLine();

        boolean result = isValidEmail(userInput);

        if (result) {
            System.out.println("The correct email address is entered");
        } else {
            System.out.println("Invalid email address entered");
        }

        scanner.close();
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^((([0-9A-Fa-f]{1,4}:){1,6}:)|(([0-9A-Fa-f]{1,4}:){7}))([0-9A-Fa-f]{1,4})$\n";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher matcher = emailPattern.matcher(email);

        return matcher.matches();
    }
}
