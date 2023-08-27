package com.mycompany.app;

public class Elevator {
    private int id;
    private int currentFloor;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 1;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int distanceToFloor(int newFloor) {
        return Math.abs(newFloor - this.currentFloor);
    }

    public String getResultString() {
        return "Elevator " + (this.id + 1) + " arrived at " + this.currentFloor + " floor";
    }
}