package edu.penzgtu.oop;

import java.util.Scanner;

public class DodecahedronVolume {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the edge length ");
        String userInput = scanner.nextLine();

        if (!isValidInput(userInput)) {
            System.err.println("Wrong input format");
            return;
        }

        int edge = Integer.parseInt(userInput);
        double volume = ((15 + 7 * Math.sqrt(5)) * Math.pow(edge, 3)) / 4;

        System.out.printf("The volume of the dodecahedron = %s", volume);

        scanner.close();
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
