package edu.penzgtu.oop;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter IPv6 ");
        String userInput = scanner.nextLine();

        boolean result = isValidIPv6(userInput);

        if (result) {
            System.out.println("The correct IPv6 is entered");
        } else {
            System.out.println("Invalid IPv6 entered");
        }

        scanner.close();
    }

    private static boolean isValidIPv6(String ip) {
        String IPv6Regex = "^((([0-9A-Fa-f]{1,4}:){1,6}:)|(([0-9A-Fa-f]{1,4}:){7}))([0-9A-Fa-f]{1,4})$";
        Pattern IPv6Pattern = Pattern.compile(IPv6Regex);
        Matcher matcher = IPv6Pattern.matcher(ip);

        return matcher.matches();
    }
}
