package edu.penzgtu.oop;

import java.util.Scanner;
import java.util.InputMismatchException;

public class DodecahedronVolume {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the edge length ");

            int edge = scanner.nextInt();
            double volume = ((15 + 7 * Math.sqrt(5)) * Math.pow(edge, 3)) / 4;

            System.out.printf("The volume of the dodecahedron = %s", volume);
        } catch (InputMismatchException e) {
            System.out.printf("Wrong input format: %s", e.getClass());
        }

        scanner.close();
    }
}
