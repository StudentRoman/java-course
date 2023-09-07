package com.mycompany.app;

public class Elevator {
    private int id;
    private int currentFloor = 1;

    public Elevator(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    @Override
    public String toString() {
        return "Elevator " + (this.id + 1) + " arrived at " + this.currentFloor + " floor";
    }
}