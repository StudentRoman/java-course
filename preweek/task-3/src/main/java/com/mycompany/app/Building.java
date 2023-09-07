package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Building {
    private ArrayList<Elevator> elevatorList = new ArrayList<>();
    private int floorCount = 9;
    private int elevatorCount = 3;

    public Building() {
        IntStream.range(0, this.elevatorCount).forEach(elevatorId -> elevatorList.add(new Elevator(elevatorId)));
    }

    public Building(int floorCount, int elevatorCount) {
        this.floorCount = floorCount;
        this.elevatorCount = elevatorCount;

        IntStream.range(0, elevatorCount).forEach(elevatorId -> elevatorList.add(new Elevator(elevatorId)));
    }

    public String callElevator(int selectedFloor) {
        if (!isValidFloor(selectedFloor)) {
            return null;
        }

        Elevator currentElevator = this.moveElevator(selectedFloor);

        return String.valueOf(currentElevator);
    }

    private Elevator moveElevator(int selectedFloor) {
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

        Elevator currentElevator = elevatorList.get(nearestFloorElevator);
        currentElevator.setCurrentFloor(selectedFloor);

        return currentElevator;
    }

    private boolean isValidFloor(int selectedFloor) {
        return selectedFloor >= 1 & selectedFloor <= this.floorCount;
    }

    public int distanceToFloor(int newFloor, int currentFloor) {
        return Math.abs(newFloor - currentFloor);
    }

    private int findNearestFloor(List<Elevator> elevatorsList, int floor) {
        int result = -1;

        for (int i = 0; i < elevatorsList.size() - 1; i++) {
            Elevator currentElevator = elevatorsList.get(i);
            Elevator nextElevator = elevatorsList.get(i + 1);

            if (this.distanceToFloor(floor, currentElevator.getCurrentFloor()) <= this.distanceToFloor(floor, nextElevator.getCurrentFloor())) {
                result = currentElevator.getId();
            } else {
                result = nextElevator.getId();
            }
        }

        return result;
    }
}
