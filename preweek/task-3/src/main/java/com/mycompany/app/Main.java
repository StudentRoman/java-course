package com.mycompany.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Building building = new Building();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("You clicked at floor ");
            String userInput = scanner.nextLine();

            if (!userInput.equals("*")) {
                if (!isValidInput(userInput)) {
                    System.out.println("Wrong input format, try again");
                    continue;
                }

                String callElevatorResult = building.callElevator(Integer.parseInt(userInput));

                if (callElevatorResult == null) {
                    System.out.printf("Cant send elevator to %s floor, sorry \n", userInput);
                } else {
                    System.out.println(callElevatorResult);
                }
            } else {
                scanner.close();
                break;
            }
        }
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