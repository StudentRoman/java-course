package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static final int COUNT_FLOOR;

    static {
        COUNT_FLOOR = 9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Elevator> elevatorList = new ArrayList<>();
        IntStream.range(0, 3).forEach(elevatorId -> elevatorList.add(new Elevator(elevatorId)));

        while (true) {
            System.out.print("You clicked at floor ");
            String userInput = scanner.nextLine();

            if (!userInput.equals("*")) {
                if (!isValidFloor(userInput)) {
                    System.out.println("Wrong input format, try again");
                    continue;
                }

                int selectedFloor = Integer.parseInt(userInput);

                if (!(selectedFloor >= 1 & selectedFloor <= COUNT_FLOOR)) {
                    System.out.printf("Cant send elevator to %d floor, sorry \n", selectedFloor);
                    continue;
                }

                int nearestFloorElevator = -1;
                Elevator elevatorTemp;
                List<Elevator> suitableElevators = new ArrayList<>(elevatorList);
                long countSuitableElevators = suitableElevators.stream().filter(elevator -> elevator.getCurrentFloor() == 1).count();

                if (elevatorList.size() == countSuitableElevators) {
                    elevatorTemp = suitableElevators.stream().findFirst().get();
                    nearestFloorElevator = elevatorTemp.getId();
                } else if (elevatorList.size() > countSuitableElevators) {
                    suitableElevators = suitableElevators.stream().sorted((s1, s2) -> s1.getCurrentFloor() - s2.getCurrentFloor()).skip(1).collect(Collectors.toList());
                    nearestFloorElevator = findNearestFloor(suitableElevators, selectedFloor);
                } else {
                    suitableElevators = suitableElevators.stream().filter(it -> it.getCurrentFloor() != 1).collect(Collectors.toList());
                    nearestFloorElevator = findNearestFloor(suitableElevators, selectedFloor);
                }

                elevatorList.get(nearestFloorElevator).setCurrentFloor(selectedFloor);
                System.out.println(elevatorList.get(nearestFloorElevator).getResultString());
            } else {
                scanner.close();
                break;
            }
        }
    }

    private static boolean isValidFloor(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int findNearestFloor(List<Elevator> elevatorsList, int floor) {
        int result = -1;

        for (int i = 0; i < elevatorsList.size() - 1; i++) {
            if (elevatorsList.get(i).distanceToFloor(floor) <= elevatorsList.get(i + 1).distanceToFloor(floor)) {
                result = elevatorsList.get(i).getId();
            } else {
                result = elevatorsList.get(i + 1).getId();
            }
        }

        return result;
    }
}